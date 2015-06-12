package es.banco.controller.ejb;

import es.banco.controller1.DarAltaTarjetaController;
import es.banco.entity.TarjetaCredito;
import es.banco.persistence.dao.TarjetaCreditoDao;
import es.banco.persistence.dao.jdbc.TarjetaCreditoDaoJdbc;

public class DarAltaTarjetaEjb implements DarAltaTarjetaController {

	private TarjetaCreditoDao tarjetaCreditoDao;
	
	@Override
	public void agregar(TarjetaCredito tarjeta) {
		
		tarjetaCreditoDao = new TarjetaCreditoDaoJdbc();
		tarjetaCreditoDao.create(tarjeta);
		
	}

}
