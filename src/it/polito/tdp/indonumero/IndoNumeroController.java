package it.polito.tdp.indonumero;


	import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.HBox;

	public class IndoNumeroController {

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private HBox boxNew;

	    @FXML
	    private TextField txtCurr;

	    @FXML
	    private TextField txtMax;

	    @FXML
	    private HBox boxTent;

	    @FXML
	    private TextField txtProva;

	    @FXML
	    private TextArea txtLog;

	    @FXML
	    void HandleNew(ActionEvent event) {

	    }

	    @FXML
	    void HandleProva(ActionEvent event) {

	    }

	    @FXML
	    void initialize() {
	        assert boxNew != null : "fx:id=\"boxNew\" was not injected: check your FXML file 'IndoNumero.fxml'.";
	        assert txtCurr != null : "fx:id=\"txtCurr\" was not injected: check your FXML file 'IndoNumero.fxml'.";
	        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
	        assert boxTent != null : "fx:id=\"boxTent\" was not injected: check your FXML file 'IndoNumero.fxml'.";
	        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
	        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

	    }
	}

	


