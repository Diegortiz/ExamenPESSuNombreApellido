package es.banco.dispatchers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.controller.ejb.DarAltaTarjetaEjb;
import es.banco.entity.TarjetaCredito;


/**
 * Servlet implementation class BancoServlet
 */
@WebServlet("/BancoServlet/*")
public class BancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BancoServlet() {
        
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String titulo = "Sin título";
		RequestDispatcher rd;
		
		switch(action){
		
			case "darAltaTarjeta":
				rd = request.getRequestDispatcher("/jsp/DarAltaTarjeta.jsp");
				rd.forward (request, response);
			break;
		
			
			case "bloquearTarjeta":
				rd= request.getRequestDispatcher("/jsp/BloquearTarjeta.jsp");
				rd.forward(request, response);
			break;
			
			
			case "ampliarCupo":
				rd = request.getRequestDispatcher("/jsp/AmpliarCupo.jsp");
				rd.forward(request, response);
			break;
			
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		
		switch(action){
		
		case "darAltaTarjeta":
			String numero = request.getParameter("numero");
			String cupoMaximo = request.getParameter("cupoMaximo");
			String cupoDisponible = request.getParameter("cupoDisponible");
			String tipo = request.getParameter("visa");
			String tipo2 = request.getParameter("mastercard");
			String numeroComprobacion = request.getParameter("numeroComprobacion");
			String contraseña = request.getParameter("contraseña");
			String bloqueada = request.getParameter("bloqueada");
			
			
			TarjetaCredito tarjeta = new TarjetaCredito(0, numero, cupoMaximo, 
			cupoDisponible, tipo, tipo2,numeroComprobacion, contraseña, bloqueada);
			
			
			
			
			DarAltaTarjetaEjb controlador = new DarAltaTarjetaEjb();
			
			controlador.agregar(tarjeta);
			
			
			rd = request.getRequestDispatcher("/Index.html");
			rd.forward(request,  response);
		break;
		
		
		case "bloquearTarjeta":
			
			
			
			break;
		
			
		case "ampliarCupo":
			
			
			
			break;
			
			
		}
		
	}
	
}
		
		
		
		
		
		
		
		
