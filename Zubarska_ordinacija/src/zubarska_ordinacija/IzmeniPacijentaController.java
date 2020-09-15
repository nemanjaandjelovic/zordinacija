/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.DrzaveDAL;
import DAL.GradDAL;
import DAL.PacijentiDAL;
import Entity.Drzave;
import Entity.Gradovi;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class IzmeniPacijentaController implements Initializable {

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
    private Button btnIzmeniPacijenta;
    @FXML
    private ComboBox<Drzave> drzava;
    @FXML
    private ComboBox<Gradovi> grad;
    private Ireload refresujGreed;

    
    
    
    public Ireload getRefresujGreed() {
        return refresujGreed;
    }

    public void setRefresujGreed(Ireload refresujGreed) {
        this.refresujGreed = refresujGreed;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniCmbDrzave();
            popuniCmbGradovi();
            popuniPodatkePacijenta();
        } catch (SQLException ex) {
            Logger.getLogger(DodajPacijentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void popuniPodatkePacijenta() throws SQLException{
        
        PacijentiDAL p= new PacijentiDAL();
        Pacijenti pp= p.dajPacijentaPoId(StaticnePromenjive.idPacijenta);
        Drzave d = new Drzave(pp.getIdDrzave(), pp.getImedrzave());
        Gradovi g = new Gradovi(pp.getIdGrada(), pp.getImegrada());
        txtIme.setText(pp.getIme());
        txtPrezime.setText(pp.getPrezime());
        txtBrojTelefona.setText(pp.getBrojTelefona1());
        txtBrojTelefona2.setText(pp.getBrojTelefona2());
        txtEmail.setText(pp.getEmail());
        drzava.getSelectionModel().select(d);
        grad.getSelectionModel().select(g);
    
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
    private void btnIzmeniPacijentaClick(ActionEvent event) throws SQLException {
        PacijentiDAL d= new PacijentiDAL();
        d.izmeniPacijenta(txtIme.getText(), txtPrezime.getText(), txtBrojTelefona.getText(), txtBrojTelefona2.getText(), txtEmail.getText(), drzava.getSelectionModel().getSelectedItem().getIdDrzave(), grad.getSelectionModel().getSelectedItem().getIdGrada(), StaticnePromenjive.idPacijenta);
        refresujGreed.refreshGreed();
        Alert al= new Alert(Alert.AlertType.INFORMATION, "Uspešno ste izmenili Pacijenta"); 
        al.show();
    }

    @FXML
    private void izmeniPacijentaExit(MouseEvent event) {
      btnIzmeniPacijenta.setStyle("-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #cce7e8; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void izmeniPacijentaHover(MouseEvent event) {
      btnIzmeniPacijenta.setStyle("-fx-background-color:#dae7f3;-fx-background-color: #69bdd2; -fx-background-radius: 25; -fx-border-color: #fff; -fx-border-radius: 15; -fx-border-width: 10;");
    }
    

}
