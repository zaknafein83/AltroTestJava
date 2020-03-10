package it.dstech.generics;

import java.util.ArrayList;
import java.util.List;

public class MainGenerics {

	public static void main(String[] args) {
		Bottiglia<Acqua> acqua = new Bottiglia<>(new Acqua());
		acqua.stampa();
		
		Bottiglia<Vino> vino = new Bottiglia<>(new Vino());
		vino.stampa();
		
		List<String>  listaTesti = new ArrayList<> ();
		
		listaTesti.add("Stringa");
		
		for (int i = 0; i < listaTesti.size(); i++) {
			String testo  =  listaTesti.get(i);
			System.out.println(testo);
			
		}
		
		
		
		
		
	}
}
