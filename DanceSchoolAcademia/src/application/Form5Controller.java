package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Form5Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnogrenci;

    @FXML
    private Button btnogretmen;

    @FXML
    private Label lblmetin;

    @FXML
    void btnogrenci_click(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form4.fxml"));
		Scene scene = new Scene(root,500,500);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();


    }

    @FXML
    void btnogretmen_click(ActionEvent event) throws IOException {
    	AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Form7.fxml"));
		Scene scene = new Scene(root,500,500);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();


    }

    @FXML
    void initialize() {
       
    }

}

