package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import com.mysqlUtil.SqlConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Form4Controller {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form4Controller() {
		 baglanti=SqlConnection.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnadd;
    
    @FXML
    private Button btnişlemler;

    @FXML
    private Button btnremove;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<Kayitlarlogin, String> col_dancetype;

   /* @FXML
    private TableColumn<Kayitlarlogin, Integer> col_date;*/

    @FXML
    private TableColumn<Kayitlarlogin, String> col_password;

    @FXML
    private TableColumn<Kayitlarlogin, String> col_teacher;

    @FXML
    private TableColumn<Kayitlarlogin,String> col_username;

    @FXML
    private TableColumn<Kayitlarlogin, Integer> col_ıd;


    @FXML
    private Label lbluser;
    
    @FXML
    private TextField txtıd;
    
    @FXML
    private TextField txtdancetype;

    @FXML
    private TextField txtteacher;
    
    @FXML
    private Label lblkontrol;



    @FXML
    private TableView<Kayitlarlogin> tableview_kayitlar;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtusername;
    
    @FXML
    void txtıd_click(ActionEvent event) {

    }
    
    public void degerlerigetir(TableView tablo) {
    	sql="select * from users";
    	ObservableList<Kayitlarlogin> kayitlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()) {
				kayitlarliste.add(new Kayitlarlogin(getirilen.getInt("ID"),getirilen.getString("userName"),getirilen.getString("password"),getirilen.getString("danceType"),getirilen.getString("courseTeacher")));
				
			}
    		
    		col_ıd.setCellValueFactory(new PropertyValueFactory<>("ıd"));
    		col_username.setCellValueFactory(new PropertyValueFactory<>("userName"));
    		col_password.setCellValueFactory(new PropertyValueFactory<>("sifre"));
    		col_teacher.setCellValueFactory(new PropertyValueFactory<>("teacher"));
    		col_dancetype.setCellValueFactory(new PropertyValueFactory<>("dancetype"));
    		//col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    		
    		tableview_kayitlar.setItems(kayitlarliste);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	}


    @FXML
    void btnadd_click(ActionEvent event) {
    	degerlerigetir(tableview_kayitlar);
    	sql="insert into users( userName,password,danceType,courseTeacher)values (?,?,?,?)";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtusername.getText().trim());
    		sorguIfadesi.setString(2, SqlConnection.Md5sifreleme(txtpassword.getText().trim()));
    		sorguIfadesi.setString(3, txtdancetype.getText().trim());
    		sorguIfadesi.setString(4, txtteacher.getText().trim());
    		sorguIfadesi.executeUpdate();
    		lblkontrol.setText("Ekleme Başarılı...");
    		
			
		} catch (Exception e) {
			lblkontrol.setText(e.getMessage().toString());
		}

    }

    @FXML
    void btnremove_click(ActionEvent event) {
    	
    	sql="delete from  users where userName=? and password=? and courseTeacher=? and danceType=?";
    	
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtusername.getText().trim());
    		sorguIfadesi.setString(2, txtpassword.getText().trim());
    		sorguIfadesi.setString(3, txtteacher.getText().trim());
    		sorguIfadesi.setString(4, txtdancetype.getText().trim());
    		sorguIfadesi.executeUpdate();
    		lblkontrol.setText("Silme Başarılı...");
    		
			
		} catch (Exception e) {
			lblkontrol.setText(e.getMessage().toString());
		}
    	

    }

    @FXML
    void btnupdate_click(ActionEvent event) {
    	degerlerigetir(tableview_kayitlar);
    	
    	

    }
    
    @FXML
    void btnişlemler_click(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form5.fxml"));
		Scene scene = new Scene(root,400,400);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

    @FXML
    void tableview_kayitlarmouseclick(MouseEvent event) {

    }

    @FXML
    void txtpassword_click(ActionEvent event) {

    }

    @FXML
    void txtusername_click(ActionEvent event) {

    }
    
    @FXML
    void txtdancetype_click(ActionEvent event) {

    }

    @FXML
    void txtteacher_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	degerlerigetir(tableview_kayitlar);
        
    }

}
