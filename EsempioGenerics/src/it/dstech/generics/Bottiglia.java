package it.dstech.generics;

public class Bottiglia<T> {
	
	private T contenuto;
	
	public Bottiglia (T contentuto) {
		this.contenuto = contentuto;
	}
	public void stampa() {
		System.out.println(contenuto);
	}
}
