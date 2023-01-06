package fr.univ_reims.informatique.islam.shareit.modele;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

public class Profil implements Serializable {
    //propriétés d'un utilisateur
    private int id;
    private String nom;
    private String prenom;
    //private Date dateDeNaissance;
    private String email;
    private String nomUtilisateur;
    private String motDePasse;
    //private float img;
    //private String message;

    /**
     * Getter et setter des attributs de la classe
     * Profil
     *
     */
    //Accesseur & Mutateur de l'attribut id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //Accesseur & Mutateur de l'attribut nom
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    //Accesseur & Mutateur de l'attribut prenom
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    //Accesseur & Mutateur de l'attribut dateDeNaissance
    /*
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }
    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    */
    //Accesseur & Mutateur de l'attribut email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //Accesseur & Mutateur de l'attribut nomUtilisateur
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    //Accesseur & Mutateur de l'attribut nomDePasse
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    /*
    //Accesseur & Mutateur de l'attribut img
    public float getImg() {
        return img;
    }
    public void setImg(float img) {
        this.img = img;
    }
    */

    public Profil() {

    }

    public Profil(int id, String nom, String prenom, String email, String nomUtilisateur, String motDePasse){
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    @NonNull
    @Override
    public String toString() {
        return "Profil{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                '}';
    }

}
