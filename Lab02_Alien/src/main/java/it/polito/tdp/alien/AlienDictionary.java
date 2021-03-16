package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	public List<Word> dizionario = new LinkedList<Word>();
	
	public void addWord(String alienWord, String translation) {
		
		boolean presente = false;
		Word word = new Word(alienWord.toLowerCase(), translation.toLowerCase());
		
		if(!dizionario.isEmpty()) {
			for(Word parole : dizionario) {
				if(word.equals(parole)) {
					dizionario.remove(parole);
				}
			}
		}
		
		dizionario.add(word);

	}
	
	public String translateWord(String alienWord) {
		
		String translation = null;
		
		for(Word word : dizionario) {
			if(word.getAlienWord().equals(alienWord)) {
				translation = word.getTranslation();
			}
		}
		
		return translation;
	}

}
