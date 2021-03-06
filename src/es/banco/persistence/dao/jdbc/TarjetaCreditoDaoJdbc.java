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
			
			try {
				PreparedStatement ps = 
						cx.prepareStatement("INSERT INTO tarjetacredito VALUES(?,?,?,?,?,?,?,?)");
				
				ps.setInt(1, 0);
				ps.setString(2, tarjeta.getNumero());
				ps.setLong(3, tarjeta.getCupoMaximo());
				ps.setLong(4, tarjeta.getCupoDisponible());
				ps.setString(5, tarjeta.getTipo());
				ps.setInt(6, tarjeta.getNumeroComprobacion());
				ps.setInt(7,tarjeta.getContraseña());
				ps.setBoolean(8,tarjeta.isBloqueada());
				
				
				ps.executeUpdate();
				
				
				
				cx.commit();
			} catch (SQLException e) {
				try {
					cx.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		finally{
			cerrarConexion();
		}
		
	}
		
	@Override
	public ArrayList<TarjetaCredito> findAll() {
		ArrayList<TarjetaCredito> tarjeta = new ArrayList<TarjetaCredito>();
			try {
				
					abrirConexion();
				
					PreparedStatement ps = cx.prepareStatement("SELECT * FROM TARJETACREDITO");
				
					ResultSet consulta = ps.executeQuery();
					
					
					while (consulta.next()){
						TarjetaCredito  tarjetaCredito = new TarjetaCredito();
						
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
			
			
			finally{
				cerrarConexion();
			}
	return tarjeta;
	
	}
	
	
	private void abrirConexion(){
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			cx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Banco",
					"rootTienda",
					"rootTienda");
			
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
	
	
	@Override
	public ArrayList<TarjetaCredito> searchByName(String name) {
		ArrayList<TarjetaCredito> tarjeta= new ArrayList<TarjetaCredito>();
		
		try {
			
			
			abrirConexion();
			
			
			PreparedStatement ps = cx
					.prepareStatement("SELECT * FROM TARJETACREDITO WHERE NUMERO LIKE ?");
			
			
			ps.setString(1, "%"+ name + "%");
			
			
			ResultSet resultado = ps.executeQuery();
			
			
			while(resultado.next()){
				TarjetaCredito c = new TarjetaCredito();
				c.setId(resultado.getInt("id"));
				c.setNumero(resultado.getString("numero"));
				c.setCupoMaximo(resultado.getInt("cupoMaximo"));
				c.setCupoDisponible(resultado.getInt("cupoDisponible"));
				c.setTipo(resultado.getString("tipo"));
				c.setNumeroComprobacion(resultado.getInt("numeroComprobacion"));
				c.setContraseña(resultado.getInt("contraseña"));
				c.setBloqueada(resultado.getBoolean("bloqueada"));
				
				
				TarjetaCredito.add(c);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			cerrarConexion();
			
		}
		
		
		
		return tarjeta;
	}
	
	@Override
	public void update(TarjetaCredito tarjeta) {
		try {
			
			
			abrirConexion();
			
			
			PreparedStatement ps = cx.prepareStatement(
					"UPDATE TARJETACREDITO SET NUMERO = ?, CUPOMAXIMO = ?, CUPODISPONIBLE = ?, TIPO = ?, NUMEROCOMPROBACION = ?, CONTRASEÑA = ?, BLOQUEADA = ?  WHERE ID = ?");
			
			
			ps.setString(1, tarjeta.getNumero());
			ps.setInt(2, tarjeta.getCupoMaximo());
			ps.setInt(3, tarjeta.getCupoDisponible());
			ps.setString(4, tarjeta.getTipo());
			ps.setInt(5, tarjeta.getNumeroComprobacion());
			ps.setInt(6,tarjeta.getContraseña());
			ps.setBoolean(7, tarjeta.isBloqueada());
			
			
			ps.executeUpdate();
			
			
			cx.commit();
			
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			
			cerrarConexion();
		}
		
	}
	
	@Override
	public void delete(Integer id) {
		try {
			
			abrirConexion();
			
			PreparedStatement ps = cx.prepareStatement("DELETE FROM TARJETACREDITO WHERE ID = ?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			cx.commit();
			
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			
			
			cerrarConexion();
			
		}
		
	}

	@Override
	public void read(TarjetaCredito tarjeta) {
		
		
	}

	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
