package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDateTime;

public class Evento implements Comparable<Evento> {//ATTENZIONE: Comparable compara l'oggetto sè stesso ad un altro, Comparator compara 2 oggetti tra loro
	
	private LocalDateTime tempo;
	private TipoEvento tipo;
	private Tavolo tavolo;
	
	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI,
		PARTENZA_GRUPPO_CLIENTI
	}
	
	
	
	public Evento(LocalDateTime lt, TipoEvento tipo) {
		this.tempo=lt;
		this.tipo=tipo;
	}
	


	public Evento(LocalDateTime plus, TipoEvento partenzaGruppoClienti, Tavolo t) {
		tempo=plus;
		this.tipo=partenzaGruppoClienti;
		this.tavolo=t;
	}



	public Tavolo getTavolo() {
		return tavolo;
	}



	public LocalDateTime getTempo() {
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
