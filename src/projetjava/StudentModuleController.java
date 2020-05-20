/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import entities.Matiere;
import javafx.application.Application;
import services.ServiceMatiere;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ali
 */
public class StudentModuleController implements Initializable  {

    @FXML  
    private TableColumn<Matiere,Integer> id_matiere;
    @FXML  
    private TableColumn<Matiere,String> nom_matiere;
    @FXML  
    private TableColumn<Matiere,Float> coef;
     @FXML  
    private TableColumn<Matiere,String> description;

    public TableColumn<Matiere, String> getDescription() {
        return description;
    }

    public void setDescription(TableColumn<Matiere, String> description) {
        this.description = description;
    }
    
    
      public TableColumn<Matiere, Integer> getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(TableColumn<Matiere, Integer> id_matiere) {
        this.id_matiere = id_matiere;
    }


    public TableColumn<Matiere, String> getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(TableColumn<Matiere, String> nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public TableColumn<Matiere, Float> getCoef() {
        return coef;
    }

    public void setCoef(TableColumn<Matiere, Float> coef) {
        this.coef = coef;
    }

    public TableColumn<Matiere, String> getClasse() {
        return classe;
    }

    public void setClasse(TableColumn<Matiere, String> classe) {
        this.classe = classe;
    }
     @FXML  
    private TableColumn<Matiere,String> classe;
     
     
     
      ObservableList<Matiere> data=FXCollections.observableArrayList();
    @FXML
    private TableView<Matiere> tab;
          
          @FXML private TextField filterField;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        
          try {
             ServiceMatiere no= new ServiceMatiere();
           // List<Command> list = sp.readAll();
            
            data.addAll(no.readAll());
              System.out.println(data.toString());
             id_matiere.setCellValueFactory(new PropertyValueFactory<Matiere,Integer>("id_matiere"));  
              nom_matiere.setCellValueFactory(new PropertyValueFactory<Matiere,String>("nom_matiere"));
              coef.setCellValueFactory(new PropertyValueFactory<Matiere,Float>("coef_matiere"));
              description.setCellValueFactory(new PropertyValueFactory<Matiere,String>("description"));
              classe.setCellValueFactory(new PropertyValueFactory<Matiere,String>("classe"));
            tab.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          
          
          
            
        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Matiere> filteredData = new FilteredList<>(data, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(matiere -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
                                 if (String.valueOf(matiere.getId_matiere()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 
                                
				else if (String.valueOf(matiere.getCoef_matiere()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 
                                 else if (String.valueOf(matiere.getNom_matiere()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(matiere.getClasse()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                 
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Matiere> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tab.setItems(sortedData);  
    }





   @FXML public void retour(ActionEvent event){
         try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("StudentDashboard.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
    
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       } catch (IOException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
}





