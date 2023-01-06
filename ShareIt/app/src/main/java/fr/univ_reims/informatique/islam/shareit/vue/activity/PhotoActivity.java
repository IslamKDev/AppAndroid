package fr.univ_reims.informatique.islam.shareit.vue.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.modele.IPhotoActivity;
import fr.univ_reims.informatique.islam.shareit.modele.IStockageActivity;
import fr.univ_reims.informatique.islam.shareit.vue.fragment.AccueilFragment;
import fr.univ_reims.informatique.islam.shareit.vue.fragment.PhotoFragment;
import fr.univ_reims.informatique.islam.shareit.vue.fragment.StockageFragment;

public class PhotoActivity extends AppCompatActivity implements IPhotoActivity, IStockageActivity {
    private Bitmap image;
    private PhotoFragment photoFragment;
    private StockageFragment stockageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        photoFragment = (PhotoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentPhoto);
        if (photoFragment == null){
            photoFragment =  new PhotoFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentPhoto, photoFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        stockageFragment = (StockageFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentStockage);
        if(stockageFragment == null){
            stockageFragment = new StockageFragment(this);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragmentStockage, stockageFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
    /**
     * Callback permission
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int [] grantResults ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PHOTO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "L'appareil à photo est autoriser", Toast.LENGTH_LONG).show();
                    photoFragment.prendrePhoto();

                } else {
                    Toast.makeText(getApplicationContext(), "Nous n'avons pas l'autorisation pour l'appareil a photo", Toast.LENGTH_LONG).show();
                }
            }
            break;
            case REQUEST_MEDIA_READ:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "L'appareil est autoriser à lire", Toast.LENGTH_LONG).show();
                    stockageFragment.chargerPhotoDansStockage();
                } else {
                    Toast.makeText(getApplicationContext(), "Nous n'avons pas l'autorisation pour lire", Toast.LENGTH_LONG).show();
                }
            }
            break;
            case REQUEST_MEDIA_WRITE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "L'appareil est autoriser à ecrire", Toast.LENGTH_LONG).show();
                    stockageFragment.sauvegarderPhotoDansStockage(image);
                } else {
                    Toast.makeText(getApplicationContext(), "Nous n'avons pas l'autorisation pour ecrire", Toast.LENGTH_LONG).show();
                }
            }
            break;
        }
    }

    /**
     * callback Activity
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_PHOTO){
            if (resultCode == RESULT_OK){
                image = (Bitmap) data.getExtras().get("data");
                photoFragment.setImage(image);
                stockageFragment.setEnableSauvegardeButton();
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
        }
    }
    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                Toast.makeText(PhotoActivity.this,"Erreur",Toast.LENGTH_LONG).show();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                //startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    @Override
    public void onPhotoCharge(Bitmap bitmap) {
        photoFragment.setImage(bitmap);
    }

    @Override
    public Bitmap getPhotoSauvegarder() {
        return image;
    }
}