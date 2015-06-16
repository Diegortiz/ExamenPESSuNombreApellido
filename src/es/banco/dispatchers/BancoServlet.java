package es.banco.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.banco.controller.ejb.AmpliarCupoControllerEjb;
import es.banco.controller.ejb.AmpliarCupoTarjetaControllerEjb;
import es.banco.controller.ejb.BloquearTarjetaControllerEjb;
import es.banco.controller.ejb.DarAltaTarjetaEjb;
import es.banco.controller1.AmpliarCupoController;
import es.banco.entity.TarjetaCredito;




/**
 * Servlet implementation class BancoServlet
 */
@WebServlet("/Banco/*")
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
		String titulo = "Banco";
		RequestDispatcher rd;
		
		switch(action){
		
			case "DarAltaTarjeta":
				rd = request.getRequestDispatcher("/jsp/DarAltaTarjeta.jsp");
				rd.forward (request, response);
			break;
		
			
			case "BloquearTarjeta":
				rd= request.getRequestDispatcher("/jsp/BloquearTarjeta.jsp");
				rd.forward(request, response);
			break;
			
			case "AmpliarCupoTarjeta": 
				
			AmpliarCupoTarjetaControllerEjb todos = new AmpliarCupoTarjetaControllerEjb();
			ArrayList<TarjetaCredito> tarjeta = todos.ampliarCupoTarjeta();
			request.setAttribute("AmpliarCupoTarjeta", tarjeta);
//			todos.ampliarCupoTarjeta();
			titulo="Listado de tarjetas";
			request.setAttribute("titulo", titulo);
			rd = request.getRequestDispatcher("/jsp/AmpliarCupoTarjeta.jsp");
			rd.forward(request,  response);
			break;
			
			case "AmpliarCupo":
				rd = request.getRequestDispatcher("/jsp/AmpliarCupo.jsp");
				rd.forward(request, response);
			break;
			
			
			case "RealizarPago":
				rd = request.getRequestDispatcher("/ArchivosHtml/RealizarPago.html");
				rd.forward(request,  response);
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
		
		case "DarAltaTarjeta":
			String numero = request.getParameter("numero");
			int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
			int cupoDisponible = Integer.parseInt(request.getParameter("cupoDisponible"));
			String tipo = request.getParameter("tipo");
		    int numeroComprobacion = Integer.parseInt(request.getParameter("numeroComprobacion"));
			int contraseña = Integer.parseInt(request.getParameter("contraseña"));
			boolean bloqueada = request.getParameter("bloqueada").equals("si");
		
			
		
			TarjetaCredito tarjeta = new TarjetaCredito(0, numero, cupoMaximo, cupoDisponible, tipo, numeroComprobacion, contraseña, bloqueada);
			
						
			
			DarAltaTarjetaEjb controlador = new DarAltaTarjetaEjb();
			
			controlador.agregar(tarjeta);
			
			
			rd = request.getRequestDispatcher("/index.html");
			rd.forward(request,  response);
		break;
		
		
		case "BloquearTarjeta":
			int id = Integer.parseInt(request.getParameter("id"));
			
			BloquearTarjetaControllerEjb buscarEjb = new BloquearTarjetaControllerEjb();
			buscarEjb.bloquear(id);
			
			
			
			response.sendRedirect("/ExamenPESSuNombreApellido/Banco/BloquearTarjeta");
			
			
			break;
		
			
		case "AmpliarCupo":
			int idTarjetaCredito = Integer.parseInt(request.getParameter("id"));
			String numeroTarjetaCredito= request.getParameter("numero");
			int cupoMaximoTarjetaCredito= Integer.parseInt(request.getParameter("cupoMaximo"));
			int cupoDisponibleTarjetaCredito = Integer.parseInt(request.getParameter("cupoDisponible"));
			String tipoTarjetaCredito = request.getParameter("tipo");
			int numeroComprobacionTarjetaCredito = Integer.parseInt(request.getParameter("numeroComprobacion"));
			int contraseñaTarjetaCredito = Integer.parseInt(request.getParameter("contraseña"));
			boolean bloqueadaTarjetaCredito = request.getParameter("bloqueada").equals("si");
			
			TarjetaCredito tarjetaModif = new TarjetaCredito(idTarjetaCredito, numeroTarjetaCredito, cupoMaximoTarjetaCredito,
					cupoDisponibleTarjetaCredito, tipoTarjetaCredito, numeroComprobacionTarjetaCredito, 
					contraseñaTarjetaCredito, bloqueadaTarjetaCredito);
			
			AmpliarCupoController ampliarEjb = new AmpliarCupoControllerEjb();
			ampliarEjb.ampliar(tarjetaModif);
			
			response.sendRedirect("/ExamenPESSuNombreApellido/Banco/AmpliarCupo");
			
			
			break;
			
		case "RealizarPago":
			
			
			
			
			break;
			
		}
		
	}
	
}
		
		
		
		
		
		
		
		
