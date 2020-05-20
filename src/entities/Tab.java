/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author ali
 */
public class Tab {
   
      int id_note;
       String nom_matiere;
       int coef;
       String nom_etudiant;
       String prenom_etudiant;
       String type;
       float note;

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
       public int getId_note() {
        return id_note;
    }

    public Tab(int id_note, String nom_matiere, int coef, String nom_etudiant, String prenom_etudiant, String type, float note) {
        this.id_note = id_note;
        this.nom_matiere = nom_matiere;
        this.coef = coef;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.type = type;
        this.note = note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public Tab() {
    }

    public Tab(String nom_matiere, int coef, String nom_etudiant, String prenom_etudiant, String type, float note) {
        this.nom_matiere = nom_matiere;
        this.coef = coef;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.type = type;
        this.note = note;
    }

    @Override
    public String toString() {
        return "tab{" + "nom_matiere=" + nom_matiere + ", coef=" + coef + ", nom_etudiant=" + nom_etudiant + ", prenom_etudiant=" + prenom_etudiant + ", type=" + type + ", note=" + note + '}';
    }
 
    

    
    
}
