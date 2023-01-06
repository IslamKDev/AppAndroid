package fr.univ_reims.informatique.islam.shareit.controleur;

import android.content.Context;
//bibliotheque volley permet de communiquer avec l'api
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Database {
    private Context context;
    RequestQueue queue;

    public Database(Context context)
    {
        this.context = context;
        this.queue = Volley.newRequestQueue(context);
    }


}
