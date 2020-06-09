/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class book {
    
    private int id_book ;
    private int category ;
    
    private String title ;
    private String author ;
    private String description ; 
    private String imagebook ;
    private int ISBN ;
    private int nbrbooks ;

    public int getId_book() {
        return id_book;
    }

    public book(int id_book, int category, String title, String author, String description, String imagebook, int ISBN, int nbrbooks) {
        this.id_book = id_book;
        this.category = category;
        this.title = title;
        this.author = author;
        this.description = description;
        this.imagebook = imagebook;
        this.ISBN = ISBN;
        this.nbrbooks = nbrbooks;
    }
public book (){

}

    @Override
    public String toString() {
        return "book{" + "id_book=" + id_book + ", category=" + category + ", title=" + title + ", author=" + author + ", description=" + description + ", imagebook=" + imagebook + ", ISBN=" + ISBN + ", nbrbooks=" + nbrbooks + '}';
    }


    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final book other = (book) obj;
        if (this.id_book != other.id_book) {
            return false;
        }
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagebook() {
        return imagebook;
    }

    public void setImagebook(String imagebook) {
        this.imagebook = imagebook;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getNbrbooks() {
        return nbrbooks;
    }

    public void setNbrbooks(int nbrbooks) {
        this.nbrbooks = nbrbooks;
    }
    
    
    
}
