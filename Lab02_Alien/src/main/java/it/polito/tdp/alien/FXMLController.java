package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dictionary = new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUtente;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doReset(ActionEvent event) {
    	dictionary.dizionario.clear();
    	txtUtente.setText("");
    	txtRisultato.setText("");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtRisultato.setText("");
    	String word = txtUtente.getText();
    	
    	if(word.contains(" ")) {
	    	String [] parti = word.split(" ");
	    	String alienWord = parti[0];
	    	String translation = parti[1];
	    	
	    	boolean ok = true;
			char [] word1 = alienWord.toLowerCase().toCharArray();
			char [] word2 = translation.toLowerCase().toCharArray();
			
			for(char c : word1) {
				if(!Character.isLetter(c)) {
					ok = false;
				}
			}
			
			for(char c : word2) {
				if(!Character.isLetter(c)) {
					ok = false;
				}
			}
			
			if(ok) {
				dictionary.addWord(alienWord.toLowerCase(), translation.toLowerCase());
			} else {
				txtRisultato.setText("Errore: le parole devono contenere solo caratteri");
			}
			txtUtente.setText("");
    	} else {
    		boolean trovato = false;
    		String alienWord = txtUtente.getText().toLowerCase();
    		
    		for(WordEnhanced wordEnhanced : dictionary.dizionario) {
    			if(wordEnhanced.getAlienWord().equals(alienWord)) {
    				txtRisultato.setText(wordEnhanced.toString());
    				trovato = true;
    			}
    		}
    		
    		if(!trovato) {
    			txtRisultato.setText("parola non presente in dizionario");
    		}
    		
    	}
    }

    @FXML
    void initialize() {
        assert txtUtente != null : "fx:id=\"txtUtente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
