package it.polito.tdp.indonumero;
import java.util.*;

public class PartitaAssistita extends Partita {
	private int rMin;
	private int rMax;
	private List<Integer> numG = new LinkedList<Integer>();   //TENGO CONTO DEI NUMERI MAGGIORI PER INDIVIDUARE rMax
	private List<Integer> numP = new LinkedList<Integer>();   //TENGO CONTO DEI NUMERI MINORI PER INDIVIDUARE rMIn

	public PartitaAssistita(String diff) {
		super(diff);
		rMin=1;
		rMax=Nmax;
	}
	
	@Override
	
	public String confronta(int tentativo) {
		if(numeri.contains(tentativo))
			return "Numero già inserito,riprova.";
		numeri.add(tentativo);
		Tcorr++;
		
		
		if(Tcorr>Tmax)
			return "Hai perso, troppi tentativi.\nIl numero corretto era: "+nSec;
		
		if(tentativo>nSec) {
			numG.add(tentativo);
			for(int n:numG)
				if(n<rMax)
					rMax=n;
			rMax--;   
			return "Troppo grande!  Prova in questo Range: ["+rMin+"-"+rMax+"]";
		}
		else if(tentativo<nSec) {
			numP.add(tentativo);
			for(int n:numP)
				if(n>rMin)
					rMin=n;
			rMin++;
			return "Troppo piccolo!  Prova in questo Range: ["+rMin+"-"+rMax+"]";
			
		}
		return "Indovinato!";
		
	}

	
}
