package it.polito.tdp.bar.model;

public class Tavolo {
	private int numeroTipologia;
	private int numeroPosti;
	public Tavolo(int numeroTipologia, int numeroPosti) {
		super();
		this.numeroTipologia = numeroTipologia;
		this.numeroPosti = numeroPosti;
	}
	public int getNumeroTipologia() {
		return numeroTipologia;
	}
	public int getNumeroPosti() {
		return numeroPosti;
	}
	
	public void prendiTavolo() {
		this.numeroTipologia--;
	}
	
	public void lasciaTavolo() {
		this.numeroTipologia++;
	}

}
