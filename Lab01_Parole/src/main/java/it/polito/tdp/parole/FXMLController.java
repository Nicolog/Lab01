package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;
//import it.polito.tdp.parole.model.Parole2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTime;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	try {
    	elenco.addParola(txtParola.getText());
    	} catch (IllegalArgumentException e) {
    		txtResult.setText("Digita una parola");
    		return;
    	}
    	txtResult.setText(elenco.toString());
    	txtParola.clear();
    	
    	long elapsedNanos = System.nanoTime() - startTime;
    	
    	txtTime.setText(txtTime.getText()+" "+elapsedNanos);
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	txtTime.clear();
    	
    	long elapsedNanos = System.nanoTime() - startTime;
    	
    	txtTime.setText(txtTime.getText()+" "+elapsedNanos);
    }

    @FXML
    void doCancella(ActionEvent event) {
    	long startTime = System.nanoTime();
    	try {
    	elenco.cancella(txtParola.getText());
    	} catch (IllegalArgumentException e) {
    		txtResult.setText("Parola non trovata");
    		return;
    	}
    	txtResult.setText(elenco.toString());
    	txtParola.clear();
    	
    	long elapsedNanos = System.nanoTime() - startTime;
    	
    	txtTime.setText(txtTime.getText()+" "+elapsedNanos);
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
