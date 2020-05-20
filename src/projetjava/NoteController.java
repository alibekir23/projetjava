/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetjava;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXComboBox;
import entities.Mailing;
import entities.Matiere;
import entities.Note;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import services.ServiceNote;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Notifications;
import services.ServiceMatiere;

/**
 * FXML Controller class
 *
 * @author BEN SAID
 */
public class NoteController implements Initializable {
    
       Document doc = new Document();
            @FXML private GridPane g;
     @FXML private JFXComboBox nom_classe ;
     @FXML private JFXComboBox students ;
    @FXML  
    private TableColumn<Note,Integer> id_note;
    @FXML  
    private TableColumn<Note,String> nom_matiere;
    @FXML  
    private TableColumn<Note,Integer> coef;
    @FXML  
    private TableColumn<Note,Float> note;
    @FXML
    private TableColumn<Note,String> nom_etudiant;
    @FXML
    private TableColumn<Note,String> prenom_etudiant;
    @FXML
    private TableColumn<Note,String> mail;
     @FXML
    private TableColumn<Note,String> classe;
     @FXML Label Average;
      @FXML Label Total;
       @FXML Label Credit;
     
     
     TextArea text;

    public TableColumn<Note, Integer> getId_note() {
        return id_note;
    }

    public void setId_note(TableColumn<Note, Integer> id_note) {
        this.id_note = id_note;
    }

    public TableColumn<Note, String> getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(TableColumn<Note, String> nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public TableColumn<Note, Integer> getCoef() {
        return coef;
    }

    public void setCoef(TableColumn<Note, Integer> coef) {
        this.coef = coef;
    }

    public TableColumn<Note, Float> getNote() {
        return note;
    }

    public void setNote(TableColumn<Note, Float> note) {
        this.note = note;
    }

    public TableColumn<Note, String> getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(TableColumn<Note, String> nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public TableColumn<Note, String> getPrenom_etudiant() {
        return prenom_etudiant;
    }

    public void setPrenom_etudiant(TableColumn<Note, String> prenom_etudiant) {
        this.prenom_etudiant = prenom_etudiant;
    }

    public TableColumn<Note, String> getMail() {
        return mail;
    }

    public void setMail(TableColumn<Note, String> mail) {
        this.mail = mail;
    }

    public TableColumn<Note, String> getClasse() {
        return classe;
    }

    public void setClasse(TableColumn<Note, String> classe) {
        this.classe = classe;
    }
   
   
   
   
    ObservableList<Note> data=FXCollections.observableArrayList();
      ObservableList<Note> data2=FXCollections.observableArrayList();
    @FXML
    private TableView<Note> tab;
    @FXML
    private TableView<Note> tab2;
    private Button supp;
   
    private Button modifierno;

   public static Integer id_e;
    public static Integer id_ex;
public static Integer id_mat;
public static Float not;
public static Integer id_not;
public static String nom_etudiantt;
    private Button annuler;

       @FXML private TextField filterField;
        ObservableList options=FXCollections.observableArrayList();
         ObservableList options2=FXCollections.observableArrayList();
    ObservableList pdf=FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
             ServiceNote no= new ServiceNote();
           // List<Command> list = sp.readAll();
           options=no.AddCombo3();
     nom_classe.setItems(options);
     
     
     
    
        
          
        
        
    }    

   

   

    public ObservableList<Note> getData() {
        return data;
    }

    public void setData(ObservableList<Note> data) {
        this.data = data;
    }

    public TableView<Note> getTab() {
        return tab;
    }

    public void setTab(TableView<Note> tab) {
        this.tab = tab;
    }

    public Button getSupp() {
        return supp;
    }

    public void setSupp(Button supp) {
        this.supp = supp;
    }

  
    
     
    
    
       
   @FXML
    private void test(ActionEvent event){
            ServiceNote no= new ServiceNote();
          
           options2=no.AddCombo(nom_classe.getSelectionModel().getSelectedItem().toString());
                 students.setItems(options2);
                 System.out.println(options2);
                
                  
    }
    
    
    
  

    @FXML
    private void supprimer(ActionEvent event) {
        boolean c2=true;
        
        
            if(tab2.getSelectionModel().getSelectedItem()==null)
        {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a note to delete");
                alert.show();            
        c2=false;
        }
        if(c2==true)
        {
        try {
            Note n = (Note) tab2.getSelectionModel().getSelectedItem();
             ServiceNote no = new ServiceNote();
            // as.delete(e);
              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Delete Note");
//alert.setHeaderText("Look, a Confirmation Dialo");
alert.setContentText("Are you sure you want to delete this Note?");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
     no.delete(n);
}

          no.readAll();
    }       catch (SQLException ex) {
                Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    

    private void annuler(ActionEvent event) {
              try {
            
            Parent root = FXMLLoader.load(getClass().getResource("Mnote.fxml"));
           Scene scene = new Scene(root);
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

    @FXML
   public void load(ActionEvent event) throws SQLException{
          
      tab2.getItems().clear();
           
      
       
         //  Note n=new Note();
          String n= students.getSelectionModel().getSelectedItem().toString();
          
          System.out.println(n);
          /// text.setText(""+n.getNom_etudiant()+"");
           ServiceNote n2=new ServiceNote();
              
           data2.addAll(n2.readAll2(n));
          id_note.setCellValueFactory(new PropertyValueFactory<Note,Integer>("id_note"));
         nom_matiere.setCellValueFactory(new PropertyValueFactory<Note,String>("nom_matiere"));
           coef.setCellValueFactory(new PropertyValueFactory<Note,Integer>("coef"));
           note.setCellValueFactory(new PropertyValueFactory<Note,Float>("note"));
          
               
           tab2.setItems(data2);  
           
            Note nn= new Note();
     float av=0;
     float tt=0;
     float cc=0;
     float a=0;
     float t=0;
     float c=0;
     float aa=0;
     float tm=0;
         for (int i=0;i<tab2.getItems().size();i++)
         {
             nn=tab2.getItems().get(i);
             
             a=nn.getNote();
             t=t+nn.getCoef();
             tm=nn.getCoef();
             aa=aa+(a*tm);
             if(nn.getNote()<10)
             {
                 c=c+nn.getCoef();
             }
           
         }
      
         tt=t;

         cc=c;
          System.out.println(aa);
          System.out.println(tab2.getItems().size());
         av=aa/tt;
           Average.setText(Float.toString(av));
           Total.setText(Float.toString(tt));
           Credit.setText(Float.toString(cc));
           
        
   }

    @FXML
   public void NewNote(ActionEvent event){
       try{
           Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Ajouter_Note.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
      // Stage stage= new Stage();
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen(); 

       } catch (IOException ex) {
            Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
       @FXML
   public void Stat(ActionEvent event){
       
       
       try{
      //     Node source = (Node) event.getSource();
    // Stage stage = (Stage) source.getScene().getWindow();
       //  stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("s.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
       Stage stage= new Stage();
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen(); 

       } catch (IOException ex) {
            Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
     @FXML
   public void Modifier(ActionEvent event){
       
          boolean c1=true;
        if(tab2.getSelectionModel().getSelectedItem()==null)
        {
           Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a note to edit!");
                alert.show();   
        c1=false;
        }
        
           if(c1==true)
        {
        
       try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Modifier_Note.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
     //  Stage stage= new Stage();
       Modifier_NoteController controller=fxmlLoader.getController();
       controller.initData(tab2.getSelectionModel().getSelectedItem(),students.getSelectionModel().getSelectedItem().toString());
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       
       } catch (IOException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   }
   
   
   @FXML
   public void mail(ActionEvent event) throws IOException{
        
           try {
               mailpdf();
           } catch (FileNotFoundException ex) {
               Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (DocumentException ex) {
               Logger.getLogger(NoteController.class.getName()).log(Level.SEVERE, null, ex);
           }
        String to = "alibekir199823@gmail.com";
            String subject = "Student report card";
            String message = "heni ya 9a7ba";
            String usermail = "baggira23@gmail.com";
            String passmail = "esprit23A";
            Mailing.send(to, subject, message, usermail, passmail);
        
        
               
   }
  @FXML 
        private void mailpdf()throws FileNotFoundException, DocumentException, BadElementException, IOException
  {
       if(tab2.getItems().isEmpty())
      {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a student first !");
                alert.show();   
      }
       else
       {
        String nom = "report.pdf";
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Heure = new SimpleDateFormat("hh:mm:ss");
            //Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
                                  
            WritableImage wimg = g.snapshot(new SnapshotParameters(), null);
            File file = new File("ChartSnapshot.png");
            ImageIO.write(SwingFXUtils.fromFXImage(wimg, null), "png", file);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(System.getProperty("user.home") + "\\Desktop\\" + nom));
            doc.open();
     
//            Image img = Image.getInstance("C:\\xampp\\htdocs\\TunisiaBonPlan2-Integration\\web\\uploads\\images\\Sanstitre.png");
            Image img = Image.getInstance("ChartSnapshot.png");
            doc.setPageSize(img);
            doc.setMargins(0, 0, 0, 20);
            doc.add(img);
            doc.close();
           // Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Desktop\\" + nom));
            writer.close();

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }
        
       }

  }
   
    @FXML
    private void convertirPDF(ActionEvent event) throws FileNotFoundException, DocumentException, BadElementException, IOException {
     if(tab2.getItems().isEmpty())
      {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a student first !");
                alert.show();   
      }
        else
     {
        String nom = "Note.pdf";
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat Heure = new SimpleDateFormat("hh:mm:ss");
            //Font f = new Font(FontFamily.HELVETICA, 13, Font.NORMAL, GrayColor.GRAYWHITE);
                                  
            WritableImage wimg = g.snapshot(new SnapshotParameters(), null);
            File file = new File("ChartSnapshot.png");
            ImageIO.write(SwingFXUtils.fromFXImage(wimg, null), "png", file);

            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(System.getProperty("user.home") + "\\Desktop\\" + nom));
            doc.open();
     
//            Image img = Image.getInstance("C:\\xampp\\htdocs\\TunisiaBonPlan2-Integration\\web\\uploads\\images\\Sanstitre.png");
            Image img = Image.getInstance("ChartSnapshot.png");
            doc.setPageSize(img);
            doc.setMargins(0, 0, 0, 20);
            doc.add(img);
            doc.close();
            Desktop.getDesktop().open(new File(System.getProperty("user.home") + "\\Desktop\\" + nom));
            writer.close();

        } catch (Exception e) {

            System.out.println("Error PDF");
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());

        }
     }
    }
    
      @FXML
  void pdf(ActionEvent event) {
      if(tab2.getItems().isEmpty())
      {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("Please select a student first !");
                alert.show();   
      }
      else
      {
 System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
  PageLayout paisagem = Printer.getDefaultPrinter().createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            
           job.printPage(paisagem, g);
          // job.printPage(g);
           job.endJob();
            
       

  }  
      } 
}
 

   @FXML public void retour(ActionEvent event){
         try{
            Node source = (Node) event.getSource();
     Stage stage = (Stage) source.getScene().getWindow();
         stage.hide(); 
           FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("mainwindow.fxml"));
           Parent root1=(Parent) fxmlLoader.load();
    
       stage.setScene(new Scene(root1));
       stage.show();
       stage.centerOnScreen();
       
       } catch (IOException ex) {
            Logger.getLogger(MatiereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}  

   
}

