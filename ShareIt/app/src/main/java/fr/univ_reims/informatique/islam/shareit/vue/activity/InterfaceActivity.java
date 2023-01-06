package fr.univ_reims.informatique.islam.shareit.vue.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.core.view.GravityCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import fr.univ_reims.informatique.islam.shareit.R;
import fr.univ_reims.informatique.islam.shareit.databinding.ActivityInterfaceBinding;
import fr.univ_reims.informatique.islam.shareit.modele.IPhotoActivity;
import fr.univ_reims.informatique.islam.shareit.modele.IStockageActivity;
import fr.univ_reims.informatique.islam.shareit.vue.fragment.AccueilFragment;
import fr.univ_reims.informatique.islam.shareit.vue.fragment.StockageFragment;

public class InterfaceActivity extends AppCompatActivity {
    // constante
    private static final int RETOUR_PHOTO = 1;
    // propriete
    private ActivityInterfaceBinding binding;
    private FloatingActionButton buttonFloating;
    private ImageView imgView;
    private String photoPath = null;
    private Bitmap image;
    private BottomNavigationView navigationBottom;
    private BottomAppBar appBar;
    private TextView utilisateur;
    private String nomUtilisateur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInterfaceBinding.inflate(getLayoutInflater());
        //Test
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_interface);
        utilisateur=findViewById(R.id.utilisateur);
        nomUtilisateur=getIntent().getStringExtra(nomUtilisateur);
        //utilisateur.setText(nomUtilisateur);
        appBar=findViewById(R.id.bar_navigation_bottom);
        setSupportActionBar(appBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        //Navigation
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        //NavController navController = Navigation.findNavController(this, R.id.fragmentInterfaceActivity);
        //NavigationUI.setupWithNavController(navigationView, navController);
        /*
        rFragment(new AccueilFragment());
        binding.viewNavigationBottom.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.home:
                    rFragment(new AccueilFragment());
                    break;
                case R.id.media:
                    rFragment(new MediaFragment());
                    break;
                case R.id.contact:
                    rFragment(new ContactFragment());
                    break;
                case R.id.message:
                    rFragment(new MessageFragment());
                    break;
            }
            return true;
        });
        */
        navigationBottom = findViewById(R.id.viewNavigationBottom);
        navigationBottom.setBackground(null);
        //navigationBottom.getMenu().getItem(2).isEnabled();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
              R.id.home, R.id.media, R.id.contact, R.id.message).build();
        /**
         * Todo: probleme android studio does not have a NavController
         * probleme regler
         */
        //NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentInterfaceActivity);
        //NavController navigationController = navHostFragment.getNavController();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentInterfaceActivity);
        assert navHostFragment != null;
        NavController navigationController = navHostFragment.getNavController();
        //NavController navigationController = Navigation.findNavController(this,R.id.fragmentInterfaceActivity);
        /**
         * TODO: probleme does not have an ActionBar set via setSupportActionBar()
         * probleme regler
         */
        NavigationUI.setupActionBarWithNavController(this, navigationController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.viewNavigationBottom, navigationController);
        //NavigationUI.setupWithNavController(this.navigationBottom, navigationController);
        //NavigationUI.setupWithNavController(navigationView, navigationController);
        //initialisationActivity();


        //Alerte
        AlertDialog.Builder alerteDeconnexion = new AlertDialog.Builder(InterfaceActivity.this);
        alerteDeconnexion.setTitle("Deconnexion ");
        alerteDeconnexion.setMessage("Voulez-vous vous déconnecter ?");
        alerteDeconnexion.setIcon(R.drawable.deconnecter);
        alerteDeconnexion.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Vous allez être déconnecter", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        alerteDeconnexion.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
            }
        });
        /*
        alerteDeconnexion.setNeutralButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
            }
        });
         */
    }
    @Override
    protected void onStart() {
        super.onStart();

    }
    private void rFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    }

}