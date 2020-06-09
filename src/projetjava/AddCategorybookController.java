/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import entities.categorybook;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import services.ServiceCategorybook;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddCategorybookController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXTextField namecategory;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  

    @FXML
    private void Addcategory(ActionEvent event) {
        ServiceCategorybook SC= new ServiceCategorybook();
         categorybook c= new categorybook();
         boolean c1=true;
            
            //System.out.println(classe.getSelectionModel().getSelectedItem().toString());
              //  System.out.println(nom_matiere.getText());
                //    System.out.println(coifficient.getText());
                    
                    /////////////////////////////////test empty//////////////////////////////
       if ( namecategory.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("All fields required");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the required fields");
                alert.show();
                c1=false;

            }
            //////////////////////////////////////////////////////////////////////  
          
            if(c1==true)
            {
            String category = namecategory.getText();
                System.out.println(category);
                  c.setName_category(category);
                  SC.ajouter(c);
                  
                                try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Categorybook.fxml"));
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
    

    @FXML
    private void Cancel(ActionEvent event) {
        try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Categorybook.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
    
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       } catch (IOException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
}
