package fr.univ_reims.informatique.islam.shareit.vue.fragment;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

import fr.univ_reims.informatique.islam.shareit.R;

import fr.univ_reims.informatique.islam.shareit.vue.activity.ContactActivity;
import fr.univ_reims.informatique.islam.shareit.vue.activity.InterfaceActivity;

public class ContactFragment extends Fragment {
    private Button buttonContact;
    public ContactFragment() {
    }


    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        // Inflate the layout for this fragment
        buttonContact = (Button) rootView.findViewById(R.id.buttonContact);
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contactActivity = new Intent(getActivity(),ContactActivity.class);
                startActivity(contactActivity);

            }
        });
        return rootView;
    }
    /**
     * Recuperation des contacts
     */
    /*
    public void recuperationDesContacts(){
        //Acces au contenu
        ContentResolver contentResolver = contactActivity.getContentResolver();

        applicationContext.getContentResolver();
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
     */
}