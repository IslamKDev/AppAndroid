package fr.univ_reims.informatique.islam.shareit.vue.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.modele.IMessageActivity;

public class MessageActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, IMessageActivity{
    boolean canSendSMS = false;
    boolean canReceiveSMS = false;
    SmsManager smsManager = SmsManager.getDefault();
    String SMS_SEND = "SMS_SEND";
    Intent sendIntent = new Intent(SMS_SEND);
    //PendingIntent  sendPendingIntent = PendingIntent.getBroadcast(MessageActivity.this,0,sendIntent,0);
    private EditText saisiContact;
    private EditText message;
    private ImageButton envoie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                switch (result){
                    case RESULT_OK:
                        //Le SMS a été envoyé
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        //Erreur générale
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        //Erreur lors de l'inscription du SMS
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        //Erreur le telephone est en mode avion
                        break;
                }
            }
        }, new IntentFilter(SMS_SEND));
        initialisationActivity();
        ensurePermission();
    }
    private void initialisationActivity(){
        saisiContact = (EditText) findViewById(R.id.editTextPhone);
        message = (EditText) findViewById(R.id.editTextMessage);
        envoie = (ImageButton) findViewById(R.id.imageButton);
        createOnClickEnvoie();
    }

    private void createOnClickEnvoie(){
        envoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager.getDefault().sendTextMessage(saisiContact.getText().toString(),null,message.getText().toString(),null,null);
                Toast.makeText(MessageActivity.this,"Envoi...",Toast.LENGTH_LONG).show();
            }
        });
    }
    //Envoie message

    private void sendSMS(){
        //Capacité d'envoie des SMS à l'execution
        PackageManager packageManager = this.getPackageManager();
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY)){
            //Le telephone peut envoyer des sms
        }else{
            //Le telephone ne peut pas envoyer des sms
        }
    }

    private void ensurePermission(){
        canSendSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
        canReceiveSMS = ContextCompat.checkSelfPermission(this,Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED;
        if(!(canSendSMS && canReceiveSMS)){
            if(shouldShowRequestPermissionRationale(Manifest.permission.SEND_SMS) || shouldShowRequestPermissionRationale(Manifest.permission.RECEIVE_SMS)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Demande de la permission");
                builder.setMessage("La permission d'envoi et de réception de SMS sont nécessaire pour l'exécution de Share It. Voulez-vous réévaluer votre décision ?");
                builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        demanderPermissions();
                    }
                });
                builder.show();
            }else{
                demanderPermissions();
            }
        }
    }
    private void demanderPermissions(){
        String [] permissions = new String[]{
                Manifest.permission.SEND_SMS,
                Manifest.permission.RECEIVE_SMS
        };
        requestPermissions(permissions, REQUEST_ALL_PERMISSIONS);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if(requestCode == REQUEST_ALL_PERMISSIONS){
            for(int i=0; i<permission.length; i++){
                if(permission[i].equals(Manifest.permission.SEND_SMS) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    canSendSMS=true;
                }
                if (permission[i].equals(Manifest.permission.RECEIVE_SMS) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    canReceiveSMS=true;
                }
            }
        }
    }
}