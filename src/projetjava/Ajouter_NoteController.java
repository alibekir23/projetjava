/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import entities.Note;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import services.ServiceNote;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Ajouter_NoteController implements Initializable {
 
  PreparedStatement pst=null;
      private Connection con;
    private Statement ste;
    ObservableList options=FXCollections.observableArrayList();
      ObservableList options2=FXCollections.observableArrayList();
      ObservableList options3=FXCollections.observableArrayList();
      
   // @FXML private Spinner<Double> Note_spinner;
       @FXML
    private  JFXTextField notee;
    
    @FXML private JFXComboBox student;
    @FXML private JFXComboBox subject;
    @FXML private JFXComboBox classe ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
          ServiceNote no= new ServiceNote();
          
        
       
        options3=no.AddCombo3();

  
      classe.setItems(options3);
        
     //SpinnerValueFactory<Double> gradesValueSpinner= new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 20,0);
      //this.Note_spinner.setValueFactory(gradesValueSpinner);
      //Note_spinner.setEditable(true);
      
   


    }
    
       @FXML 
    private void cancel(ActionEvent event){
           try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Note.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
            conn_stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    private void test(ActionEvent event){
            ServiceNote no= new ServiceNote();
          
           options=no.AddCombo(classe.getSelectionModel().getSelectedItem().toString());
                 student.setItems(options);
                
                  
    }
    
    @FXML 
    private void test2(ActionEvent event){
          ServiceNote no= new ServiceNote();
         String eleve=student.getSelectionModel().getSelectedItem().toString();
                 // note.setText(student.getSelectionModel().getSelectedItem().toString());
                  options2=no.AddCombo2(eleve,classe.getSelectionModel().getSelectedItem().toString());
                      subject.setItems(options2);
        
    }
    
    
    
           @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
          ServiceNote no= new ServiceNote();
         Note n;
        boolean c1=true,c2=true,c3=true;
        
        
        
            /////////////////////////////////test empty//////////////////////////////
            if ( student.getSelectionModel().isEmpty() || subject.getSelectionModel().isEmpty()  || classe.getSelectionModel().isEmpty() ||  notee.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("All fields are required");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the required fields");
                alert.show();
                c1=false;

            }
            
           
            ///////////////////////////////////////////////////////////////
         
            ////////////////////////////////////////test number////////////////////////////////////
            if(c1==true)
            {
            String t=notee.getText();
           try 
         {
             float val = Float.parseFloat(t);
           }
         catch(NumberFormatException e) {
        //  System.out.println("Invalid");
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Please enter a valid number");
                alert.setHeaderText(null);
                alert.setContentText("Note must be a number");
                alert.show();
                c2=false;
             }
            } 
            //////////////////////////////////////////////////////////////////////  
          
         //////////////////between 0 and 20/////////////////////
     
         if(c1==true && c2==true)
         {
               float val = Float.parseFloat(notee.getText().toString());
             if(val>20 ||val<0)
             {
               
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Please enter a valid number");
                alert.setHeaderText(null);
                alert.setContentText("Note must be between 0 and 20");
                alert.show();
                c3=false;
         }
         }
         ////////////////////////////////////////////
            
            
             if(c1==true && c2==true && c3==true)
            {
        String eleve=student.getSelectionModel().getSelectedItem().toString();
        String matiere=subject.getSelectionModel().getSelectedItem().toString();
        String classee=classe.getSelectionModel().getSelectedItem().toString();
        
        
        
        
        
        
       // Float note= Note_spinner.getValue().floatValue();
       Float note=Float.parseFloat(notee.getText()); 
       String nom=eleve.substring(0,eleve.indexOf(" "));
         String prenom=eleve.substring(eleve.indexOf(" ")+1,eleve.length());
        System.out.println(nom);
         System.out.println(prenom);
         System.out.println(matiere);
          System.out.println(classee);
           System.out.println(note);
           
                
         n=no.find(nom, prenom, matiere, classee, note);
               System.out.println(n); 
               no.ajouter(n);
           
               
               
                             try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Note.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
            conn_stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
            }
        //  Note n= new Note(id_eleve,id_examen,id_matiere,note);
        //ServiceNote se= new ServiceNote();
        //se.ajouter1(n);
    }



   
    
    
    
    
    
    
    
    
    
    
    

}
