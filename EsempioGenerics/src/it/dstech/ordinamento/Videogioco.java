package it.dstech.ordinamento;

import java.io.Serializable;

public class Videogioco implements Comparable<Videogioco>, Serializable {

	private String titolo;

	private int pubblicazione;

	private Genere genere;

	private Pegi classificazione;

	private double votazione;

	public Videogioco(String titolo, int pubblicazione, Genere genere, Pegi classificazione, double votazione) {
		super();
		this.titolo = titolo;
		this.pubblicazione = pubblicazione;
		this.genere = genere;
		this.classificazione = classificazione;
		this.votazione = votazione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(int pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Pegi getClassificazione() {
		return classificazione;
	}

	public void setClassificazione(Pegi classificazione) {
		this.classificazione = classificazione;
	}

	public double getVotazione() {
		return votazione;
	}

	public void setVotazione(double votazione) {
		this.votazione = votazione;
	}

	@Override
	public int compareTo(Videogioco o) {
		if (this.getPubblicazione() < o.getPubblicazione())
			return -1;
		if (this.getPubblicazione() > o.getPubblicazione())
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Videogioco [titolo=" + titolo + ", pubblicazione=" + pubblicazione + ", genere=" + genere
				+ ", classificazione=" + classificazione + ", votazione=" + votazione + "]";
	}
}
