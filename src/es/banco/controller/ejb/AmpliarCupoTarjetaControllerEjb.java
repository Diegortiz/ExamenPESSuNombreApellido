package es.banco.controller.ejb;

import java.util.ArrayList;

import es.banco.controller1.AmpliarCupoTarjetaController;
import es.banco.entity.TarjetaCredito;
import es.banco.persistence.dao.jdbc.TarjetaCreditoDaoJdbc;


public class AmpliarCupoTarjetaControllerEjb implements AmpliarCupoTarjetaController{

	
	@Override
	public ArrayList<TarjetaCredito> ampliarCupoTarjeta() {
		TarjetaCreditoDaoJdbc daoTarjetaCredito = new TarjetaCreditoDaoJdbc();
		ArrayList<TarjetaCredito> tarjeta = daoTarjetaCredito.findAll();
		
		
		
		
		
		return tarjeta;
	}

	@Override
	public void ampliarCupoTarjeta(TarjetaCredito tarjeta) {
		
		
	}
	
}


	

	


