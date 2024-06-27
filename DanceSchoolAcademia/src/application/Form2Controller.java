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


public class Form2Controller {
	
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form2Controller() {
		 baglanti=SqlConnection.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btngiriş;

    @FXML
    private Label lblname;

    @FXML
    private Label lblpassword;
    
    @FXML
    private Label lbl;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField password;

    @FXML
    void btngiriş_click(ActionEvent event) throws IOException {
    	
    	sql="select * from users where userName=? and password=? ";
    	try {
    		sorguIfadesi=baglanti.prepareStatement(sql);
    		sorguIfadesi.setString(1, txtname.getText().trim());
    		sorguIfadesi.setString(2, SqlConnection.Md5sifreleme(password.getText().trim()));
    		
    		ResultSet getirilen =sorguIfadesi.executeQuery();
    		
    		if(!getirilen.next()) {
    			lbl.setText("Kullanıcı adı veya sifre hatalı");
    		}
    		else {
    			getirilen.getString(1);
    			System.out.println("ID"+getirilen.getString("ID"));
    			System.out.println("Kullanıcı:"+getirilen.getString("userName"));
    			System.out.println("Şifre"+getirilen.getString("password"));
    			
    		}
    	}
    	catch(Exception e) {
    		lbl.setText(e.getMessage().toString());
    		
    	}
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form6.fxml"));
		Scene scene = new Scene(root,400,400);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

    @FXML
    void txtname_click(ActionEvent event) {

    }

    @FXML
    void password_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    }

}

