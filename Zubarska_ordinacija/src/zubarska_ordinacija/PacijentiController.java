/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.PacijentiDAL;
import Entity.Pacijenti;
import Entity.StaticnePromenjive;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class PacijentiController implements Initializable, Ireload {

    @FXML
    private Button btnDodajPacijenta;
    @FXML
    private Button btnIzmeniPacijenta;
    @FXML
    private Button btnObrisiPacijenta;
    @FXML
    private TableView<Pacijenti> tbPacijenti;
    @FXML
    private Button btnKartonPacijenta;
    @FXML
    private TextField txtPretraga;
    @FXML
    private Button btnPretrazi;
    @FXML
    private Button btnDodajIntervenciju;
    @FXML
    private Button btnZakazi;
    @FXML
    private Button btnOsvezi;
    private static DodajPacijentaController dodajPacijentaCon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniListuPacijenata();
        } catch (SQLException ex) {
            Logger.getLogger(PacijentiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
       public void popunjavanjePacijenataIPretraga(String parametar) throws SQLException{
        
        tbPacijenti.getColumns().clear();
      //  TableColumn<Pacijenti,Integer> id=new TableColumn<Pacijenti, Integer>("ID");
        TableColumn<Pacijenti,String> ime=new TableColumn<Pacijenti, String>("IME");
        ime.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> prezime=new TableColumn<Pacijenti, String>("PREZIME");
        prezime.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> brojTelefona1=new TableColumn<Pacijenti, String>("BROJ TELEFONA");
        brojTelefona1.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> brojTelefona2=new TableColumn<Pacijenti, String>("BROJ TELEFONA(2)");
        brojTelefona2.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> email=new TableColumn<Pacijenti, String>("EMAIL");
        email.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> grad=new TableColumn<Pacijenti, String>("GRAD");
        grad.setStyle("-fx-font-size:15px;");
        TableColumn<Pacijenti,String> drzava=new TableColumn<Pacijenti, String>("DRŽAVA");
        drzava.setStyle("-fx-font-size:15px;");
        
       // id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        brojTelefona1.setCellValueFactory(new PropertyValueFactory<>("brojTelefona1"));
        brojTelefona2.setCellValueFactory(new PropertyValueFactory<>("brojTelefona2"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        grad.setCellValueFactory(new PropertyValueFactory<>("imegrada"));
        drzava.setCellValueFactory(new PropertyValueFactory<>("imedrzave"));
        
        tbPacijenti.getColumns().addAll(ime, prezime, brojTelefona1, brojTelefona2, email, grad, drzava);
        PacijentiDAL p= new PacijentiDAL();
        ArrayList<Pacijenti> lista=p.pretraziPacijenta(parametar);
        ObservableList<Pacijenti> lista2=FXCollections.observableArrayList(lista);
        tbPacijenti.setItems(lista2);
        tbPacijenti.getSelectionModel().selectFirst();
        if(lista.isEmpty()){
            btnKartonPacijenta.setDisable(true);
        }
    }
    
    public void popuniListuPacijenata() throws SQLException{
       popunjavanjePacijenataIPretraga("");
}

    @FXML
    private void btnDodajPacijentaClick(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DodajPacijenta.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            dodajPacijentaCon = (DodajPacijentaController) fxmlLoader.getController();
            dodajPacijentaCon.setRefresujGrid(this);
            stage.show();
        } catch(Exception e) {
          }
    }

    @FXML
    private void btnIzmeniPacijentaClick(ActionEvent event) {
          try {
            StaticnePromenjive.idPacijenta=tbPacijenti.getSelectionModel().getSelectedItem().getId();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IzmeniPacijenta.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            IzmeniPacijentaController izmeni = (IzmeniPacijentaController) fxmlLoader.getController();
            izmeni.setRefresujGreed(this);
            stage.show();
        } catch(Exception e) {
          }
    }

    @FXML
    private void btnObrisiPacijentaClick(ActionEvent event) throws SQLException{
        
        PacijentiDAL d=new PacijentiDAL();
        try {
            d.obrisiPacijenta(tbPacijenti.getSelectionModel().getSelectedItem().getId());
            popunjavanjePacijenataIPretraga("");
        } catch (Exception ex) {
            Alert al= new Alert(Alert.AlertType.INFORMATION, "Morate izabrati pacijenta kojeg zelite da obrisete"); 
            al.show();
        }

    }

    @FXML
    private void btnKartonPacijentaClick(ActionEvent event) {
         try {
            StaticnePromenjive.idPacijenta=tbPacijenti.getSelectionModel().getSelectedItem().getId();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KartonPacijenta.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
          }
    }

    @FXML
    private void btnPretraziClick(ActionEvent event) throws SQLException {
        popunjavanjePacijenataIPretraga(txtPretraga.getText());
    }

    @FXML
    private void btnDodajIntervencijuClick(ActionEvent event) {
         try {
            StaticnePromenjive.idPacijenta=tbPacijenti.getSelectionModel().getSelectedItem().getId();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DodajIntervenciju.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
          }
    }

    @FXML
    private void btnZakaziClick(ActionEvent event) {
           try {
            StaticnePromenjive.idPacijenta=tbPacijenti.getSelectionModel().getSelectedItem().getId();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Zakazi.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(Exception e) {
          }
    }

    @FXML
    private void dodajPacijentaExit(MouseEvent event) {
      btnDodajPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");
    }

    @FXML
    private void dodajPacijentaHover(MouseEvent event) {
      btnDodajPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");
    }

    @FXML
    private void izmeniPacijentaExit(MouseEvent event) {
      btnIzmeniPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void izmeniPacijentaHover(MouseEvent event) {
      btnIzmeniPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void obrisiPacijentaExit(MouseEvent event) {
      btnObrisiPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void obrisiPacijentaHover(MouseEvent event) {
      btnObrisiPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void kartonPacijentaExit(MouseEvent event) {
      btnKartonPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void kartonPacijentaHover(MouseEvent event) {
      btnKartonPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void pretraziHoverExit(MouseEvent event) {
      btnPretrazi.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void pretraziHover(MouseEvent event) {
      btnPretrazi.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void dodajIntervencijuExit(MouseEvent event) {
      btnDodajIntervenciju.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void dodajIntervencijuHover(MouseEvent event) {
      btnDodajIntervenciju.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void zakaziHoverExit(MouseEvent event) {
      btnZakazi.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void zakaziHover(MouseEvent event) {
      btnZakazi.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 8;");

    }

    @FXML
    private void btnOsveziClick(ActionEvent event) throws SQLException {
        popuniListuPacijenata();
    }

    @Override
    public void refreshGreed() {
        try {
            popuniListuPacijenata();
        } catch (SQLException ex) {
            Logger.getLogger(PacijentiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    
}
