package it.polito.tdp.bar.model;

public class Model {
	Simulatore sim;
	
	



	public void simula() {
		sim=new Simulatore();
		sim.init();
		sim.run();
		
	}

	public int getTavoliTotali() {
		return sim.getTavoliTotali();
	}

	public int getTavoliInsoddisfatti() {
		return sim.getTavoliInsoddisfatti();
	}


	public int getNumeroClientiTotali() {
		return sim.getNumeroClientiTotali();
	}





	public int getNumeroClientiInsoddisfatti() {
		return sim.getNumeroClientiInsoddisfatti();
	}

}
