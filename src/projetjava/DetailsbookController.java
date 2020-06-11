/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import com.jfoenix.controls.JFXTextField;
import entities.book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DetailsbookController implements Initializable {

    @FXML
    private Label idbook;
    @FXML
    private Label Categorybook;
    @FXML
    private Label Title;
    @FXML
    private Label Author;
    @FXML
    private Label Description;
    @FXML
    private Label imagebook;
    @FXML
    private Label ISBN;
    @FXML
    private Label nbrbook;
    @FXML
    private ImageView imagesee;
private JFXTextField filechoose;
    FileChooser fc = new FileChooser();
    File selectedFile = new File("");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void initData(book b)
{
        try {
            System.out.println(b);
            
          //  idbook.setText(String.valueOf(b.getId_book()));
          //  Categorybook.setText(String.valueOf(b.getCategory()));
            Title.setText(b.getTitle());
            Author.setText(b.getAuthor());
            Description.setText(b.getDescription());
          //  imagebook.setText(b.getImagebook());
            
            
            Image I = new Image(new FileInputStream("D:\\wamp64\\www\\PIDEV2020_ELIT_3A177\\PIDEV2020_ELIT_3A17\\web\\imageheni\\"+b.getImagebook()));
            System.out.println(b.getImagebook());
            imagesee.setImage(I);
            ISBN.setText(String.valueOf(b.getISBN()));
            nbrbook.setText(String.valueOf(b.getNbrbooks())); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DetailsbookController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
}

    @FXML
    private void retour(ActionEvent event) {
         try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Book.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
    
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       } catch (IOException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
