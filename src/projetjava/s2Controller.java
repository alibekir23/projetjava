
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import entities.Note;
import services.*;
import com.jfoenix.controls.JFXButton;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import javafx.scene.image.WritableImage;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXComboBox;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;
import javax.imageio.ImageIO;
import utils.ConnexionBD;

 

/**
 * FXML Controller class
 *
 * @author omaima
 */
public class s2Controller implements Initializable{
      
   private Connection con = ConnexionBD.getInstance().getCnx();

 private Note serv = new Note();
   @FXML
    private Button pdf;
   Document doc = new Document();

  
   
   @FXML
   private GridPane g;

    @FXML
    private BarChart<String, Float> barChart;
    

    /**
     * Initializes the controller class.
     */
        @FXML private Label classe ;
         @FXML private Label student ;
      
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
        
   
        // TODO
        // TODO
    }    
    

    
   
   @FXML
  void pdf(ActionEvent event) {
 System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(primaryStage); 
            
 
           job.printPage(g);
           job.endJob();
            
       

  }  
    
}
  
  
    
    
    
    
     @FXML
    private void convertirPDF(ActionEvent event) throws FileNotFoundException, DocumentException, BadElementException, IOException {
     Parent  conn_page = FXMLLoader.load(getClass().getResource("s.fxml"));
        String nom = "Graph statistique.pdf";
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
    
  

             public void initData(String email)
{
    
  
       
       ServiceNote no= new ServiceNote();
  
 
           XYChart.Series<String, Float> series = new XYChart.Series<String, Float>();
            if   (barChart.getData().equals(series))
            {barChart.getData().clear();
            }
            

         
     
        String req="select distinct m.title ,n.note,u.fistname,u.lastname,c.name from module m,note n,user u,classes c where u.email='" + email + "' and u.idclass=c.id ";
       
      
        try {
             PreparedStatement ste = (PreparedStatement) con.prepareStatement(req);
            ResultSet rs = ste.executeQuery();
            while (rs.next()){
                String s=rs.getString(1);
                String nom=rs.getString(3);
                String prenom=rs.getString(4);
             
                student.setText(nom+" "+prenom);
                    classe.setText(rs.getString(5));
            Float f=rs.getFloat(2);
                System.out.println(s);
                System.out.println(f);
                series.getData().add(new XYChart.Data<>(s, f));
            }
            barChart.getData().add(series);
          
        } catch (SQLException ex) {
            Logger.getLogger(sController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
              
       
       
       
       
   
}
  

}
