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

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.modele.IPhotoActivity;

public class PhotoFragment extends Fragment {
    private ImageView imageView;
    //private FloatingActionButton buttonFloating;
    private TextView enregistreBoutton;
    private Button button;

    //Constructeur par défaut
    public PhotoFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_photo, container, false);
        //recup des objet
        //buttonFloating = (FloatingActionButton) getView().findViewById(R.id.buttonfloating);

        //enregistreBoutton = getView().findViewById(R.id.enregistreImage);
        //enregistreBoutton = rootView.findViewById(R.id.enregistreImage);
        imageView = rootView.findViewById(R.id.imageView);
        //Méthode
        rootView.findViewById(R.id.buttonPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //verification permission
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(getActivity(),new String []{Manifest.permission.CAMERA}, IPhotoActivity.REQUEST_PHOTO);
                }else{
                    prendrePhoto();
                }
            }
        });
        /*
        enregistreBoutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ENREGISTRE LA PHOTO
                // MediaStore.Images.Media.insertImage(getContentResolver(),imageView,"img","img");
            }
        });

         */
        return rootView;
    }
    public void prendrePhoto(){
        // creation d'un intent pour la fenetre pour prendre la photo
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        getActivity().startActivityForResult(intent, IPhotoActivity.REQUEST_PHOTO);
        //startActivityForResult(intent, IPhotoActivity.REQUEST_PHOTO);


    }

    public void setImage(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }
}