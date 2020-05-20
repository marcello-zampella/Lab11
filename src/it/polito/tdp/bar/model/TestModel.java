package it.polito.tdp.bar.model;

import java.time.*;


import it.polito.tdp.bar.model.Evento.TipoEvento;

public class TestModel {

	public static void main(String[] args) {
		
		Model model= new Model();
		int clientiTotali=0;
		int clientiInsoddisfatti=0;
		for(int i=0;i<2000;i++) {
			model.simula();
			clientiTotali+=model.getNumeroClientiTotali();
			clientiInsoddisfatti+=model.getNumeroClientiInsoddisfatti();
		}
		float percentuale= (float)clientiInsoddisfatti/clientiTotali;
		System.out.println("percentuale clienti insoddisfatti: "+percentuale);
		}
}