
package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	Partita p;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox boxNew;
    
    @FXML
    private Button btnNew;

    @FXML
    private ChoiceBox<String> choiceDiff;

    @FXML
    private HBox boxTent;

    @FXML
    private TextField txtProva;
    
    @FXML
    private ProgressBar barTent;

    @FXML
    private TextArea txtLog;

    @FXML
    void HandleNew(ActionEvent event) {
    	txtLog.clear();
    	if(choiceDiff.getValue()==null) {
    		txtLog.appendText("Devi Inserire una difficoltà!\n");
    		return;
    	}
    	this.newGame();
    	p = new Partita(choiceDiff.getValue());
    	txtLog.appendText(p.newPart(choiceDiff.getValue()));
    	
    }

    @FXML
    void HandleProva(ActionEvent event) {
    	int tent=0;
    	
    	try {
    			tent = Integer.parseInt(txtProva.getText());
    	}
    	catch(NumberFormatException ex) {
    		txtLog.appendText("OOOOH NUMEROOOH\n");
    		return;
    	}
    	if(tent<1||tent>p.getNmax()) {
    		txtLog.appendText("Inserire un numero consentito.\n");
    		return;
    	}
    	String result= p.confronta(tent);
    	if(result.compareTo("Indovinato!")==0)
    		this.reset();
    	else if(result.compareTo("Hai perso, troppi tentativi.\n")==0)
    		this.reset();
    	
    	barTent.setProgress((double)p.getTcorr()/p.getTmax());
    	txtLog.appendText(result+"\n");

    }

    @FXML
    void HandleStop(ActionEvent event) {
    	this.reset();
    }

    @FXML
    void initialize() {
        assert boxNew != null : "fx:id=\"boxNew\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert choiceDiff != null : "fx:id=\"choiceDiff\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxTent != null : "fx:id=\"boxTent\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtProva != null : "fx:id=\"txtProva\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert barTent != null : "fx:id=\"barTent\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        choiceDiff.getItems().addAll("Facile","Media","Difficile");

    }
    
    public void newGame() {
    	boxTent.setDisable(false);
    	btnNew.setDisable(true);
    	choiceDiff.setDisable(true);
    }
    public void reset() {
    	boxTent.setDisable(true);
    	btnNew.setDisable(false);
    	choiceDiff.setDisable(false);
    	txtLog.clear();
    }
}

