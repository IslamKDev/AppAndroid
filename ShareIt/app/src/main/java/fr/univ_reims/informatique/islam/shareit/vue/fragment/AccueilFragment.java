package fr.univ_reims.informatique.islam.shareit.vue.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.modele.IPhotoActivity;
import fr.univ_reims.informatique.islam.shareit.vue.activity.ContactActivity;
import fr.univ_reims.informatique.islam.shareit.vue.activity.PhotoActivity;

public class AccueilFragment extends Fragment {

    private Button buttonAppareilAPhoto;
    public AccueilFragment() {
    }


    public static AccueilFragment newInstance(String param1, String param2) {
        AccueilFragment fragment = new AccueilFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_accueil, container, false);
        // Inflate the layout for this fragment
        buttonAppareilAPhoto = (Button) rootView.findViewById(R.id.buttonAppareilAPhoto);
        buttonAppareilAPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoActivity = new Intent(getActivity(), PhotoActivity.class);
                startActivity(photoActivity);

            }
        });
        return rootView;
    }
}