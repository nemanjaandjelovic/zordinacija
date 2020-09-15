/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zubarska_ordinacija;

import DAL.KartonDAL;
import Entity.Karton;
import Entity.StaticnePromenjive;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author HP Omen
 */
public class KartonPacijentaController implements Initializable {

    @FXML
    private TableView<Karton> tbIntervencija;
    @FXML
    private TextField txtNaslov;
    @FXML
    private TextArea txtOpis;
    @FXML
    private ImageView treciKutnjakGoreLevo;
    
    private ArrayList<ImageView> zubi;
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
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            popuniIntervencije();
            zubi=new ArrayList<ImageView>();
            ImageView nulti = new ImageView();
            zubi.add(nulti);
            zubi.add(centralniSekuticGoreLevo); //1
            zubi.add(lateralniSekuticGoreLevo); //2
            zubi.add(ocnjakGoreLevo); //3
            zubi.add(prviPretkutnjakGoreLevo); //4
            zubi.add(drugiPretkutnjakGoreLevo); //5
            zubi.add(prviKutnjakGoreLevo); //6
            zubi.add(drugiKutnjakGoreLevo); //7
            zubi.add(treciKutnjakGoreLevo); //8
            zubi.add(centralniSekuticGoreDesno); //9
            zubi.add(lateralniSekuticGoreDesno); //10
            zubi.add(ocnjakGoreDesno); //11
            zubi.add(prviPretkutnjakGoreDesno); //12
            zubi.add(drugiPretkutnjakGoreDesno); //13
            zubi.add(prviKutnjakGoreDesno); //14
            zubi.add(drugiKutnjakGoreDesno); //15
            zubi.add(treciKutnjakGoreDesno); //16
            zubi.add(centralniSekuticDoleLevo); //17
            zubi.add(lateralniSekuticDoleLevo); //18
            zubi.add(ocnjakDoleLevo); //19
            zubi.add(prviPretkutnjakDoleLevo); //20
            zubi.add(drugiPretkutnjakDoleLevo); //21
            zubi.add(prviKutnjakDoleLevo); //22
            zubi.add(drugiKutnjakDoleLevo); //23
            zubi.add(treciKutnjakDoleLevo); //24
            zubi.add(centralniSekuticDoleDesno); //25
            zubi.add(lateralniSekuticDoleDesno); //26
            zubi.add(ocnjakDoleDesno); //27
            zubi.add(prviPretkutnjakDoleDesno); //28
            zubi.add(drugiPretkutnjakDoleDesno); //29
            zubi.add(prviKutnjakDoleDesno); //30
            zubi.add(drugiKutnjakDoleDesno); //31
            zubi.add(treciKutnjakDoleDesno); //32
            
        } catch (SQLException ex) {
            Logger.getLogger(KartonPacijentaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    //prikazati id intervencije, zaposlenog koji je radio i datum 
    //dajKartonZaPacijenta
    public void popuniIntervencije() throws SQLException{
        
        tbIntervencija.getColumns().clear();
//      TableColumn<Karton,Integer> idintervencije=new TableColumn<Karton, Integer>("ID");
        TableColumn<Karton,Integer> idZaposleni=new TableColumn<Karton, Integer>("ID Zaposlenog");
        TableColumn<Karton,String> imePrezimeZaposlenog=new TableColumn<Karton, String>("ZAPOSLENI");
        imePrezimeZaposlenog.setStyle("-fx-font-size:13px;");
        TableColumn<Karton,String> naslovIntervencije=new TableColumn<Karton, String>("NASLOV INTERVENCIJE");
        naslovIntervencije.setStyle("-fx-font-size:13px;");
        TableColumn<Karton,Date> datumVremeIntervencije=new TableColumn<Karton, Date>("DATUM I VREME");
//        datumVremeIntervencije.setStyle("-fx-font-size:13px;");
//        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
//        formatter.format(datumVremeIntervencije);
        TableColumn<Karton,String> opisIntervencije=new TableColumn<Karton, String>("Opis intervencije");
        
//      idintervencije.setCellValueFactory(new PropertyValueFactory<>("idintervencije"));
        idZaposleni.setCellValueFactory(new PropertyValueFactory<>("idZaposleni"));
        imePrezimeZaposlenog.setCellValueFactory(new PropertyValueFactory<>("imePrezimeZaposlenog"));
        naslovIntervencije.setCellValueFactory(new PropertyValueFactory<>("naslovIntervencije"));
        datumVremeIntervencije.setCellValueFactory(new PropertyValueFactory<>("datumVremeIntervencije"));
        opisIntervencije.setCellValueFactory(new PropertyValueFactory<>("opisIntervencije"));
        
        tbIntervencija.getColumns().addAll(naslovIntervencije, imePrezimeZaposlenog, datumVremeIntervencije);
        KartonDAL k= new KartonDAL();
        ArrayList<Karton> lista=k.dajKartonZaPacijenta(StaticnePromenjive.idPacijenta);
        ObservableList<Karton> lista2=FXCollections.observableArrayList(lista);
        tbIntervencija.setItems(lista2);
    }

    @FXML
    private void tbIntervencijeMouseClicked(MouseEvent event) throws SQLException {
        try{
        resetujZube();
        int idIntervencije=tbIntervencija.getSelectionModel().getSelectedItem().getIdintervencije();
        KartonDAL k=new KartonDAL();
        Karton ka=k.dajIntervenciju(idIntervencije);
        txtOpis.setText(ka.getOpisIntervencije());
        txtNaslov.setText(ka.getNaslovIntervencije());
        obojiZube(idIntervencije);}
        catch(Exception ex){}
        
    }

    @FXML
    private void treciKutnjakGoreLevoClick(MouseEvent event) {
   //   File putanja= new File("..\\Slike\\gore_levo_8_plavi.png");
  //    String p= getClass().getResource("Slike/gore_levo_8_plavi.png").toString();
//        Image zub= new Image("Slike/gore_levo_8_plavi.png");
//        treciKutnjakGoreLevo.setImage(zub);
    }
    
    public void obojiZube(int idIntervencije) throws SQLException{
        KartonDAL k = new KartonDAL();
        ArrayList<Integer>lista = k.dajZubePoIntervenciji(idIntervencije);
        for(int i=0; i<lista.size(); i++){
            ImageView temp = zubi.get(lista.get(i));
            int zub = lista.get(i);
            Image plavi = new Image("Slike/"+zub+".png");
            temp.setImage(plavi);
            // odraditi zamenu kad sve slike zuba budu ubacene
        }
        
    }
    
    public void resetujZube(){
        
        // treciKutnjakGoreLevo;
    Image i1=new Image("Slike/gore_levo_8.png");
    treciKutnjakGoreLevo.setImage(i1);
    
    i1=new Image("Slike/gore_levo_7.png");
    drugiKutnjakGoreLevo.setImage(i1);
    
    i1=new Image("Slike/gore_levo_6.png");
    prviKutnjakGoreLevo.setImage(i1);
            
    i1=new Image("Slike/gore_levo_5.png");
    drugiPretkutnjakGoreLevo.setImage(i1);        
    
    i1=new Image("Slike/gore_levo_4.png");
    prviPretkutnjakGoreLevo.setImage(i1);    
    
    i1=new Image("Slike/gore_levo_3.png");
    ocnjakGoreLevo.setImage(i1);
    
    i1=new Image("Slike/gore_levo_2.png");
    lateralniSekuticGoreLevo.setImage(i1);
    
    i1=new Image("Slike/gore_levo_1.png");
    centralniSekuticGoreLevo.setImage(i1);
    
    i1=new Image("Slike/gore_desno_01.png");
    centralniSekuticGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_02.png");
    lateralniSekuticGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_03.png");
    ocnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_04.png");
    prviPretkutnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_05.png");
    drugiPretkutnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_06.png");
    prviKutnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_07.png");
    drugiKutnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/gore_desno_08.png");
    treciKutnjakGoreDesno.setImage(i1);
    
    i1=new Image("Slike/dole_levo_8.png");
    treciKutnjakDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_7.png");
    drugiKutnjakDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_6.png");
    prviKutnjakDoleLevo.setImage(i1);

    i1=new Image("Slike/dole_levo_5.png");
    drugiPretkutnjakDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_4.png");
    prviPretkutnjakDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_3.png");
    ocnjakDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_2.png");
    lateralniSekuticDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_levo_1.png");
    centralniSekuticDoleLevo.setImage(i1);
    
    i1=new Image("Slike/dole_desno_1.png");
    centralniSekuticDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_2.png");
    lateralniSekuticDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_3.png");
    ocnjakDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_4.png");
    prviPretkutnjakDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_5.png");
    drugiPretkutnjakDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_6.png");
    prviKutnjakDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_7.png");
    drugiKutnjakDoleDesno.setImage(i1);
    
    i1=new Image("Slike/dole_desno_8.png");
    treciKutnjakDoleDesno.setImage(i1);
    }

}
