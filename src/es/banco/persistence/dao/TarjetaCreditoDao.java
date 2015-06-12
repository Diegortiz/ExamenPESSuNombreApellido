package es.banco.persistence.dao;

import java.util.ArrayList;

import es.banco.entity.TarjetaCredito;


public interface TarjetaCreditoDao {

	public void create (TarjetaCredito tarjeta);
	
	public ArrayList <TarjetaCredito> findAll();
	
	public ArrayList<TarjetaCredito> searchByName(String name);
	
	public void update(TarjetaCredito cliente);
	
	public void delete(Integer id);

	public void read(Object id);

	ArrayList<TarjetaCredito> findAll1();
	
	
}
