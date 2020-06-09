/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import entities.book;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceBook;

/**
 * FXML Controller class
 *
 * @author user
 */
public class BookController implements Initializable {

    @FXML
    private TextField filterField;
    @FXML
    private TableColumn<book, Integer> ID_book;
    @FXML
    private TableColumn<book,Integer> categorybook;
    //    @FXML
 //   private TableColumn<?,String> nomcategorybook;
    @FXML
    private TableColumn<book,String> titlebook;
    @FXML
    private TableColumn<book, String> Authorbook;
    @FXML
    private TableColumn<book, String> descriptionbook;
    @FXML
    private TableColumn<book, String> imagebook;
    @FXML
    private TableColumn<book, Integer> isbnbook;
    @FXML
    private TableColumn<book, Integer> numberbook;
    @FXML
    private TableView<book> tabbook;

    public TableColumn<book, Integer> getID_book() {
        return ID_book;
    }

    public void setID_book(TableColumn<book, Integer> ID_book) {
        this.ID_book = ID_book;
    }

    public TableColumn<book, Integer> getCategorybook() {
        return categorybook;
    }

    public void setCategorybook(TableColumn<book, Integer> categorybook) {
        this.categorybook = categorybook;
    }

    public TableColumn<book, String> getTitlebook() {
        return titlebook;
    }

    public void setTitlebook(TableColumn<book, String> titlebook) {
        this.titlebook = titlebook;
    }

    public TableColumn<book, String> getAuthorbook() {
        return Authorbook;
    }

    public void setAuthorbook(TableColumn<book, String> Authorbook) {
        this.Authorbook = Authorbook;
    }

    public TableColumn<book, String> getDescriptionbook() {
        return descriptionbook;
    }

    public void setDescriptionbook(TableColumn<book, String> descriptionbook) {
        this.descriptionbook = descriptionbook;
    }

    public TableColumn<book, String> getImagebook() {
        return imagebook;
    }

    public void setImagebook(TableColumn<book, String> imagebook) {
        this.imagebook = imagebook;
    }

    public TableColumn<book, Integer> getIsbnbook() {
        return isbnbook;
    }

    public void setIsbnbook(TableColumn<book, Integer> isbnbook) {
        this.isbnbook = isbnbook;
    }

    public TableColumn<book, Integer> getNumberbook() {
        return numberbook;
    }

    public void setNumberbook(TableColumn<book, Integer> numberbook) {
        this.numberbook = numberbook;
    }
    
    
 ObservableList<book> data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceBook SB= new ServiceBook();
           // List<Command> list = sp.readAll();
           

          try{
   data.addAll(SB.readAll());
   
              System.out.println(data.toString());
             ID_book.setCellValueFactory(new PropertyValueFactory<book,Integer>("id_book")); 

                          categorybook.setCellValueFactory(new PropertyValueFactory<book,Integer>("category"));  
                        //   nomcategorybook.setCellValueFactory(new PropertyValueFactory<?,String>(SB.getNom(Integer.parseInt(categorybook.toString()))));  
                          titlebook.setCellValueFactory(new PropertyValueFactory<book,String>("Title"));  
                          Authorbook.setCellValueFactory(new PropertyValueFactory<book,String>("author"));  
                          descriptionbook.setCellValueFactory(new PropertyValueFactory<book,String>("Description"));  
                          imagebook.setCellValueFactory(new PropertyValueFactory<book,String>("imagebook"));  
                          isbnbook.setCellValueFactory(new PropertyValueFactory<book,Integer>("ISBN"));  
                          numberbook.setCellValueFactory(new PropertyValueFactory<book,Integer>("nbrbooks"));  

              
            tabbook.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }    

    @FXML
    private void retour(ActionEvent event) {
    }


    @FXML
    private void delete(ActionEvent event) {
          boolean c1=true;
        if(tabbook.getSelectionModel().getSelectedItem()==null)
        {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a module to delete");
                alert.show();            
        c1=false;
        }
        
        if(c1==true)
        {
        try {
            book n = (book) tabbook.getSelectionModel().getSelectedItem();
             ServiceBook SB = new ServiceBook();
            // as.delete(e);
              Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Delete book");
//alert.setHeaderText("Look, a Confirmation Dialo");
alert.setContentText("Are you sure you want to delete this book?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
     SB.delete(n);
    
} 
      
          SB.readAll();
        
         } catch (SQLException ex) {
             Logger.getLogger(CategorybookController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }

    @FXML
    private void update(ActionEvent event) {
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

    @FXML
    private void Ajoutbook(ActionEvent event) {
        try {
            Parent  conn_page = FXMLLoader.load(getClass().getResource("Addbook.fxml"));
            Scene conn_scene = new Scene(conn_page);
            Stage conn_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            conn_stage.setScene(conn_scene);
            conn_stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AdmininterfaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
}
