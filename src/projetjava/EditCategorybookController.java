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
public class EditCategorybookController implements Initializable {
    @FXML
    private JFXTextField namecategory;
    @FXML
    private JFXButton Editcategory;
    @FXML
    private Label idcategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void initData(categorybook C)
{
    System.out.println(C);
    
    namecategory.setText(C.getName_category());
     idcategory.setText(String.valueOf(C.getId_category()));
   
}
    @FXML
    private void Editcategory(ActionEvent event) {
          ServiceCategorybook SC= new ServiceCategorybook();
         categorybook c= new categorybook();
         boolean c1=true,c2=true,c3 = false;
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
            ///////////////////////////////////////////////////////////////
         
            ////////////////////////////////////////test number////////////////////////////////////
           
            //////////////////////////////////////////////////////////////////////  
          
        System.out.println(namecategory.getText());   
            String category = namecategory.getText();
            int id =Integer.parseInt(idcategory.getText().toString()) ;
                System.out.println(category);
                System.out.println(id);
        
               // c.setName_category(category);
                 // System.out.println(c);
                  SC.update(category,id);
                  
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

    @FXML
    private void Cancel(ActionEvent event) {
    }
    
}
