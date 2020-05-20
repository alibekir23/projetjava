/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import com.jfoenix.controls.JFXButton;
import entities.Matiere;
import services.ServiceMatiere;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Modifier_ModuleController implements Initializable {
    @FXML
    Label classe;
    @FXML
    Label id;
       @FXML
    private JFXTextField nom_matiere;
       @FXML
    private JFXTextField  coifficient;
    @FXML
    private JFXButton modify;
    @FXML
    private Label id_module;
    @FXML
    private Label id_note;
    @FXML
    private Label coef;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }

public void initData(Matiere m)
{
    System.out.println(m);
    
    nom_matiere.setText(m.getNom_matiere());
     classe.setText(m.getClasse());
     id.setText(String.valueOf(m.getId_matiere()));
     coifficient.setText(String.valueOf(m.getCoef_matiere()));
   
}
    
@FXML private void Update(ActionEvent event) 
{
     ServiceMatiere mo= new ServiceMatiere();
         Matiere m= new Matiere();
         boolean c1=true,c2=true,c3 = false;
            //System.out.println(classe.getSelectionModel().getSelectedItem().toString());
              //  System.out.println(nom_matiere.getText());
                //    System.out.println(coifficient.getText());
                    
                    /////////////////////////////////test empty//////////////////////////////
            if ( nom_matiere.getText().isEmpty() || coifficient.getText().isEmpty()) {
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
                int idd=Integer.valueOf(id.getText());
                String classee=classe.getText();
            String matiere=nom_matiere.getText();
            float coef= Float.parseFloat(coifficient.getText());
                System.out.println(m.getId_matiere());    
            System.out.println(classee);
                 System.out.println(matiere);
                  System.out.println(coef);
                   System.out.println(idd);
                  m.setId_matiere(idd);
                  m.setClasse(classee);
                  m.setCoef_matiere(coef);
                  m.setNom_matiere(matiere);
               
    
         c3=mo.update(m);

            }
         if(c3==true)
         {
             
   
                        //////////////////////close window/////////////////////////
 //  Node source = (Node) event.getSource();
   //  Stage stage = (Stage) source.getScene().getWindow();
   // stage.hide(); 
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
    ///////////////////////////////////////////////////
       Notifications notificationBuilder = Notifications.create().title("Success !").text("Module Registered Successfully").graphic(null).darkStyle().position(Pos.TOP_CENTER).hideAfter(Duration.seconds(5));
         notificationBuilder.showConfirm();
         }
  
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
    

}
