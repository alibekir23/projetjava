/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import services.ServiceMatiere;
import entities.Matiere;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Ajouter_ModuleController implements Initializable {

    
    
    
      @FXML private JFXComboBox classe ;
     ObservableList options=FXCollections.observableArrayList();
     
      
      @FXML
    private JFXTextField nom_matiere;
      @FXML
    private JFXTextArea  description;
      @FXML
    private  JFXTextField coifficient;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        options.addAll("1","2","3","4","5");
         classe.setItems(options);
        // TODO
    }  
    
    
    @FXML 
    private void cancel(ActionEvent event){
           try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Matiere.fxml"));
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
    private void ajouter(ActionEvent event){
         ServiceMatiere mo= new ServiceMatiere();
         Matiere m= new Matiere();
         boolean c1=true,c2=true;
         
        
            
            
            //System.out.println(classe.getSelectionModel().getSelectedItem().toString());
              //  System.out.println(nom_matiere.getText());
                //    System.out.println(coifficient.getText());
                    
                    /////////////////////////////////test empty//////////////////////////////
            if ( nom_matiere.getText().isEmpty() || coifficient.getText().isEmpty() || classe.getSelectionModel().isEmpty()|| description.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("All fields required");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the required fields");
                alert.show();
                c1=false;

            }
            ///////////////////////////////////////////////////////////////
         
            ////////////////////////////////////////test number////////////////////////////////////
            if(c1==true){
            
            String t=coifficient.getText();
           try 
         {
             float val = Float.parseFloat(t);
           }
         catch(NumberFormatException e) {
        //  System.out.println("Invalid");
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Field coifficient must be a number");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number");
                alert.show();
                c2=false;
             }
            }
            //////////////////////////////////////////////////////////////////////  
          
            if(c1==true && c2==true)
            {
                String classee=classe.getSelectionModel().getSelectedItem().toString();
            String matiere=nom_matiere.getText();
            float coef= Float.parseFloat(coifficient.getText());
            String Description=description.getText();
                System.out.println(classee);
                 System.out.println(matiere);
                  System.out.println(coef);
                  System.out.println(Description);
                  m.setClasse(classee);
                  m.setDescription(Description);
                  m.setCoef_matiere(coef);
                  m.setNom_matiere(matiere);
                  mo.ajouter(m);
                  
                                try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Matiere.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
            conn_stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        
        
    }
    
}
