package fr.univ_reims.informatique.islam.shareit.modele;

import android.graphics.Bitmap;

public interface IStockageActivity {
    //Lire
    int REQUEST_MEDIA_READ = 1000;
    //Ecrire
    int REQUEST_MEDIA_WRITE = 1001;

    void onPhotoCharge(Bitmap bitmap);
    Bitmap getPhotoSauvegarder();
}
