package es.banco.persistence.dao.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.banco.entity.TarjetaCredito;
import es.banco.persistence.dao.TarjetaCreditoDao;


public class TarjetaCreditoDaoJdbc implements TarjetaCreditoDao{

	private Connection cx;
	
	
	
	public TarjetaCreditoDaoJdbc() {
		super();
	}

	@Override
	public void create(TarjetaCredito tarjeta) {
		try {
			abrirConexion();
		try{
			PreparedStatement ps =
					cx.prepareStatement ("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, tarjeta.getNumero() );
			ps.setInt(3, tarjeta.getCupoMaximo());
			ps.setInt(4, tarjeta.getCupoDisponible());
			ps.setString(5, tarjeta.getTipo());
			ps.setInt(6, tarjeta.getNumeroComprobacion());
			ps.setInt(7, tarjeta.getContraseña());
			ps.setBoolean(8, tarjeta.isBloqueada());
			
			ps.executeUpdate();
			
			cx.commit();
			
			}catch(SQLException e){
				try{
				cx.rollback();
				
			}
			
		 catch (Exception e1) {
			
			e.printStackTrace();
			
		}
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
				
		finally {
			cerrarConexion();
		}
			
	}

	@Override
	public ArrayList <TarjetaCredito> findAll(){
		ArrayList <TarjetaCredito> tarjeta = new ArrayList<TarjetaCredito>();
	try{
		abrirConexion();
		PreparedStatement ps = cx.prepareStatement("SELECT * FROM CLIENTE");
		ResultSet consulta = ps.executeQuery();
		

		while (consulta.next()){
			TarjetaCredito tarjetaNueva = new TarjetaCredito();
			TarjetaCredito tarjetaCredito = null;
			
			tarjetaCredito.setId(consulta.getInt("id"));
			
			tarjetaCredito.setNumero(consulta.getString("numero"));
			tarjetaCredito.setCupoMaximo(consulta.getInt("cupoMaximo"));
			tarjetaCredito.setCupoDisponible(consulta.getInt("cupoDisponible"));
			tarjetaCredito.setTipo(consulta.getString("tipo"));
			tarjetaCredito.setNumeroComprobacion(consulta.getInt("numeroComprobacion"));
			tarjetaCredito.setContraseña(consulta.getInt("contraseña"));
			tarjetaCredito.setBloqueada(consulta.getBoolean("bloqueada"));
			
			
			tarjeta.add(tarjetaCredito);
			
		}				
		
} catch (SQLException e) {
	
	e.printStackTrace();
}

//4.Cerrar la conexión
finally{
	cerrarConexion();
}
return tarjeta;

}


	private void abrirConexion(){
		try {
			//1.Determinar y validar si tengo el driver o conector (de mysql)
			Class.forName("com.mysql.jdbc.Driver");
			//2.Establecer la conexión...
			cx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Banco",
					"rootTienda",
					"rootTienda");
			//3.Iniciar el autoComit en false para gestionar transacciones.
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void cerrarConexion(){
		try {
			if(cx != null)
			cx.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}




private void cerrarConexion1() {
	// TODO Auto-generated method stub
	
}

private void abrirConexion1() {
	// TODO Auto-generated method stub
	
}

@Override
public ArrayList<TarjetaCredito> findAll1() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<TarjetaCredito> searchByName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void update(TarjetaCredito cliente) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(Integer id) {
	// TODO Auto-generated method stub
	
}

@Override
public void read(Object id) {
	// TODO Auto-generated method stub
	
}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
