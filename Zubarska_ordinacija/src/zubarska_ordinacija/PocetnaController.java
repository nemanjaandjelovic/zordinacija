/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.ZakazivanjeDAL;
import Entity.Zakazivanje;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class PocetnaController implements Initializable {

    @FXML
    private TableView<Zakazivanje> tbRezervacije;
    @FXML
    private Button btnPacijenti;
    private Button btnIntervencije;
    @FXML
    private Button btnSvaZakazivanja;
    @FXML
    private ImageView imgLogo;
    @FXML
    private Button btnDosao;
    @FXML
    private Button btnOtkazao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniZakazivanja();
            tbRezervacije.getSelectionModel().selectFirst();
        } catch (SQLException ex) {
            Logger.getLogger(PocetnaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void popuniZakazivanja() throws SQLException{
        
        tbRezervacije.getColumns().clear();
        //TableColumn<Zakazivanje,Integer> id=new TableColumn<Zakazivanje, Integer>("ID");
        TableColumn<Zakazivanje,String> ime=new TableColumn<Zakazivanje, String>("IME");
        ime.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> prezime=new TableColumn<Zakazivanje, String>("PREZIME");
        prezime.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> brojTelefona1=new TableColumn<Zakazivanje, String>("BROJ TELEFONA");
        brojTelefona1.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,String> datumivreme=new TableColumn<Zakazivanje, String>("DATUM");
        datumivreme.setStyle("-fx-font-size:15px;");
        TableColumn<Zakazivanje,java.sql.Time> vreme=new TableColumn<Zakazivanje, java.sql.Time>("VREME");
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
        
        tbRezervacije.getColumns().addAll(ime, prezime, brojTelefona1, datumivreme, vreme, napomena, dosao, otkazao);
        ZakazivanjeDAL z= new ZakazivanjeDAL();
        ArrayList<Zakazivanje> lista=z.dajSvaZakazivanja();
        ObservableList<Zakazivanje> lista2=FXCollections.observableArrayList(lista);
        tbRezervacije.setItems(lista2);
    
    }
    
    @FXML
    private void btnPacijentiClick(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pacijenti.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
          }
    }
    
    @FXML
    private void btnSvaZakazivanjaClick(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SvaZakazivanja.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
          }
    }


    @FXML
    private void pacijentiHover(MouseEvent event) {
       // btnPacijenti.setBackground(Background.EMPTY);
        btnPacijenti.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void pacijentiHoverExit(MouseEvent event) {
        btnPacijenti.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void svaZakazivanjaHoverExit(MouseEvent event) {
        btnSvaZakazivanja.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void svaZakazivanjaHover(MouseEvent event) {
        btnSvaZakazivanja.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 10;");
    }
    

    @FXML
    private void dosaoHoverExit(MouseEvent event) {
        btnDosao.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 5;");
    }

    @FXML
    private void dosaoHover(MouseEvent event) {
         btnDosao.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 5;");
    }

    @FXML
    private void btnDosaoClick(ActionEvent event) throws SQLException {
        try {
        ZakazivanjeDAL z=new ZakazivanjeDAL();
        z.dosao(tbRezervacije.getSelectionModel().getSelectedItem().getIdZakazivanje());
        popuniZakazivanja();
        tbRezervacije.getSelectionModel().selectFirst();
        }
        catch(Exception e) {}
    }

    @FXML
    private void otkazaoHoverExit(MouseEvent event) {
        btnOtkazao.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 5;");
    }

    @FXML
    private void otkazaoHover(MouseEvent event) {
        btnOtkazao.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 5;");
    }

    @FXML
    private void btnOtkazaoClick(ActionEvent event) {
        try {
        ZakazivanjeDAL z=new ZakazivanjeDAL();
        z.otkazao(tbRezervacije.getSelectionModel().getSelectedItem().getIdZakazivanje());
        popuniZakazivanja();
        tbRezervacije.getSelectionModel().selectFirst();
        }
        catch(Exception e) {}
    }
    
}
