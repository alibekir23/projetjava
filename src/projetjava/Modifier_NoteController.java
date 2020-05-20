/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.Matiere;
import entities.Note;
import java.io.IOException;
import java.net.URL;
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
import services.ServiceMatiere;
import services.ServiceNote;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class Modifier_NoteController implements Initializable {

    @FXML
    private JFXButton modify;
    @FXML
    private Label module;
     @FXML
    private Label student;
    @FXML
    private JFXTextField note;
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

            public void initData(Note n,String st)
{
    System.out.println(n);
    student.setText(st);
    note.setText(Float.toString(n.getNote()));
     id_note.setText(Integer.toString(n.getId_note()));
       module.setText(n.getNom_matiere());
      coef.setText(Float.toString(n.getCoef()));
     
   
}
    
    @FXML
    private void Update(ActionEvent event) {
    ServiceNote no= new ServiceNote();
         Note n= new Note();
         boolean c1=true,c2=true,c3 = true;
            //System.out.println(classe.getSelectionModel().getSelectedItem().toString());
              //  System.out.println(nom_matiere.getText());
                //    System.out.println(coifficient.getText());
                    
                    /////////////////////////////////test empty//////////////////////////////
            if ( note.getText().isEmpty() ) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Field note is required!");
                alert.setHeaderText(null);
                alert.setContentText("Please fill note field ");
                alert.show();
                c1=false;

            }
            ///////////////////////////////////////////////////////////////
         
            ////////////////////////////////////////test number////////////////////////////////////
            if(c1==true){
            
            String t=note.getText();
           try 
         {
             float val = Float.parseFloat(t);
           }
         catch(NumberFormatException e) {
        //  System.out.println("Invalid");
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Field note must be a number");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid number");
                alert.show();
                c2=false;
             }
            }
              if(c1==true && c2==true)
         {
               float val = Float.parseFloat(note.getText().toString());
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
            //////////////////////////////////////////////////////////////////////  
          
            if(c1==true && c2==true && c3==true)
            {
                int id_notee=Integer.valueOf(id_note.getText());
                 float i=Float.parseFloat(note.getText());
  
         c3=no.update(id_notee,i);
                System.out.println(id_notee);

            }
         if(c3==true)
         {
             
   
                        //////////////////////close window/////////////////////////
 //  Node source = (Node) event.getSource();
   //  Stage stage = (Stage) source.getScene().getWindow();
   // stage.hide(); 
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
    ///////////////////////////////////////////////////
     
         }
    
    }

    @FXML
    private void cancel(ActionEvent event) {
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
    
}
