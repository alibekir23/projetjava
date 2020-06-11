/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.categorybook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;
import utils.ConnexionBD;


/**
 *
 * @author user
 */
public class ServiceCategorybook {
   
      
    private static ServiceCategorybook instance;
    public static ServiceCategorybook getInstance() {
   if(instance==null) 
            instance=new ServiceCategorybook();
        return instance;    }

    private Connection con;
    private Statement ste;

    public ServiceCategorybook() {
        con = ConnexionBD.getInstance().getCnx();

    }
    
      
    public void ajouter(categorybook  t) {
        
      try{
        ste = con.createStatement();
                String requeteInsert = "INSERT INTO `java`.`categorybook` (`id_category`,`name_category`) VALUES ('" + t.getId_category() + "', '" + t.getName_category()+ "');";
        ste.executeUpdate(requeteInsert);
         SQLWarning w = ste.getWarnings();
        System.out.println("ok");
    
           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("Category added").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Category exists ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
    }
     /*public void importtoexcel(categorybook  t) {
        
      try{
          
          try{
              String requeteInsert = "INSERT INTO `java`.`categorybook` (`id_category`,`name_category`) VALUES (?,?)";
                            ste = con.prepareStatement(requeteInsert);

              
              FileInputStream fileIn;
              fileIn = new FileInputStream(new File("category.xlsx"));
                XSSFWorkbook wb = new XSSFWorkbook(fileIn);
              XSSFSheet sheet = wb.getSheetAt(0);
              Row row;
              for(int i=1; i<=sheet.getLastRowNum();i++){
                  row = sheet.getRow(i);
                  ste.s
                  ste.
                  ste.setString(2, row.getCell(1).getStringCellValue());
              }
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          
          SQLWarning w = ste.getWarnings();
          System.out.println("ok");
          
          if (w == null) {
              System.out.println ("\n *** SQL Warning ***\n");
              Notifications notificationBuilder = Notifications.create().title("Success !").text("Category added").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
              notificationBuilder.showConfirm();
              
          }
          
      } catch (SQLException ex) {
              Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
          }
           
         
    }
*/
    public void delete(categorybook t)  {
    
            String sql = "DELETE FROM `java`.`categorybook` where (id_category ="+t.getId_category()+");";
  
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("Can't delete categorybook! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }
    
     public boolean update(String t,int id){

          try{
              System.out.println(t);
        ste = con.createStatement();

                String requeteInsert = "update categorybook set name_category='" + t + "' where id_category='"+ id +"';";

        ste.executeUpdate(requeteInsert);
         SQLWarning w = ste.getWarnings();
        System.out.println("ok");

           if (w == null) {
         System.out.println ("\n *** SQL Warning ***\n");
        Notifications notificationBuilder = Notifications.create().title("Success !").text("categorybook Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
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
        Notifications notificationBuilder = Notifications.create().title("Error !").text("categorybook already exists! ").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
           notificationBuilder.showError();
      }
            Logger.getLogger(ServiceCategorybook.class.getName()).log(Level.SEVERE, null, ex);
      return false;  }     
        
        
        
       
   return true;
    }
    
     
      public List<categorybook> readAll() throws SQLException {
 
            List<categorybook> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from categorybook");
     while (rs.next()) {                
              
               int id_category=rs.getInt("id_category");     
               String name_category=rs.getString("name_category");
               
               categorybook m=new categorybook(id_category,name_category);
     arr.add(m);
     }
    return arr;
        
            }

}
