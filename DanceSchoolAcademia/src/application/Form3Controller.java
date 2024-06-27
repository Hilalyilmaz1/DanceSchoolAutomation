package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import com.mysqlUtil.SqlConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Form3Controller {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form3Controller() {
		 baglanti=SqlConnection.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngiriş1;

    @FXML
    private Label lblname1;

    @FXML
    private Label lblpassword1;

    @FXML
    private PasswordField password1;

    @FXML
    private TextField txtname1;
    
    @FXML
    private Label lblhata;

    @FXML
    void btngiriş1_click(ActionEvent event) throws IOException {
    	
    	
    	
    	sql="select * from admins where adminName=? and sifre=? ";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtname1.getText().trim());
    		sorguIfadesi.setString(2, SqlConnection.Md5sifreleme(password1.getText().trim()));
    		
    		ResultSet getirilen =sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next()) {
    			lblhata.setText("Kullanıcı adı veya sifre hatalı");
    		}
    		else {
    			getirilen.getString(1);
    			System.out.println("ID"+getirilen.getString("ID"));
    			System.out.println("Kullanıcı:"+getirilen.getString("adminName"));
    			System.out.println("Şifre"+getirilen.getString("sifre"));
    			
    		}
    	}
    	catch(Exception e) {
    		lblhata.setText(e.getMessage().toString());
    		
    	}
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form5.fxml"));
		Scene scene = new Scene(root,400,400);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();



    }




    @FXML
    void password1_click(ActionEvent event) {

    }

    @FXML
    void txtname1_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
       
    }

}




