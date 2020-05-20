package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Evento.TipoEvento;

public class Simulatore {
	
	private int numeroClientiTotali;
	private int numeroClientiInsoddisfatti;
	private int tavoliInsoddisfatti;
	private int tavoliTotali;
	
	LinkedList<Tavolo> tavoli=new LinkedList<Tavolo>();
	PriorityQueue<Evento> queue= new PriorityQueue<Evento>();

	Random rand=new Random();
	
	public void init() {
		this.numeroClientiInsoddisfatti=0;
		this.numeroClientiTotali=0;
		this.tavoliInsoddisfatti=0;
		this.tavoliTotali=0;
		tavoli.add(new Tavolo(5,4));
		tavoli.add(new Tavolo(4,6));
		tavoli.add(new Tavolo(4,8));
		tavoli.add(new Tavolo(2,10));
		queue.clear();
		LocalDateTime ora=LocalDateTime.of(2000, 1, 1, 0, 0);
		for(int k=0; k<2000;k++) {
			int durata=rand.nextInt((10-1)+1)+1;
			ora=ora.plusMinutes(durata);
			Evento e=new Evento(ora,TipoEvento.ARRIVO_GRUPPO_CLIENTI);
			queue.add(e);
		}
	}

	public void run() {
		
		while(!queue.isEmpty()) {
			Evento ev=queue.poll();
			switch(ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				int nPersone=rand.nextInt((10-1)+1)+1;
				numeroClientiTotali= numeroClientiTotali+nPersone;
				this.tavoliTotali++;
				Tavolo t=this.cercaTavolo(nPersone);
				if(t==null) {
					int tolleranza=rand.nextInt(10);
					
					if(tolleranza==0) {
						numeroClientiInsoddisfatti=numeroClientiInsoddisfatti+nPersone;
						this.tavoliInsoddisfatti++;
					}
				} else {
				int minuti=rand.nextInt((120-60)+1)+60;
				Duration durata=Duration.ofMinutes(minuti);
				queue.add(new Evento(ev.getTempo().plus(durata), TipoEvento.PARTENZA_GRUPPO_CLIENTI,t));
				}
				break;
				
			case PARTENZA_GRUPPO_CLIENTI:
				ev.getTavolo().lasciaTavolo();
				break;
			}
		}
		
	}
	
	private Tavolo cercaTavolo(int clienti) {
		for(int i=0;i<tavoli.size();i++) {
			Tavolo tav=tavoli.get(i);
			if(tav.getNumeroPosti()>=clienti && tav.getNumeroTipologia()>0 && tav.getNumeroPosti()/2<=clienti) {
				tav.prendiTavolo();
				return tav;
			}
		}
		return null;
	}

	public int getNumeroClientiTotali() {
		return numeroClientiTotali;
	}

	public int getNumeroClientiInsoddisfatti() {
		return numeroClientiInsoddisfatti;
	}

	public int getTavoliInsoddisfatti() {
		return tavoliInsoddisfatti;
	}

	public int getTavoliTotali() {
		return tavoliTotali;
	}
	
	
	
	

}
