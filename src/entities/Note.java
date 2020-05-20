/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Ali
 */
public class Note {
    int id_eleve;
    int id_examen;
    int id_matiere;

    public Note(float note, int id_note, String nom_matiere, int coef) {
        this.note = note;
        this.id_note = id_note;
        this.nom_matiere = nom_matiere;
        this.coef = coef;
    }
    float note;
    int id_note;
    String nom_etudiant;
    String prenom_etudiant;
    String mail;
    String classe;
    String nom_matiere;
    int coef;

    public Note(int id_eleve, int id_examen, int id_matiere, float note, int id_note, String nom_etudiant, String prenom_etudiant, String mail, String classe, String nom_matiere, int coef) {
        this.id_eleve = id_eleve;
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        this.id_note = id_note;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.mail = mail;
        this.classe = classe;
        this.nom_matiere = nom_matiere;
        this.coef = coef;
    }

    

    public Note(int id_note, String nom_matiere, int coef, float note1) {
       this.id_note=id_note;
       this.nom_matiere=nom_matiere;
       this.coef=coef;
       this.note=note1;
    }

    public String getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(String prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Note(String nom_etudiant, String prenom_etudiant, String mail, String classe) {
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.mail = mail;
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

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

    public Note(int id_eleve, int id_examen, int id_matiere, float note, int id_note, String nom_etudiant) {
        this.id_eleve = id_eleve;
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        this.id_note = id_note;
        this.nom_etudiant = nom_etudiant;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

   

    public int getId_eleve() {
        return id_eleve;
    }

    public int getId_examen() {
        return id_examen;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public float getNote() {
        return note;
    }

    public void setId_eleve(int id_eleve) {
        this.id_eleve = id_eleve;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    @Override
    public String toString() {
        return "Note{" + "id_eleve=" + id_eleve + ", id_examen=" + id_examen + ", id_matiere=" + id_matiere + ", note=" + note + ", id_note=" + id_note + ", nom_etudiant=" + nom_etudiant + ", prenom_etudiant=" + prenom_etudiant + ", mail=" + mail + ", classe=" + classe + ", nom_matiere=" + nom_matiere + ", coef=" + coef + '}';
    }

    public Note(float note, int id_note, String nom_etudiant, String prenom_etudiant, String mail, String classe, String nom_matiere, int coef) {
        this.note = note;
        this.id_note = id_note;
        this.nom_etudiant = nom_etudiant;
        this.prenom_etudiant = prenom_etudiant;
        this.mail = mail;
        this.classe = classe;
        this.nom_matiere = nom_matiere;
        this.coef = coef;
    }

    


      public Note(int id_eleve, int id_examen, int id_matiere, float note) {
        this.id_eleve = id_eleve;
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        
    }

    public Note(int id_eleve, int id_examen, int id_matiere, float note, int id_note) {
        this.id_eleve = id_eleve;
        this.id_examen = id_examen;
        this.id_matiere = id_matiere;
        this.note = note;
        this.id_note = id_note;
    }
  

    public Note() {
    }
    
    
    
}
