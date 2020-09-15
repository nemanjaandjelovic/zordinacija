/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.DrzaveDAL;
import DAL.GradDAL;
import DAL.Konekcija;
import DAL.PacijentiDAL;
import Entity.Drzave;
import Entity.Gradovi;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class DodajPacijentaController implements Initializable {
    
    @FXML
    private TextField txtIme;
    @FXML
    private TextField txtPrezime;
    @FXML
    private TextField txtBrojTelefona;
    @FXML
    private TextField txtBrojTelefona2;
    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnDodajPacijenta;
    @FXML
    private ComboBox<Drzave> drzava;
    @FXML
    private ComboBox<Gradovi> grad;
    @FXML
    private AnchorPane cmbDrzava;
    private Ireload refresujGrid;


    
    public Ireload getRefresujGrid() {
        return refresujGrid;
    }

    public void setRefresujGrid(Ireload refresujGrid) {
        this.refresujGrid = refresujGrid;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniCmbDrzave();
            popuniCmbGradovi();
        } catch (SQLException ex) {
            Logger.getLogger(DodajPacijentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void popuniCmbDrzave() throws SQLException{
        
        ArrayList<Drzave> lista;
        DrzaveDAL d=new DrzaveDAL();
        lista=d.dajSveDrzave();
        ObservableList<Drzave> lista2=FXCollections.observableArrayList(lista);
        drzava.setItems(lista2);
    }
    
    public void popuniCmbGradovi() throws SQLException{
        
        ArrayList<Gradovi> lista;
        GradDAL g=new GradDAL();
        lista=g.dajSveGradove();
        ObservableList<Gradovi> lista2=FXCollections.observableArrayList(lista);
        grad.setItems(lista2);
    }

    @FXML
    private void btnDodajPacijentaClick(ActionEvent event) throws SQLException {
        try{
     int idDrzave=drzava.getSelectionModel().getSelectedItem().getIdDrzave();
     int idGrada=grad.getSelectionModel().getSelectedItem().getIdGrada();
     String ime=txtIme.getText();
     String prezime=txtPrezime.getText();
     String brojTelefona1=txtBrojTelefona.getText();
     String brojTelefona2=txtBrojTelefona2.getText();
     String email=txtEmail.getText();
     PacijentiDAL d= new PacijentiDAL();
     d.dodajPacijenta(ime, prezime, brojTelefona1, brojTelefona2, email, idGrada, idDrzave);
     refresujGrid.refreshGreed();
    
        Alert al= new Alert(Alert.AlertType.INFORMATION, "Uspešno ste dodali Pacijenta"); 
        al.show(); }
        catch(Exception ex){
         Alert al= new Alert(Alert.AlertType.ERROR, "Morate popuniti sva polja"); 
         al.show(); }
    }

    @FXML
    private void dodajPacijentaExit(MouseEvent event) {
        btnDodajPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void dodajPacijentaHover(MouseEvent event) {
        btnDodajPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 10;");
    }
    
}
