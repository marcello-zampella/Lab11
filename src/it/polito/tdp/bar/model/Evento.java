package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.Random;
import java.time.Duration;

public class Evento implements Comparable<Evento> {//ATTENZIONE: Comparable compara l'oggetto sè stesso ad un altro, Comparator compara 2 oggetti tra loro
	
	private LocalTime tempo;
	private TipoEvento tipo;
	private Tavolo tavolo;
	
	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI,
		PARTENZA_GRUPPO_CLIENTI
	}
	
	
	
	public Evento(LocalTime lt, TipoEvento tipo) {
		tempo=lt;
		this.tipo=tipo;
	}
	


	public Evento(LocalTime plus, TipoEvento partenzaGruppoClienti, Tavolo t) {
		tempo=plus;
		this.tipo=partenzaGruppoClienti;
		this.tavolo=t;
	}



	public Tavolo getTavolo() {
		return tavolo;
	}



	public LocalTime getTempo() {
		return tempo;
	}


	public TipoEvento getTipo() {
		return tipo;
	}


	@Override
	public int compareTo(Evento other) {
		// TODO Auto-generated method stub
		return tempo.compareTo(other.tempo);
	}



	@Override
	public String toString() {
		return "Evento [tempo=" + tempo + ", tipo=" + tipo + "]";
	}
	
	

}
