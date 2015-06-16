package es.banco.persistence.dao;

import java.util.ArrayList;

import es.banco.entity.TarjetaCredito;


public interface TarjetaCreditoDao {

	public void create(TarjetaCredito tarjeta);

	ArrayList<TarjetaCredito> findAll();

	ArrayList<TarjetaCredito> searchByName(String name);

	public void update(TarjetaCredito tarjeta);

	public void delete(Integer id);
	
	public void read(TarjetaCredito tarjeta);


}
