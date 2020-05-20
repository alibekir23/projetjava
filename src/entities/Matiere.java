/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ali
 */
public class Matiere {
    int id_matiere;
    String nom_matiere;
    float coef_matiere;
    String description;
    String classe;

    public Matiere(int id_matiere, String nom_matiere, float coef_matiere, String classe, String description) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.coef_matiere = coef_matiere;
        this.description = description;
        this.classe = classe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Matiere() {
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Matiere(int id_matiere, String nom_matiere, float coef_matiere) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.coef_matiere = coef_matiere;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public float getCoef_matiere() {
        return coef_matiere;
    }

    public void setCoef_matiere(float coef_matiere) {
        this.coef_matiere = coef_matiere;
    }

    public Matiere(int id_matiere, String nom_matiere, float coef_matiere, String classe) {
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.coef_matiere = coef_matiere;
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Matiere{" + "id_matiere=" + id_matiere + ", nom_matiere=" + nom_matiere + ", coef_matiere=" + coef_matiere + ", description=" + description + ", classe=" + classe + '}';
    }

   

   
    
 
}
