/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.KartonDAL;
import Entity.StaticnePromenjive;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class DodajIntervencijuController implements Initializable {

    @FXML
    private ImageView treciKutnjakGoreLevo;
    @FXML
    private ImageView drugiKutnjakGoreLevo;
    @FXML
    private ImageView prviKutnjakGoreLevo;
    @FXML
    private ImageView drugiPretkutnjakGoreLevo;
    @FXML
    private ImageView prviPretkutnjakGoreLevo;
    @FXML
    private ImageView ocnjakGoreLevo;
    @FXML
    private ImageView lateralniSekuticGoreLevo;
    @FXML
    private ImageView centralniSekuticGoreLevo;
    @FXML
    private ImageView centralniSekuticGoreDesno;
    @FXML
    private ImageView lateralniSekuticGoreDesno;
    @FXML
    private ImageView ocnjakGoreDesno;
    @FXML
    private ImageView prviPretkutnjakGoreDesno;
    @FXML
    private ImageView drugiPretkutnjakGoreDesno;
    @FXML
    private ImageView prviKutnjakGoreDesno;
    @FXML
    private ImageView drugiKutnjakGoreDesno;
    @FXML
    private ImageView treciKutnjakGoreDesno;
    @FXML
    private ImageView treciKutnjakDoleLevo;
    @FXML
    private ImageView drugiKutnjakDoleLevo;
    @FXML
    private ImageView prviKutnjakDoleLevo;
    @FXML
    private ImageView drugiPretkutnjakDoleLevo;
    @FXML
    private ImageView prviPretkutnjakDoleLevo;
    @FXML
    private ImageView ocnjakDoleLevo;
    @FXML
    private ImageView lateralniSekuticDoleLevo;
    @FXML
    private ImageView centralniSekuticDoleLevo;
    @FXML
    private ImageView treciKutnjakDoleDesno;
    @FXML
    private ImageView drugiKutnjakDoleDesno;
    @FXML
    private ImageView prviKutnjakDoleDesno;
    @FXML
    private ImageView drugiPretkutnjakDoleDesno;
    @FXML
    private ImageView prviPretkutnjakDoleDesno;
    @FXML
    private ImageView ocnjakDoleDesno;
    @FXML
    private ImageView lateralniSekuticDoleDesno;
    @FXML
    private ImageView centralniSekuticDoleDesno;
    @FXML
    private Button btnSacuvaj;
    
    // ako je int 0 znaci da zub nije izabran ako je 1 znaci da je izabran
    private ArrayList<Integer> listaZuba;
    @FXML
    private TextField txtNaslov;
    @FXML
    private TextArea txtOpis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaZuba=new ArrayList<>();
        for(int i=0;i<34;i++){
            listaZuba.add(0);
        }
        // TODO
    }    
    
    

    @FXML
    private void zub_8(MouseEvent event) {
        if(listaZuba.get(8)==0){
        listaZuba.set(8, 1);
        Image i1 = new Image("/Slike/8.png");
        treciKutnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(8, 0);
        Image i1 = new Image("/Slike/gore_levo_8.png");
        treciKutnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_7(MouseEvent event) {
        if(listaZuba.get(7)==0){
        listaZuba.set(7, 1);
        Image i1 = new Image("/Slike/7.png");
        drugiKutnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(7, 0);
        Image i1 = new Image("/Slike/gore_levo_7.png");
        drugiKutnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_6(MouseEvent event) {
        if(listaZuba.get(6)==0){
        listaZuba.set(6, 1);
        Image i1 = new Image("/Slike/6.png");
        prviKutnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(6, 0);
        Image i1 = new Image("/Slike/gore_levo_6.png");
        prviKutnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_5(MouseEvent event) {
        if(listaZuba.get(5)==0){
        listaZuba.set(5, 1);
        Image i1 = new Image("/Slike/5.png");
        drugiPretkutnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(5, 0);
        Image i1 = new Image("/Slike/gore_levo_5.png");
        drugiPretkutnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_4(MouseEvent event) {
        if(listaZuba.get(4)==0){
        listaZuba.set(4, 1);
        Image i1 = new Image("/Slike/4.png");
        prviPretkutnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(4, 0);
        Image i1 = new Image("/Slike/gore_levo_4.png");
        prviPretkutnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_3(MouseEvent event) {
        if(listaZuba.get(3)==0){
        listaZuba.set(3, 1);
        Image i1 = new Image("/Slike/3.png");
        ocnjakGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(3, 0);
        Image i1 = new Image("/Slike/gore_levo_3.png");
        ocnjakGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_2(MouseEvent event) {
        if(listaZuba.get(2)==0){
        listaZuba.set(2, 1);
        Image i1 = new Image("/Slike/2.png");
        lateralniSekuticGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(2, 0);
        Image i1 = new Image("/Slike/gore_levo_2.png");
        lateralniSekuticGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_1(MouseEvent event) {
        if(listaZuba.get(1)==0){
        listaZuba.set(1, 1);
        Image i1 = new Image("/Slike/1.png");
        centralniSekuticGoreLevo.setImage(i1);
        }
        else{
        listaZuba.set(1, 0);
        Image i1 = new Image("/Slike/gore_levo_1.png");
        centralniSekuticGoreLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_9(MouseEvent event) {
        if(listaZuba.get(9)==0){
        listaZuba.set(9, 1);
        Image i1 = new Image("/Slike/9.png");
        centralniSekuticGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(9, 0);
        Image i1 = new Image("/Slike/gore_desno_01.png");
        centralniSekuticGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_10(MouseEvent event) {
        if(listaZuba.get(10)==0){
        listaZuba.set(10, 1);
        Image i1 = new Image("/Slike/10.png");
        lateralniSekuticGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(10, 0);
        Image i1 = new Image("/Slike/gore_desno_02.png");
        lateralniSekuticGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_11(MouseEvent event) {
        if(listaZuba.get(11)==0){
        listaZuba.set(11, 1);
        Image i1 = new Image("/Slike/11.png");
        ocnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(11, 0);
        Image i1 = new Image("/Slike/gore_desno_03.png");
        ocnjakGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_12(MouseEvent event) {
        if(listaZuba.get(12)==0){
        listaZuba.set(12, 1);
        Image i1 = new Image("/Slike/12.png");
        prviPretkutnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(12, 0);
        Image i1 = new Image("/Slike/gore_desno_04.png");
        prviPretkutnjakGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_13(MouseEvent event) {
        if(listaZuba.get(13)==0){
        listaZuba.set(13, 1);
        Image i1 = new Image("/Slike/13.png");
        drugiPretkutnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(13, 0);
        Image i1 = new Image("/Slike/gore_desno_05.png");
        drugiPretkutnjakGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_14(MouseEvent event) {
        if(listaZuba.get(14)==0){
        listaZuba.set(14, 1);
        Image i1 = new Image("/Slike/14.png");
        prviKutnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(14, 0);
        Image i1 = new Image("/Slike/gore_desno_06.png");
        prviKutnjakGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_15(MouseEvent event) {
        if(listaZuba.get(15)==0){
        listaZuba.set(15, 1);
        Image i1 = new Image("/Slike/15.png");
        drugiKutnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(15, 0);
        Image i1 = new Image("/Slike/gore_desno_07.png");
        drugiKutnjakGoreDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_16(MouseEvent event) {
        if(listaZuba.get(16)==0){
        listaZuba.set(16, 1);
        Image i1 = new Image("/Slike/16.png");
        treciKutnjakGoreDesno.setImage(i1);
        }
        else{
        listaZuba.set(16, 0);
        Image i1 = new Image("/Slike/gore_desno_08.png");
        treciKutnjakGoreDesno.setImage(i1);
        }
    }


    @FXML
    private void btnSacuvajClick(ActionEvent event) throws SQLException {
        KartonDAL d=new KartonDAL();
        int idIntervencije=d.dodajIntervenciju(1, StaticnePromenjive.idPacijenta, txtNaslov.getText(), txtOpis.getText(), 1);
        for(int i=0; i<listaZuba.size(); i++){
            if(listaZuba.get(i)==1){
                d.dodajZubZaIntervenciju(idIntervencije, i);
            }
        }
        Alert al= new Alert(Alert.AlertType.INFORMATION, "Uspešno ste dodali intervenciju"); 
        al.show();
        
    }
    
    @FXML
    private void sacuvajIntervencijuExit(MouseEvent event) {
        btnSacuvaj.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-border-color:#69bdd2; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void sacuvajIntervencijuHover(MouseEvent event) {
      btnSacuvaj.setStyle("-fx-background-color: white; -fx-background-radius: 25; -fx-border-color:black; -fx-border-radius: 15; -fx-border-width: 10;");
    }

    @FXML
    private void zub_24(MouseEvent event) {
        if(listaZuba.get(24)==0){
        listaZuba.set(24, 1);
        Image i1 = new Image("/Slike/24.png");
        treciKutnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(24, 0);
        Image i1 = new Image("/Slike/dole_levo_8.png");
        treciKutnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_23(MouseEvent event) {
        if(listaZuba.get(23)==0){
        listaZuba.set(23, 1);
        Image i1 = new Image("/Slike/23.png");
        drugiKutnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(23, 0);
        Image i1 = new Image("/Slike/dole_levo_7.png");
        drugiKutnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_22(MouseEvent event) {
        if(listaZuba.get(22)==0){
        listaZuba.set(22, 1);
        Image i1 = new Image("/Slike/22.png");
        prviKutnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(22, 0);
        Image i1 = new Image("/Slike/dole_levo_6.png");
        prviKutnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_21(MouseEvent event) {
        if(listaZuba.get(21)==0){
        listaZuba.set(21, 1);
        Image i1 = new Image("/Slike/21.png");
        drugiPretkutnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(21, 0);
        Image i1 = new Image("/Slike/dole_levo_5.png");
        drugiPretkutnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_20(MouseEvent event) {
        if(listaZuba.get(20)==0){
        listaZuba.set(20, 1);
        Image i1 = new Image("/Slike/20.png");
        prviPretkutnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(20, 0);
        Image i1 = new Image("/Slike/dole_levo_4.png");
        prviPretkutnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_19(MouseEvent event) {
        if(listaZuba.get(19)==0){
        listaZuba.set(19, 1);
        Image i1 = new Image("/Slike/19.png");
        ocnjakDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(19, 0);
        Image i1 = new Image("/Slike/dole_levo_3.png");
        ocnjakDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_18(MouseEvent event) {
        if(listaZuba.get(18)==0){
        listaZuba.set(18, 1);
        Image i1 = new Image("/Slike/18.png");
        lateralniSekuticDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(18, 0);
        Image i1 = new Image("/Slike/dole_levo_2.png");
        lateralniSekuticDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_17(MouseEvent event) {
        if(listaZuba.get(17)==0){
        listaZuba.set(17, 1);
        Image i1 = new Image("/Slike/17.png");
        centralniSekuticDoleLevo.setImage(i1);
        }
        else{
        listaZuba.set(17, 0);
        Image i1 = new Image("/Slike/dole_levo_1.png");
        centralniSekuticDoleLevo.setImage(i1);
        }
    }

    @FXML
    private void zub_32(MouseEvent event) {
        if(listaZuba.get(32)==0){
        listaZuba.set(32, 1);
        Image i1 = new Image("/Slike/32.png");
        treciKutnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(32, 0);
        Image i1 = new Image("/Slike/dole_desno_8.png");
        treciKutnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_31(MouseEvent event) {
        if(listaZuba.get(31)==0){
        listaZuba.set(31, 1);
        Image i1 = new Image("/Slike/31.png");
        drugiKutnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(31, 0);
        Image i1 = new Image("/Slike/dole_desno_7.png");
        drugiKutnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_30(MouseEvent event) {
        if(listaZuba.get(30)==0){
        listaZuba.set(30, 1);
        Image i1 = new Image("/Slike/30.png");
        prviKutnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(30, 0);
        Image i1 = new Image("/Slike/dole_desno_6.png");
        prviKutnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_29(MouseEvent event) {
        if(listaZuba.get(29)==0){
        listaZuba.set(29, 1);
        Image i1 = new Image("/Slike/29.png");
        drugiPretkutnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(29, 0);
        Image i1 = new Image("/Slike/dole_desno_5.png");
        drugiPretkutnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_28(MouseEvent event) {
        if(listaZuba.get(28)==0){
        listaZuba.set(28, 1);
        Image i1 = new Image("/Slike/28.png");
        prviPretkutnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(28, 0);
        Image i1 = new Image("/Slike/dole_desno_4.png");
        prviPretkutnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_27(MouseEvent event) {
        if(listaZuba.get(27)==0){
        listaZuba.set(27, 1);
        Image i1 = new Image("/Slike/27.png");
        ocnjakDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(27, 0);
        Image i1 = new Image("/Slike/dole_desno_3.png");
        ocnjakDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_26(MouseEvent event) {
        if(listaZuba.get(26)==0){
        listaZuba.set(26, 1);
        Image i1 = new Image("/Slike/26.png");
        lateralniSekuticDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(26, 0);
        Image i1 = new Image("/Slike/dole_desno_2.png");
        lateralniSekuticDoleDesno.setImage(i1);
        }
    }

    @FXML
    private void zub_25(MouseEvent event) {
        if(listaZuba.get(25)==0){
        listaZuba.set(25, 1);
        Image i1 = new Image("/Slike/25.png");
        centralniSekuticDoleDesno.setImage(i1);
        }
        else{
        listaZuba.set(25, 0);
        Image i1 = new Image("/Slike/dole_desno_1.png");
        centralniSekuticDoleDesno.setImage(i1);
        }
    }

}
