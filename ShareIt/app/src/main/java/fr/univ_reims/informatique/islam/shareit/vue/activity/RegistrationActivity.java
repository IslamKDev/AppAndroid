package fr.univ_reims.informatique.islam.shareit.vue.activity;

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

import androidx.appcompat.app.AppCompatActivity;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.controleur.LocalSQLiteOpenHelper;

public class RegistrationActivity extends AppCompatActivity {
    private TextView lienVersLaPageConnexionBtn;
    private TextView erreurInscriptionTextView;

    private Button inscriptionBtn;

    private EditText nomEditText;
    private EditText prenomEditText;
    //private DatePicker dateDatePicker;
    private EditText emailEditText;
    private EditText nomUtilisateurEditText;
    private EditText motDePasseEditText;
    private EditText checkmotDePasseEditText;

    private CheckBox afficherMotPasseCheckBox;

    private String nom;
    private String prenom;
    //private Date date_de_naissance;
    private String email;
    private String nomUtilisateur;
    private String motDePasse;
    private String checkmotDePasse;
    //Base de donnée
    private LocalSQLiteOpenHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //getSupportActionBar().hide();
/*
        DatePicker dp = (DatePicker) findViewById(R.id.dateRegistrationDatePicker);
        dp.setMaxDate(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        dp.setMinDate(c.getTimeInMillis());
*/
        /**
         *
         */
        lienVersLaPageConnexionBtn = findViewById(R.id.lienVersLaPageConnexionTextView);
        erreurInscriptionTextView = findViewById(R.id.erreurRegistrationTextView);
        inscriptionBtn = findViewById(R.id.registrationButton);
        nomEditText = findViewById(R.id.nomRegistrationEditText);
        prenomEditText = findViewById(R.id.prenomRegistrationEditText);
        //dateDatePicker = findViewById(R.id.dateRegistrationDatePicker);
        emailEditText = findViewById(R.id.emailEditText);
        nomUtilisateurEditText = findViewById(R.id.usernameRegistrationEditText);
        motDePasseEditText = findViewById(R.id.password_EditText);
        checkmotDePasseEditText =findViewById(R.id.checkpasswordRegistrationEditText);
        afficherMotPasseCheckBox = findViewById(R.id.inscriptionMotDePasseCheckBox);

        DB = new LocalSQLiteOpenHelper(this);
        afficherMotPasseCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // Pour montrer le mot de passe
                    motDePasseEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    checkmotDePasseEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    // Pour masquer le mot de passe
                    motDePasseEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    checkmotDePasseEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        inscriptionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = nomEditText.getText().toString();
                prenom = prenomEditText.getText().toString();
                //date_de_naissance = dateDatePicker.get
                email = emailEditText.getText().toString();
                nomUtilisateur = nomUtilisateurEditText.getText().toString();
                motDePasse = motDePasseEditText.getText().toString();
                checkmotDePasse = checkmotDePasseEditText.getText().toString();
                if(nom.equals("")||prenom.equals("")||email.equals("")||nomUtilisateur.equals("")||motDePasse.equals("")||checkmotDePasse.equals("")){
                    Toast.makeText(RegistrationActivity.this,"SVP replire tous les champs", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(motDePasse.equals(checkmotDePasse)){
                        Boolean checkUtilisateur = DB.verification_nomUtilisateur(nomUtilisateur);
                        if(checkUtilisateur==false){
                            Boolean insert = DB.insertData(nom, prenom, email, nomUtilisateur, motDePasse);
                            if(insert==true){
                                Toast.makeText(RegistrationActivity.this, "Inscription Réussi", Toast.LENGTH_LONG).show();
                                Intent interfaceActivity = new Intent(getApplicationContext(), InterfaceActivity.class);
                                interfaceActivity.putExtra("nomUtilisateur", nomUtilisateur);
                                startActivity(interfaceActivity);
                                finish();
                            }else{
                                Toast.makeText(RegistrationActivity.this,"Inscription Echec", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(RegistrationActivity.this, "Nom d'utilisateur deja existant", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegistrationActivity.this,"Les champs mot de passe ne sont pas pareil ", Toast.LENGTH_LONG).show();
                    }
                }
                //creationCompte();
            }
        });

        lienVersLaPageConnexionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
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
                erreurInscriptionTextView.setVisibility(View.VISIBLE);
                erreurInscriptionTextView.setText(error);
            }
        }catch(JSONException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void creationCompte(){
        //http://192.168.43.139:8080/apiShareIt/actions/creationCompte.php
        String url="http://10.145.18.118:8080/apiShareIt/actions/creationCompte.php";
        Map<String, String> parametre = new HashMap<>();
        parametre.put("last_name", nom);
        parametre.put("first_name", prenom);
        //parametre.put("date_of_birth", date_de_naissance);
        parametre.put("email", email);
        parametre.put("username", nomUtilisateur);
        parametre.put("password", motDePasse);

        //Transformation en json
        JSONObject parametreJson = new JSONObject(parametre);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, parametreJson, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                apiReponse(response);
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