/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import entities.Note;
import IService.IServiceNote;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import utils.ConnexionBD;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Ali
 */
public class ServiceNote implements IServiceNote<Note> {

    private static ServiceNote instance;
    public static ServiceNote getInstance() {
   if(instance==null) 
            instance=new ServiceNote();
        return instance;    }

    private Connection con;
    private Statement ste;

    public ServiceNote() {
        con = ConnexionBD.getInstance().getCnx();

    }

  
    public Note find(String nom_eleve,String prenom_eleve,String matiere,String classe,double note ) 
    {   Note S= new Note();
     
      float f = (float)note;
           
          try{
            
                  String req4="select e.id,m.id from user e,module m where e.lastname='" + nom_eleve + "' and e.fistname='" + prenom_eleve + "' and m.title='" + matiere + "'";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
            
            
            
            
          
                while (rs.next()) {   
            // int id_eleve=rs.getInt("e.id_eleve");
                  //id_matiere=rs.getInt("m.id_matiere");
                  // int id_exam=rs.getInt("x.id_examen");
                  // n=new Note(id_eleve,id_exam,id_matiere,f);
                  
                    
             S.setId_eleve(rs.getInt(1));
                 //   S.setId_examen(rs.getInt("x.id_examen"));
                    S.setId_matiere(rs.getInt(2));
                    S.setNote(f);
                
                    System.out.println("ghjhg");
                 
                
          
           
            return S;
                }
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;      
     
    }
    
    
    public void ajouter(Note t)  {
        try{
        ste = con.createStatement();
        
        String requeteInsert = "INSERT INTO `java`.`note` (`id_eleve`,`id_matiere`,`note`,`id_note`) VALUES ('" + t.getId_eleve() + "','" + t.getId_matiere() + "','" + t.getNote() + "','" + t.getId_note()+ "');";
        ste.executeUpdate(requeteInsert);
         SQLWarning w = ste.getWarnings();
       
                 
           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("Note Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showConfirm();
         
           }
           
        } catch (SQLException ex) {
             // SQLException occured.
    // There could be multiple error objects chained together
    System.out.println ("*** SQLException caught ***");
    while (ex != null) {
      System.out.println ("SQLState: " + ex.getSQLState () + "");
      System.out.println ("Message: " + ex.getMessage() + "");
      System.out.println ("Vendor ErrorCode: " + ex.getErrorCode() + "");
      ex = ex.getNextException();
      System.out.println("");
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Note already exists! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
   
            


    public void delete(Note t) throws SQLException {
        String sql = "DELETE FROM `java`.`note` where (id_note ="+t.getId_note()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
           
           
                 Notifications notificationBuilder = Notifications.create().title("Success !").text("Note deleted Successfully").graphic(null).darkStyle().position(Pos.CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showConfirm();
          
                   } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
    }
    

    }
    public boolean update(int id,float n)  {
        
          String sql ="UPDATE `java`.`note` SET `note`='"+ n + "' WHERE `id_note`='"+ id +"' ";
  
    try {
            Statement stl = con.createStatement();
           int rs =stl.executeUpdate(sql);
                   
            SQLWarning w = stl.getWarnings();
        System.out.println("ok");
        
        
      
            

            
        
         
           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("Note Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showConfirm();
         return true;
           }
           
        } catch (SQLException ex) {
             // SQLException occured.
    // There could be multiple error objects chained together
    System.out.println ("*** SQLException caught ***");
    while (ex != null) {
      System.out.println ("SQLState: " + ex.getSQLState () + "");
      System.out.println ("Message: " + ex.getMessage() + "");
      System.out.println ("Vendor ErrorCode: " + ex.getErrorCode() + "");
      ex = ex.getNextException();
      System.out.println("");
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Note cannot be registered! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
      return false;  }     
        
        
        
       
   return true;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }

   
    public List<Note> readAll() throws SQLException {
    List<Note> arr=new ArrayList<>();
    Integer id=2;
    String n="student";
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select u.username,u.email,c.name from user u,classes c where u.type='" + n + "' and u.idClass=c.id");
     while (rs.next()) {                
            //   int id_note=rs.getInt(1);
              // String nom_matiere=rs.getString("m.nom_matiere");
              // int coef=rs.getInt("m.coef_matiere");
              // int note=rs.getInt("n.note");
               String nom_etudiant=rs.getString("u.username");
                String prenom_etudiant="qsdfdsd";
                 String mail=rs.getString("u.email");
                  String classe=rs.getString("c.name");
                  
              
              
             
               Note e=new Note(nom_etudiant,prenom_etudiant, mail,classe);
     arr.add(e);
     }
    return arr;
    }
       
    
   @Override
    public List<Note> readAll2(String e) throws SQLException {
        List<Note> arr=new ArrayList<>();

       String nom=e.substring(0,e.indexOf(" "));
         String prenom=e.substring(e.indexOf(" ")+1,e.length());
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select n.id_note,m.title,m.coef_matiere,n.note from note n,module m,user e where n.id_matiere=m.id and e.id=n.id_eleve and e.lastname='" + nom + "' and  e.fistname='" + prenom + "';");
     while (rs.next()) {                
              int id_note=rs.getInt(1);
               String nom_matiere=rs.getString("m.title");
               int coef=rs.getInt("m.coef_matiere");
              float note1=rs.getInt("n.note");
               //String nom_etudiant=rs.getString("nom");
                //String prenom_etudiant=rs.getString("prenom");
                // String mail=rs.getString("mail");
                 // String classe=rs.getString("classe");
                  
        
              
             
               Note e1=new Note(id_note,nom_matiere,coef,note1);
     arr.add(e1);
     }
    return arr; 

    }   
    
    
    
    public List<Note> readAllS(String e) throws SQLException {
        List<Note> arr=new ArrayList<>();

      
         
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select n.id_note,m.title,m.coef_matiere,n.note from note n,module m,user u where n.id_matiere=m.id and u.id=n.id_eleve and u.email='" + e + "';");
     while (rs.next()) {                
              int id_note=rs.getInt(1);
               String nom_matiere=rs.getString("m.title");
               int coef=rs.getInt("m.coef_matiere");
              float note1=rs.getInt("n.note");
               //String nom_etudiant=rs.getString("nom");
                //String prenom_etudiant=rs.getString("prenom");
                // String mail=rs.getString("mail");
                 // String classe=rs.getString("classe");
                  
        
              
             
               Note e1=new Note(id_note,nom_matiere,coef,note1);
     arr.add(e1);
     }
    return arr; 

    }   
    
    
    
    
    
    
     public  ObservableList AddCombo(String classe){
         ObservableList options=FXCollections.observableArrayList();
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select u.lastname,u.fistname from user u,Classes c where idClass=c.id and c.name='" + classe + "'");
     while (rs.next()) {
       String nom=rs.getString("u.lastname");
        String prenom=rs.getString("u.fistname");
         
           options.add(nom+" "+prenom);
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return options;
     } 
     
         public  ObservableList AddCombo4(String classe){
         ObservableList options=FXCollections.observableArrayList();
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select distinct classe from eleve where classe like '" + classe + "'");
     while (rs.next()) {
       String classee=rs.getString("classe");
  
         
           options.add(classee);
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return options;
     } 
     
      public  ObservableList AddCombo2(String eleve,String classe){
         ObservableList options=FXCollections.observableArrayList();
         String C=classe.substring(0,1);
           String nom=eleve.substring(0,eleve.indexOf(" "));
         String prenom=eleve.substring(eleve.indexOf(" ")+1,eleve.length());
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select title from module where niveau='" + C + "'");
     while (rs.next()) {
         options.add(rs.getString("title"));
         
         
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return options;
     } 
      
         public  ObservableList AddCombo3(){
         ObservableList options=FXCollections.observableArrayList();
        try {
            ste=con.createStatement();
             ResultSet rs=ste.executeQuery("select distinct name from classes");
     while (rs.next()) {
         options.add(rs.getString("name"));
         
         
     }
     
     }  catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     return options;
     }
      
      
      
   
   
    
    
    
    
    
    
    
    
  public Note rechercheNoteParid_eleve(int id_eleve)
 {  Note S = new Note();
      
           try {
            
                 String req4="SELECT * FROM esprit.`note` WHERE id_eleve='" + id_eleve + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
             S.setId_eleve(rs.getInt("id_eleve"));
                    S.setId_examen(rs.getInt("id_examen"));
                    S.setId_matiere(rs.getInt("id_matiere"));
                    S.setNote(rs.getFloat("note"));
                 S.setId_note(rs.getInt("id_note"));
                 
                  System.out.println("ok");
             
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceNote.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;
 }

  
}
