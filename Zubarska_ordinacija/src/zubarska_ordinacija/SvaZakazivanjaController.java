/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.ZakazivanjeDAL;
import Entity.StaticnePromenjive;
import Entity.Zakazivanje;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class SvaZakazivanjaController implements Initializable {

    @FXML
    private TableView<Zakazivanje> table;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setValue(LocalDate.now());
        try {
            popuniZakazivanja();
        } catch (SQLException ex) {
            Logger.getLogger(SvaZakazivanjaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
        public void popuniZakazivanja() throws SQLException{
        
        table.getColumns().clear();
        //TableColumn<Zakazivanje,Integer> id=new TableColumn<Zakazivanje, Integer>("ID");
        TableColumn<Zakazivanje,String> ime=new TableColumn<Zakazivanje, String>("IME");
        ime.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> prezime=new TableColumn<Zakazivanje, String>("PREZIME");
        prezime.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> brojTelefona1=new TableColumn<Zakazivanje, String>("BROJ TELEFONA");
        brojTelefona1.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> datumivreme=new TableColumn<Zakazivanje, String>("DATUM");
        datumivreme.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,Time> vreme=new TableColumn<Zakazivanje, Time>("VREME");
        vreme.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> napomena=new TableColumn<Zakazivanje, String>("NAPOMENA");
        napomena.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> dosao=new TableColumn<Zakazivanje, String>("DOŠAO");
        dosao.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> otkazao=new TableColumn<Zakazivanje, String>("OTKAZAO");
        otkazao.setStyle("-fx-font-size:15px;");
        
        
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        brojTelefona1.setCellValueFactory(new PropertyValueFactory<>("brojTelefona1"));
        datumivreme.setCellValueFactory(new PropertyValueFactory<>("datumIVreme"));
        vreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
        napomena.setCellValueFactory(new PropertyValueFactory<>("napomena"));
        dosao.setCellValueFactory(new PropertyValueFactory<>("dosaoS"));
        otkazao.setCellValueFactory(new PropertyValueFactory<>("otkazaoS"));
        
        table.getColumns().addAll(ime, prezime, brojTelefona1, datumivreme, vreme, napomena, dosao, otkazao);
        ZakazivanjeDAL z= new ZakazivanjeDAL();
        ArrayList<Zakazivanje> lista=z.dajZakazanePoDatumu(java.sql.Date.valueOf(datePicker.getValue()));
        ObservableList<Zakazivanje> lista2=FXCollections.observableArrayList(lista);
        table.setItems(lista2);
    
    }

    @FXML
    private void datumClick(InputMethodEvent event) throws SQLException {
        popuniZakazivanja();
    }


    @FXML
    private void akcijaDatePicker(ActionEvent event) throws SQLException {
        popuniZakazivanja();
    }
    
}
