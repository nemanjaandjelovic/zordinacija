/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.ZakazivanjeDAL;
import Entity.StaticnePromenjive;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.text.MaskFormatter;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class ZakaziController implements Initializable {

    @FXML
    private DatePicker dateDatum;
    @FXML
    private TextField txtSati;
    @FXML
    private TextArea txtNapomena;
    @FXML
    private Button btnZakazi;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    

    @FXML
    private void btnZakaziClick(ActionEvent event) throws ParseException, SQLException {
        try{
        if(txtSati.getText().equals("") || dateDatum.getValue()==null){
         Alert al= new Alert(Alert.AlertType.ERROR, "Neispravan unos datuma ili vremena"); 
         al.show();
         return;
        }
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        java.util.Date vreme = (java.util.Date) format.parse(txtSati.getText());
        java.sql.Time vremeZaBazu = new java.sql.Time(vreme.getTime());
        
        java.sql.Date datumZaBazu = Date.valueOf(dateDatum.getValue());
        ZakazivanjeDAL z = new ZakazivanjeDAL();
        z.dodajZakazivanje(StaticnePromenjive.idPacijenta, txtNapomena.getText(), datumZaBazu, vremeZaBazu);
        Alert al= new Alert(Alert.AlertType.INFORMATION, "Uspešno ste zakazali termin"); 
        al.show();}
        catch(Exception ex){
         Alert al= new Alert(Alert.AlertType.ERROR, "Neispravan format vremena, morate upisati u formatu 12:24"); 
         al.show();
        }
    }

    @FXML
    private void zakaziHoverExit(MouseEvent event) {
        btnZakazi.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void zakaziHover(MouseEvent event) {
        btnZakazi.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 10;");
    }
}
