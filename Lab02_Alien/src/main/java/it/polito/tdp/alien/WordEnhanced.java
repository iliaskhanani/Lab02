package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	private String alienWord;
	private LinkedList<String> translations;
	
	
	public WordEnhanced(String alienWord, LinkedList<String> translations) {
		this.alienWord = alienWord;
		this.translations = translations;
	}
	public String getAlienWord() {
		return alienWord;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public LinkedList<String> getTranslations() {
		return translations;
	}
	public void setTranslations(LinkedList<String> translations) {
		this.translations = translations;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	@Override
	public String toString() {
		
		String risultato = "";
		
		for(String traduzione : translations) {
			risultato += traduzione+"\n";
		}
		
		return risultato;
	}
	
	
	

}
