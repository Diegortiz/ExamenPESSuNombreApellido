package es.banco.controller1;

import java.util.ArrayList;

import es.banco.entity.TarjetaCredito;

public interface AmpliarCupoTarjetaController {

	public void ampliarCupoTarjeta(TarjetaCredito tarjeta);

	ArrayList<TarjetaCredito> ampliarCupoTarjeta();
}
