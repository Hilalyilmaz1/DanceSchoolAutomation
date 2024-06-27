package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysqlUtil.SqlConnection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class Form1Controller {
	Connection baglanti=null;
	PreparedStatement sorguIfadesi=null;
	ResultSet getirilen=null;
	String sql;
	
	public Form1Controller() {
		 baglanti=SqlConnection.Baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnadmin;

    @FXML
    private Button btnuser;

    @FXML
    void btnadmin_click(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form3.fxml"));
		Scene scene = new Scene(root,400,400);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();


    }

    @FXML
    void btnuser_click(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form2.fxml"));
		Scene scene = new Scene(root,400,400);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    	
    }

    @FXML
    void initialize() {
       
    }

}

	 
	 
	 
	

