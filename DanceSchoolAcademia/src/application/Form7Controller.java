package application;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Form7Controller {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form7Controller() {
		 baglanti=SqlConnection.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnekle;

    @FXML
    private Button btngüncelle;

    @FXML
    private Button btnsil;

    @FXML
    private TableColumn<Kayitlarlogin2, String> col_expert;

    @FXML
    private TableColumn<Kayitlarlogin2, String> col_name;

    @FXML
    private TableColumn<Kayitlarlogin2, String> col_password;

    @FXML
    private TableColumn<Kayitlarlogin2, Integer> col_ıd;
    
    @FXML
    private TableView<Kayitlarlogin2> tableview_kayit;

    @FXML
    private Label lblhata;

    @FXML
    private TextField txtexpert;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtpassword;

    @FXML
    private TextField txtıd;
    
    
    public void degerlerigetir(TableView tablo) {
    	sql="select * from teachers";
    	ObservableList<Kayitlarlogin2> kayitlarliste=FXCollections.observableArrayList();
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		ResultSet getirilen=sorguIfadesi.executeQuery();
    		while (getirilen.next()) {
				kayitlarliste.add(new Kayitlarlogin2(getirilen.getInt("ID"),getirilen.getString("teacherName"),getirilen.getString("password"),getirilen.getString("teacherExpert")));
				
			}
    		
    		col_ıd.setCellValueFactory(new PropertyValueFactory<>("ıd"));
    		col_name.setCellValueFactory(new PropertyValueFactory<>("teachername"));
    		col_password.setCellValueFactory(new PropertyValueFactory<>("password"));
    		col_expert.setCellValueFactory(new PropertyValueFactory<>("expert"));
    		
    		
    		tableview_kayit.setItems(kayitlarliste);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage().toString());
		}
    	}

    @FXML
    void btnekle_click(ActionEvent event) {
    	
    	degerlerigetir(tableview_kayit);
    	sql="insert into teachers(teacherName,password,teacherExpert)values(?,?,?)";
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtname.getText().trim());
    		sorguIfadesi.setString(2, SqlConnection.Md5sifreleme(txtpassword.getText().trim()));
    		sorguIfadesi.setString(3, txtexpert.getText().trim());
    		
    		sorguIfadesi.executeUpdate();
    		lblhata.setText("Ekleme Başarılı...");
    		
			
		} catch (Exception e) {
			lblhata.setText(e.getMessage().toString());
		}

    }

    

    @FXML
    void btngüncelle_click(ActionEvent event) {
    	degerlerigetir(tableview_kayit);

    }

    @FXML
    void btnsil_click(ActionEvent event) {
    	
        sql="delete from  teachers where teacherName=? and password=? and teacherExpert=? ";
    	
    	try {
    		
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtname.getText().trim());
    		sorguIfadesi.setString(2, txtpassword.getText().trim());
    		sorguIfadesi.setString(3, txtexpert.getText().trim());
    		sorguIfadesi.executeUpdate();
    		lblhata.setText("Silme Başarılı...");
    		
			
		} catch (Exception e) {
			lblhata.setText(e.getMessage().toString());
		}

    }

    @FXML
    void txtexpert_click(ActionEvent event) {

    }

    @FXML
    void txtname_click(ActionEvent event) {

    }

    @FXML
    void txtpassword_click(ActionEvent event) {

    }

    @FXML
    void txtıd_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	degerlerigetir(tableview_kayit);
       
    }

}

