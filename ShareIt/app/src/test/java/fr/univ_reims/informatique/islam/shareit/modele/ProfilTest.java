package fr.univ_reims.informatique.islam.shareit.modele;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfilTest {
    //Profil
    private final Profil profil = new Profil(0,"Test","test","test@test.com","test","Test123.");
    //Resulat
    private String nom = (String) "Test4551" ;
    private String prenom = (String) "Test14185";
    private String email = (String) "testtestcom";
    @Test
    public void getNom() throws Exception {
        //assertEquals(nom, profil.getNom());
    }

    @Test
    public void getPrenom() throws Exception {
        //assertEquals(prenom, profil.getPrenom());
    }

    @Test
    public void getEmail() throws Exception{
        //assertEquals(email, profil.getEmail(), (String)"test@test.com");
    }

    @Test
    public void getNomUtilisateur() throws Exception{
    }

    @Test
    public void getMotDePasse() throws Exception {
    }
}