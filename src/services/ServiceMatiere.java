/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Matiere;
import IService.IServiceMatiere;
import utils.ConnexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author ali
 */
public class ServiceMatiere implements IServiceMatiere <Matiere> {

    
    
    
    private static ServiceMatiere instance;
    public static ServiceMatiere getInstance() {
   if(instance==null) 
            instance=new ServiceMatiere();
        return instance;    }

    private Connection con;
    private Statement ste;

    public ServiceMatiere() {
        con = ConnexionBD.getInstance().getCnx();

    }
    
    
    
    
    
    
    @Override
    public void ajouter(Matiere t) {
        
      try{
        ste = con.createStatement();
                String requeteInsert = "INSERT INTO `java`.`module` (`id`,`title`,`coef_matiere`,`niveau`,`description`) VALUES ('" + t.getId_matiere() + "', '" + t.getNom_matiere()+ "','" + t.getCoef_matiere() + "','" + t.getClasse() + "','" + t.getDescription() + "');";

        ste.executeUpdate(requeteInsert);
         SQLWarning w = ste.getWarnings();
        System.out.println("ok");
        
        
      
            

            
        
         
           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("Module Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Module already exists! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        
        
       
   
    }
    
    
    
    
    
    
    
    
    

    @Override
    public void delete(Matiere t)  {
    
            String sql = "DELETE FROM `java`.`module` where (id ="+t.getId_matiere()+");";
   //String sql = "INSERT INTO fos_user(username) VALUES ('"+c.getUsername()+"');";
  
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Can't delete module! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }

    @Override
    public boolean update(Matiere t){

          try{
              System.out.println(t.getId_matiere());
        ste = con.createStatement();

                String requeteInsert = "update module set title='" + t.getNom_matiere()+ "', coef_matiere='" + t.getCoef_matiere() + "',niveau='" + t.getClasse() + "' where id='"+ t.getId_matiere() +"';";

        ste.executeUpdate(requeteInsert);
         SQLWarning w = ste.getWarnings();
        System.out.println("ok");
        
        
      
            

            
        
         
           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("Module Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Module already exists! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
      return false;  }     
        
        
        
       
   return true;
    }

    @Override
    public List<Matiere> readAll() throws SQLException {
 
            List<Matiere> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from module");
     while (rs.next()) {                
              
               int id_matiere=rs.getInt("id");     
               String nom_matiere=rs.getString("title");
               float coef_matiere=rs.getFloat("coef_matiere");
               String classe=rs.getString("niveau");
               String description=rs.getString("description");

             
               Matiere m=new Matiere(id_matiere,nom_matiere,coef_matiere,classe,description);
     arr.add(m);
     }
    return arr;
        
            }

    @Override
    public Matiere rechercheMatiereParid_(int id_matiere) {
  
        
         Matiere S = new Matiere();
      
           try {
            
                 String req4="SELECT * FROM esprit.`Matiere` WHERE id_matiere='" + id_matiere + "';";
          Statement st = con.createStatement();
            st.executeQuery(req4);
            ResultSet rs = st.executeQuery(req4);
           while(rs.next()){
              
                    S.setId_matiere(rs.getInt("id_matiere"));
                     S.setNom_matiere(rs.getString("nom_matiere"));
                      S.setCoef_matiere(rs.getFloat("coef_matiere"));
                   
                 
                  System.out.println("c bon");
             
               
            }
           
            return S;
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceMatiere.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return null;


    }
    
}
