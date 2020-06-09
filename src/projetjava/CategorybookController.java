/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import entities.categorybook;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import static javafx.print.Paper.C;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServiceCategorybook;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CategorybookController implements Initializable {

    
    @FXML
    private TextField filterField;
    @FXML
    private TableView<categorybook> tab;
    @FXML
    private TableColumn<categorybook,Integer> id_category;
    @FXML
    private TableColumn<categorybook,String> name_category;
ObservableList<categorybook> data=FXCollections.observableArrayList();
 public TableColumn<?, ?> getId_category() {
        return id_category;
    }

    public void setId_category(TableColumn<categorybook,Integer> id_category) {
        this.id_category = id_category;
    }

    public TableColumn<categorybook,String> getName_category() {
        return name_category;
    }

    public void setName_category(TableColumn<categorybook,String> name_category) {
        this.name_category = name_category;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
try {
             ServiceCategorybook no= new ServiceCategorybook();
           // List<Command> list = sp.readAll();
            
            data.addAll(no.readAll());
              System.out.println(data.toString());
             id_category.setCellValueFactory(new PropertyValueFactory<categorybook,Integer>("id_category"));  
              name_category.setCellValueFactory(new PropertyValueFactory<categorybook,String>("name_category"));
              
            tab.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }        
 // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<categorybook> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(categorybook -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
                                 if (String.valueOf(categorybook.getId_category()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 
                                
				else if (String.valueOf(categorybook.getName_category()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                
                              
                                 
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<categorybook> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tab.setItems(sortedData); 
    }    

   
@FXML
   public void NewCategorybook(ActionEvent event){
       
       try{
                  Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("AddCategorybook.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
    //   Stage stage= new Stage();
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       } catch (IOException ex) {
            Logger.getLogger(CategorybookController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    @FXML
    private void retour(ActionEvent event) {
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
              boolean c1=true;
        if(tab.getSelectionModel().getSelectedItem()==null)
        {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a category to delete");
                alert.show();            
        c1=false;
        }
        
        if(c1==true)
        {
        try {
            categorybook n = (categorybook) tab.getSelectionModel().getSelectedItem();
             ServiceCategorybook no = new ServiceCategorybook();
              Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle("Delete category");
//alert.setHeaderText("Look, a Confirmation Dialo");
alert.setContentText("Are you sure you want to delete this category?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
     no.delete(n);

} 
      
          no.readAll();
        
         } catch (SQLException ex) {
             Logger.getLogger(CategorybookController.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }

    @FXML
    private void update(ActionEvent event) {
           boolean c1=true;
        if(tab.getSelectionModel().getSelectedItem()==null)
        {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a category to edit!");
                alert.show();            
        c1=false;
        }
        
           if(c1==true)
        {
        
       try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("editCategorybook.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
     //  Stage stage= new Stage();
       EditCategorybookController controller=fxmlLoader.getController();
       controller.initData(tab.getSelectionModel().getSelectedItem());
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       } catch (IOException ex) {
            Logger.getLogger(CategorybookController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }

   
    
}
