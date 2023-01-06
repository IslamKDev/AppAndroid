/*
* App Android
* @name : ShareIt
* @author : Islam
* @date : 2022-11-10
*
*/

package fr.univ_reims.informatique.islam.shareit.vue.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.controleur.LocalSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity {
    //private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;
    //
    private Button connexionBouton;
    private CheckBox affichageMotPasseCheckBox;
    private EditText nomUtilisateurEditText;
    private EditText motDePasseEditText;
    private String nomUtilisateur;
    private String motDePasse;
    private TextView inscriptionBouton;
    private TextView erreurConnexionTextView;
    private LocalSQLiteOpenHelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inscriptionBouton = findViewById(R.id.lienVersLaPageInscriptionTextView);
        erreurConnexionTextView = findViewById(R.id.erreurConnexionTextView);
        nomUtilisateurEditText = findViewById(R.id.nomUtilisateurConnexionTextView);
        motDePasseEditText = findViewById(R.id.motDePasseConnexionTextView);
        connexionBouton = findViewById(R.id.connexionBouton);
        affichageMotPasseCheckBox = findViewById(R.id.connexionMotDePasseCheckBox);
        //database = new Database(getApplicationContext());
        DB = new LocalSQLiteOpenHelper(this);
        if(savedInstanceState !=null){
            String [] profil = savedInstanceState.getStringArray("profil");
            for(String s : profil){

            }
        }
        /*
        //Initialise Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    Log.d(TAG, "onAuthStateChanged: signed_in" + user.getUid());
                }else{
                    Log.d(TAG, "onAuthStateChanged: signed_out");
                }
            }
        };
        */



        affichageMotPasseCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if (isChecked){
                   // Pour montrer le mot de passe
                    motDePasseEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
              }else{
                  // Pour masquer le mot de passe
                    motDePasseEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
              }
            }
        });

        connexionBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomUtilisateur = nomUtilisateurEditText.getText().toString();
                motDePasse = motDePasseEditText.getText().toString();
                if(nomUtilisateur.equals("")||motDePasse.equals("")){
                    Toast.makeText(MainActivity.this,"SVP remplire tous les champs",Toast.LENGTH_LONG).show();
                }else{
                    Boolean checkUtilisateur = DB.verification_motDePasse(nomUtilisateur,motDePasse);
                    if(checkUtilisateur==true){
                        Toast.makeText(MainActivity.this,"Connexion Réussi",Toast.LENGTH_LONG).show();
                        Intent interfaceActivity = new Intent(getApplicationContext(), InterfaceActivity.class);
                        interfaceActivity.putExtra("nomUtilisateur", nomUtilisateur);
                        startActivity(interfaceActivity);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this,"Accréditation non valide",Toast.LENGTH_LONG).show();
                    }
                }
                //connectionUtilisateur();

            }
        });

        inscriptionBouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrationActivity = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(registrationActivity);
                finish();
            }
        });
    }






/*
    public void apiReponse(JSONObject reponse){
        Boolean success=null;
        String error="";
        try {
            success=reponse.getBoolean("success");
            if(success == true)
            {
                Intent interfaceActivity = new Intent(getApplicationContext(), InterfaceActivity.class);
                interfaceActivity.putExtra("username", nomUtilisateur);
                startActivity(interfaceActivity);
                finish();
            }
            else
            {
                error=reponse.getString("error");
                erreurConnexionTextView.setVisibility(View.VISIBLE);
                erreurConnexionTextView.setText(error);
            }
        }catch(JSONException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void connectionUtilisateur(){
        String url="http://192.168.43.139:8080/apiShareIt/actions/connexionUtilisateur.php";

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url= new URL("http://192.168.126.1:8080/apiShareIt/actions/connexionUtilisateur.php");
                    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
                    httpConn.setRequestMethod("GET");

                    Log.d("geogeo", "iciiii");
                    Log.d("geogeo", httpConn.getResponseCode()+"");
                }
                catch(IOException ioe){
                    Log.d("geogeo", ioe.getMessage());
                }
            }
        });
        t.start();


        //Map<String, String> parametre = new HashMap<>();
        //parametre.put("username", nomUtilisateur);
        //parametre.put("password", motDePasse);
        //Transformation en json
        JSONObject parametreJson = new JSONObject(parametre);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parametreJson, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                apiReponse(response);
                Toast.makeText(getApplicationContext(), "La connexion est validé ", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        database.queue.add(jsonObjectRequest);
    }
    */
}