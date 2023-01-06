package fr.univ_reims.informatique.islam.shareit.vue.activity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import fr.univ_reims.informatique.islam.shareit.R;

public class TestActivity extends AppCompatActivity {
    private EditText contactEditText;
    public static Context contextOfApplication;

    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        contextOfApplication = getApplicationContext();
        recuperationDesContacts();

    }
    public void recuperationDesContacts(){
        //Acces au contenu
        ContentResolver contentResolver = this.getContentResolver();
        //Recup contact
        Cursor curseur = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE, ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null);
        //Verification si le curseur contient quelque chose
        if(curseur == null){
            Log.d("recuperation contact", "erreur curseur");
        }else{
            //Parcours des contacts
            while(curseur.moveToNext()){
                @SuppressLint("Range") String nom = curseur.getString(curseur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                @SuppressLint("Range") String numeroPhone = curseur.getString(curseur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //Affichage des contacts
                contactEditText.setText(contactEditText.getText().toString() + "\n\r" + nom + " : " + numeroPhone);
            }
            curseur.close();
        }
    }
}
