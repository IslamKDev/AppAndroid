package fr.univ_reims.informatique.islam.shareit.controleur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LocalSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String nameDataBase = "Shareit.db";
/*
    public LocalSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
*/

    public LocalSQLiteOpenHelper(Context context) {
        super(context, nameDataBase, null, 1);
    }
/*
    public LocalSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }
    */

    /*
    public LocalSQLiteOpenHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }
    */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table profil (id INTEGER PRIMARY KEY AUTOINCREMENT, nom text NOT NULL, prenom text NOT NULL, email text NOT NULL, nomUtilisateur text NOT NULL, motDePasse text NOT NULL);";db.execSQL(sql);
        //db.execSQL("create table utilisateur (id INTEGER PRIMARY KEY AUTOINCREMENT, nom text NOT NULL, prenom text NOT NULL, email text NOT NULL, nomUtilisateur text NOT NULL, motDePasse text NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists profil");
    }

    public Boolean insertData(String nom, String prenom, String email, String nomUtilisateur, String motDePasse){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nom",nom);
        contentValues.put("prenom", prenom);
        contentValues.put("email", email);
        contentValues.put("nomUtilisateur", nomUtilisateur);
        contentValues.put("motDePasse", motDePasse);

        long result = db.insert("profil",null,contentValues);
        if(result==-1)
        {
            return false;
        } else{
            return true;
        }
    }
    public Boolean verification_nomUtilisateur(String nomUtilisateur){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM profil WHERE nomUtilisateur = ?", new String[]{nomUtilisateur});
        if(cursor.getCount()>0)
        {
            return true;
        }else{
            return false;
        }
    }

    public Boolean verification_motDePasse(String nomUtilisateur, String motDePasse){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM profil WHERE nomUtilisateur = ? AND motDePasse = ?", new String[]{nomUtilisateur, motDePasse});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }
}
