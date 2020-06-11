/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.book;
import entities.categorybook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ServiceBook;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddbookController implements Initializable {
    

    @FXML
    private JFXTextField filechoose;
    FileChooser fc = new FileChooser();
    File selectedFile = new File("");
    
    
    @FXML
    private JFXButton btnaddbook;
    @FXML
      private JFXComboBox<String> ComboCategory;
         ObservableList options=FXCollections.observableArrayList();


    @FXML
    private JFXTextField TextTitle;
    @FXML
    private JFXTextField TextAuthor;
    @FXML
    private JFXTextField TextISBN;
    @FXML
    private JFXTextArea TextDescription;
    @FXML
    private JFXTextField Textnbrbook;

    ///// alert //////////////
    @FXML
    private JFXButton chooser;
    @FXML
    private ImageView Imagebook;
    @FXML
    private JFXButton buttonhome;
    @FXML
    private JFXButton buttonreturn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //  option
               ServiceBook BS = new ServiceBook();

        options=BS.AddCombcategory();

  
      ComboCategory.setItems(options);
        // ComboCategory.setItems(options);
    }    

    private void image(MouseEvent event) {
      
    }
   

    @FXML
    private void addbook(ActionEvent event) {
        
        book c = new book() ;
        ServiceBook BS = new ServiceBook();
        //||ComboCategory.getSelectionModel().getSelectedItem().toString().isEmpty()
         if((TextTitle.getText().isEmpty()||TextAuthor.getText().isEmpty()||TextISBN.getText().isEmpty()||TextDescription.getText().isEmpty()||Textnbrbook.getText()==null))      {
        Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setHeaderText(null);
         alert.setContentText("Veuillez remplir tous les Champs");
         alert.showAndWait();
         DialogPane dialogPane = alert.getDialogPane();
  }
        
         
        String file=filechoose.getText();
        String Title= TextTitle.getText();
      String categoryy=ComboCategory.getSelectionModel().getSelectedItem().toString();
        String description =TextDescription.getText();
        String author =TextAuthor.getText();
        String isbn= TextISBN.getText();
        int valIsbn = Integer.parseInt(isbn);
        String nbrbook = Textnbrbook.getText();
        int valnbrbook = Integer.parseInt(nbrbook);
        
        
        
        c.setTitle(Title);
       c.setCategory(BS.getID(categoryy));
        System.out.println("ssssssss "+c.getCategory());
     //         c.setCategory(BS.getID(categoryy));
     //categorybook cbk = (categorybook)options.get(ComboCategory.getSelectionModel().getSelectedIndex());
           //   c.setCategory(cbk.getId_category());

        System.out.println(c.getCategory());
        c.setAuthor(author);
        c.setDescription(description);
        c.setISBN(valIsbn);
        c.setNbrbooks(valnbrbook);
        c.setImagebook(file);
        
        
        BS.ajout(c);
        try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Book.fxml"));
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
    private void image(ActionEvent event) {
        try {
            fc.setTitle("Open Resource File");
            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text files","*.pdf", "*.tkt", "*.docx","*.png","*.jpg"));
            fc.setInitialDirectory(new File("C:"));
            selectedFile = fc.showOpenDialog(null);
            
            //UploadFile.upload(selectedFile,"", "");
            File file = new File("" + selectedFile.getName());
            filechoose.setText(selectedFile.getAbsolutePath());
            Image I = new Image(new FileInputStream(selectedFile.getAbsolutePath()));
            Imagebook.setImage(I);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddbookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returnhome(ActionEvent event) {
        try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void returninterfacebook(ActionEvent event) {
        try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Book.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
