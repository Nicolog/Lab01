package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> parole;
		
	public Parole() {
		parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		if(!p.contains(" ")) {
			parole.add(p);
			Collections.sort(parole, new ComparatoreAlfabetico());
		}
		else 
			throw new IllegalArgumentException("Digita una sola parola");
	}
	
	public List<String> getElenco() {
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public void cancella(String s) {
		
		for(String ss : parole)
			if(s.equals(ss)) {
				parole.remove(ss);
				return;
			}
		
		throw new IllegalArgumentException("Parola non trovata");
	}

	@Override
	public String toString() {
		String s="";
		for(String ss : parole)
			s+="\n"+ss;
		
		if(s!="")
			s=s.substring(1);
		
		return s;
	}

	
}
