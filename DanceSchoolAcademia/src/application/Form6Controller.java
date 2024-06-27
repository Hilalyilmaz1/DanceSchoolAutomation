package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.mysqlUtil.SqlConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Form6Controller {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form6Controller() {
		 baglanti=SqlConnection.Baglan();
	}



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngüncel;

    @FXML
    private Button btnkaydet;

    @FXML
    private TableColumn<Kayitlarlogin3,String> coldance;

    @FXML
    private TableColumn<Kayitlarlogin3,LocalDate> coldate;

    @FXML
    private TableColumn<Kayitlarlogin3,Integer> colid;

    @FXML
    private TableColumn<Kayitlarlogin3,String> colteacher;

    @FXML
    private TableColumn<Kayitlarlogin3,String> coluser;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Label lblkontrol;

    @FXML
    private TableView<Kayitlarlogin3> tableview_kayit1;

    @FXML
    private TextField txtdancetype;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtteacname;

    @FXML
    private TextField txtıd;
    
    
    public void degerlerigetir(TableView tablo) {
    	sql="select * from users";
    	ObservableList<Kayitlarlogin3> kayitlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()) {
				kayitlarliste.add(new Kayitlarlogin3(getirilen.getInt("ID"),getirilen.getString("userName"),getirilen.getString("danceType"),getirilen.getString("courseTeacher")));
				
			}
    		
    		colid.setCellValueFactory(new PropertyValueFactory<>("ID"));
    		coluser.setCellValueFactory(new PropertyValueFactory<>("username"));
    		coldance.setCellValueFactory(new PropertyValueFactory<>("dancetype"));
    		colteacher.setCellValueFactory(new PropertyValueFactory<>("teachername"));
    		//coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
    		
    		
    		tableview_kayit1.setItems(kayitlarliste);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	}

    @FXML
    void btngüncel_click(ActionEvent event) {
    	degerlerigetir(tableview_kayit1);

    }

    @FXML
    void btnkaydet_click(ActionEvent event) {

    	degerlerigetir(tableview_kayit1);
    	sql="insert into users(userName,danceType,courseTeacher) values(?,?,?)";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtname.getText().trim());
    		sorguIfadesi.setString(2, txtdancetype.getText().trim());
    		sorguIfadesi.setString(3,txtteacname.getText().trim());
    		//sorguIfadesi.setDate(4, null);
    		
    		sorguIfadesi.executeUpdate();
    		lblkontrol.setText("Ekleme Başarılı...");
    		
			
		} catch (Exception e) {
			lblkontrol.setText(e.getMessage().toString());
		}

    }

    

    @FXML
    void datepicker_click(ActionEvent event) {

    }

    @FXML
    void tableview_kayit1_click(ActionEvent event) {

    }

    @FXML
    void txtdancetype_click(ActionEvent event) {

    }

    @FXML
    void txtname_click(ActionEvent event) {

    }

    @FXML
    void txtteacname_click(ActionEvent event) {

    }

    @FXML
    void txtıd_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	degerlerigetir(tableview_kayit1);
    
       

}
}
   
