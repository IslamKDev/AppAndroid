package fr.univ_reims.informatique.islam.shareit.vue.fragment;

import android.Manifest;
import android.content.ContentValues;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.modele.IStockageActivity;

public class StockageFragment extends Fragment {
    private IStockageActivity iStockageActivity;
    private Button chargerPhoto;
    private Button sauvegarderPhoto;
    private String nomPhoto;
    private String cheminPhoto;
    // accesseur & mutateur
    public Button getChargerPhoto() {
        return chargerPhoto;
    }
    public void setChargerPhoto(Button chargerPhoto) {
        this.chargerPhoto = chargerPhoto;
    }

    public Button getSauvegarderPhoto() {
        return sauvegarderPhoto;
    }
    public void setSauvegarderPhoto(Button sauvegarderPhoto) {
        this.sauvegarderPhoto = sauvegarderPhoto;
    }

    public String getNomPhoto() {
        return nomPhoto;
    }
    public void setNomPhoto(String nomPhoto) {
        this.nomPhoto = nomPhoto;
    }

    public String getCheminPhoto() {
        return cheminPhoto;
    }
    public void setCheminPhoto(String cheminPhoto) {
        this.cheminPhoto = cheminPhoto;
    }
    //Constructeur
    public StockageFragment() {
        // Required empty public constructor
    }
    public StockageFragment(IStockageActivity iStockageActivity){
        this.iStockageActivity = iStockageActivity;
    }


    public static StockageFragment newInstance(String param1, String param2) {
        StockageFragment fragment = new StockageFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public   void setEnableSauvegardeButton(){
        sauvegarderPhoto.setEnabled(true);
    }
    public  void setEnableChargerButton(){
        chargerPhoto.setEnabled(true);
    }
    public void setDisableSauvegardeButton(){
        sauvegarderPhoto.setEnabled(false);
    }
    public void setDisableChargerButton(){
        chargerPhoto.setEnabled(false);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stockage, container, false);
        nomPhoto = "photo.jpg";
        ContextWrapper contextWrapper = new ContextWrapper(getContext());
        cheminPhoto = contextWrapper.getDir("photoDirectory", ContextWrapper.MODE_PRIVATE).getPath(); //Chemin
        sauvegarderPhoto = view.findViewById(R.id.sauvegarder);
        chargerPhoto = view.findViewById(R.id.charger);
        setDisableSauvegardeButton();
        sauvegarderPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap photo = iStockageActivity.getPhotoSauvegarder();
                if(photo != null){
                    if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                       //Demande permission
                        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},IStockageActivity.REQUEST_MEDIA_WRITE);
                    }else{
                        sauvegarderPhotoDansStockage(photo);
                        setDisableSauvegardeButton();
                    }
                }
            }
        });
        chargerPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                    //Demande permission
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},IStockageActivity.REQUEST_MEDIA_READ);
                }else{
                    iStockageActivity.onPhotoCharge(chargerPhotoDansStockage());
                    setDisableChargerButton();
                }
            }

        });
        return view;
    }

    public void sauvegarderPhotoDansStockage (Bitmap photo){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, nomPhoto);
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "photo/*");
        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, cheminPhoto);
        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "photo/jpeg");
        getActivity().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        File fichier = new File(cheminPhoto, nomPhoto);
        FileOutputStream fichierOutputStream = null;
        try {
            fichierOutputStream = new FileOutputStream(fichier);
            photo.compress(Bitmap.CompressFormat.JPEG,90,fichierOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bitmap chargerPhotoDansStockage() {

        try {
            File fichier = new File(cheminPhoto, nomPhoto);
            return BitmapFactory.decodeStream(new FileInputStream(fichier));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}