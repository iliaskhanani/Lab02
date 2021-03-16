package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	public List<WordEnhanced> dizionario = new LinkedList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation) {
		
		boolean presente = false;
		
		for(WordEnhanced word : dizionario) {
			if(word.getAlienWord().equals(alienWord)) {
				presente = true;
				word.getTranslations().add(translation);
			}
		}
		
		if(!presente) {
			LinkedList<String> nuovo = new LinkedList<String>();
			nuovo.add(translation);
			WordEnhanced word = new WordEnhanced(alienWord, nuovo);
			dizionario.add(word);
		} else {
			
		}

	}
	
	public LinkedList<String> translateWord(String alienWord) {
		
		LinkedList<String> translation = new LinkedList<String>();
		
		for(WordEnhanced word : dizionario) {
			if(word.getAlienWord().equals(alienWord)) {
				translation = word.getTranslations();
			}
		}
		
		return translation;
	}

	public List<WordEnhanced> getDizionario() {
		return dizionario;
	}

	public void setDizionario(List<WordEnhanced> dizionario) {
		this.dizionario = dizionario;
	}
	
	

}
