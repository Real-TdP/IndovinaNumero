package it.polito.tdp.indonumero;

import java.util.*;

public class Partita {
	
	protected int Nmax;
	protected int Tcorr;
	protected int Tmax;
	protected int nSec;
	protected List<Integer> numeri = new LinkedList<Integer>();
	
	public Partita(String diff) {
		Tcorr=0;
		if(diff.compareTo("Facile")==0) {
			Nmax=100;
			Tmax=10;
		}
		else if(diff.compareTo("Media")==0) {
			Nmax=1000;
			Tmax=11;
		}
		else if(diff.compareTo("Difficile")==0) {
			Nmax=1000;
			Tmax=10;
		}
		nSec=(int)(Nmax*Math.random());
		
	}
	
	public String confronta(int tentativo) {
		if(numeri.contains(tentativo))
			return "Numero già inserito,riprova.";
		numeri.add(tentativo);
		Tcorr++;
		if(Tcorr>Tmax)
			return "Hai perso, troppi tentativi.";
		if(tentativo>nSec)
			return "Troppo grande!";
		if(tentativo<nSec)
			return "Troppo piccolo!";
		return "Indovinato!";
	}

	public int getNmax() {
		return Nmax;
	}

	public int getTcorr() {
		return Tcorr;
	}

	public int getTmax() {
		return Tmax;
	}
	
	public String newPart(String diff) {
		
		return "Hai iniziato una nuova partita!\nDifficoltà: "+diff+"\n"+"Massimo numero tentativi: "+Tmax+"\nRange d'immissione: 1-"+Nmax+"\n";
	}
	

}
