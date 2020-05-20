/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class StudentDashboardController implements Initializable {

    @FXML
    private AnchorPane anchor;
     String mail;
 @FXML Label email;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

        // TODO
    }    

 ///////////////////////////////////ali//////////////////////////////////////////////////
    
    @FXML
    private void handleModule(ActionEvent event) {
         try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("StudentModule.fxml"));
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
    private void handleNote(ActionEvent event) {
         try {
                             Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("StudentNote.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
     //  Stage stage= new Stage();
       StudentNoteController controller=fxmlLoader.getController();
       controller.initData(email.getText().toString());
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
               public void initData(String em)
{
  //  System.out.println(em);
    email.setText(em);
 
}
               public void initData2(String em)
{
  //  System.out.println(em);
    email.setText(em);
 
}
               
    /////////////////////////////////////////////////////////////////////////////////
    
}   