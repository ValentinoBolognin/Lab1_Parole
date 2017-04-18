package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	double startTime ;
	double finalTime ;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtSecond"
    private TextField txtSecond; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {

    	startTime = System.nanoTime();
    	
    	elenco.addParola( txtParola.getText() );
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	txtParola.clear();
    	
    	finalTime = System.nanoTime();
    	
    	txtSecond.setText("Inserimento concluso in " + (finalTime - startTime) / 1e9 + " secondi");
    	
//    	int i;
//		double temp1 = System.nanoTime();
//		for (i = 0; i < 100000; i++) {
//			String parola = "Parola_" + i;
//			elenco.addParola(parola);
//		}
//		double temp2 = System.nanoTime();
//		txtResult.setText("Inserimento concluso in " + (temp2 - temp1) / 1e9 + " secondi");
//
//		temp1 = System.nanoTime();
//		elenco.removeParola("Parola_0");
//		temp2 = System.nanoTime();
//		txtResult.appendText("\n1o elemento cancellato in " + (temp2 - temp1) / 1e9 + " secondi");
//
//		temp1 = System.nanoTime();
//		elenco.removeParola("Parola_50000");
//		temp2 = System.nanoTime();
//		txtResult.appendText("\n50000 elemento cancellato in " + (temp2 - temp1) / 1e9 + " secondi");
//
//		temp1 = System.nanoTime();
//		elenco.removeParola("Parola_99900");
//		temp2 = System.nanoTime();
//		txtResult.appendText("\nultimo elemento cancellato in " + (temp2 - temp1) / 1e9 + " secondi");
    	
    }
    
    @FXML
    void doDelete(ActionEvent event) {
    	
    	startTime = System.nanoTime();
    	
    	String parola = txtResult.getSelectedText();
    	elenco.removeParola(parola);
    	
    	String result = "" ;
    	
    	for(String p: elenco.getElenco())
    		result += p + "\n" ;
    	
    	txtResult.setText(result);
    	
    	finalTime = System.nanoTime();
    	
    	txtSecond.setText("Cancellazione conclusa in " + (finalTime - startTime) / 1e9 + " secondi");
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	startTime = System.nanoTime();
    	
    	elenco.reset() ;
    	txtResult.clear() ;
    	
    	finalTime = System.nanoTime();

    	txtSecond.setText("Reset concluso in " + (finalTime - startTime) / 1e9 + " secondi");
        
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtSecond != null : "fx:id=\"txtSecond\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
        
        elenco = new Parole() ;
        
    }
}
