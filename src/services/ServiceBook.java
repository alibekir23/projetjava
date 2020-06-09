/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Elit.utils.Copy;
import entities.book;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import utils.ConnexionBD;

/**
 *
 * @author user
 */
public class ServiceBook {
    
    private static ServiceBook instance;
    public static ServiceBook getInstance() {
   if(instance==null) 
            instance=new ServiceBook();
        return instance;    }

    private Connection con;
    private Statement ste;

    public ServiceBook() {
        con = ConnexionBD.getInstance().getCnx();
    }
    
    public void ajout (book b){
        try {
            String req = "INSERT INTO book (category,Title,author,Description,imagebook ,isbn,nbrbooks) VALUES "
                    + "('" + b.getCategory()+ "', '" + b.getTitle() + "', '" + b.getAuthor() + "', '" + b.getDescription() + "', '" + b.getImagebook() + "', '" + b.getISBN() + "', '" + b.getNbrbooks() +"')";

            ste = con.createStatement();
            ste.executeUpdate(req);
            System.out.println("Insertion Reussie!");
// ajout image, avec un id unique    
            UUID u = UUID.randomUUID();
            String logo= b.getImagebook();
            String old = logo;
            String extension = logo.substring(logo.lastIndexOf("."));
           logo = logo.substring(logo.lastIndexOf("\\")+1,logo.lastIndexOf("."));
           logo = logo + u.toString() + extension;
          // fin ajout image
          //deplacement vers le dossier du serveur web
            File source = new File(old);
            File dest = new File("D:\\wamp64\\www\\PIDEV2020_ELIT_3A177\\PIDEV2020_ELIT_3A17\\web\\imageheni\\"+logo);
         
            try {
                Copy.copyFileUsingStream(source,dest);
                //fin deplacement
            } catch (IOException ex) {
                Logger.getLogger(ServiceBook.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
      public  ObservableList AddCombcategory(){
         ObservableList options=FXCollections.observableArrayList();
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select distinct name_category from categorybook");
     while (rs.next()) {
         options.add(rs.getString("name_category"));
         
         
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return options;
     }
    
    
 public int getID(String categoryy){
      int G=0;
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select distinct id_category from categorybook where name_category ='" + categoryy + "'");
     while (rs.next()) {
          G=(rs.getInt("id_category"));
         
         
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
     return G;
 }   
 
  public String getNom(int id){
      String G="";
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select distinct name_category from categorybook where id_category =" + id + "");
     while (rs.next()) {
          G=(rs.getString("name_category"));
         
         
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
     return G;
 }   
    public List<book> readAll() throws SQLException {
 
            List<book> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from book");
     while (rs.next()) {                
              
               int idbook=rs.getInt("id_book");   
               
               int category=rs.getInt("category");  
    
           int NBRBOOK=rs.getInt("nbrbooks");     
           int ISBN=rs.getInt("isbn");  

               String author=rs.getString("author");
               String description=rs.getString("Description");
               String imagebook=rs.getString("imagebook");

               String Title=rs.getString("Title");
               
               book m=new book(idbook,category,Title,author,description,imagebook,ISBN,NBRBOOK);
     arr.add(m);
     }
    return arr;
        
            }
    
       public void delete(book b)  {
    
            String sql = "DELETE FROM `java`.`book` where (id_book ="+b.getId_book()+");";
  
    try {
        
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
          
      
    
    
    }
    catch (SQLException ex) {
             // SQLException occured.
    // There could be multiple error objects chained together
    System.out.println ("*** SQLException caught ***");
    while (ex != null) {
      System.out.println ("SQLState: " + ex.getSQLState () + "");
      System.out.println ("Message: " + ex.getMessage() + "");
      System.out.println ("Vendor ErrorCode: " + ex.getErrorCode() + "");
      ex = ex.getNextException();
      System.out.println("");
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Can't delete book! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
}
