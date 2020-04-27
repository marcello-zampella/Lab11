package it.polito.tdp.bar;

import it.polito.tdp.bar.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private TextArea txtResult;
	private Model model;

    @FXML
    void doSimula(ActionEvent event) {
    	model.simula();
    	this.txtResult.setText("Di un totale di "+model.getNumeroClientiTotali()+" NON sono stati serviti "+model.getNumeroClientiInsoddisfatti()+"\n");
    	this.txtResult.appendText("GRUPPI TOTALI: "+model.getTavoliTotali()+" di cui insoddisfatti "+model.getTavoliInsoddisfatti());
    	
    }

	public void setModel(Model model) {
		this.model=model;
		
	}

}
