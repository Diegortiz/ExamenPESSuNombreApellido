<%@page import="es.banco.entity.TarjetaCredito"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listado de tarjetas</title>
		<link rel="stylesheet" href="../css/Estilos3.css">
		
		<script type = "text/javascript">
			function actualizar(boton){
				var formulario1 = document.getElementById("formulario1" + boton.name.substring(8));
				if(boton.value =="Ampliar cupo")
					formulario1.action = 
						"${pageContext.request.contextPath}/Banco/AmpliarCupo";
					if (boton.value=="Bloquear tarjeta")
						formulario1.action =
							"${pageContext.request.contextPath}/Banco/BloquearTarjeta";
					if (boton.value == "Efectuar pago")
						formulario1.action =
							"${pageContext.request.contextPath}/Banco/RealizarPago";
			
					
			   formulario.submit();
				
				
			}
		
		
		</script>

	</head>

	<body>

	<h2>Listado de tarjetas</h2>
	<% ArrayList<TarjetaCredito> tarjeta = (ArrayList<TarjetaCredito>)request.getAttribute("AmpliarCupoTarjeta"); %>
			<table>
				<tr>
					<th>Id</th>
					<th>Número</th>
					<th>Cupo máximo</th>
					<th>Cupo disponible</th>
					<th>Tipo</th>
					<th>Número comprobación</th>
					<th>Contraseña</th>
					<th>Bloqueada</th>
				</tr>
				<%for (TarjetaCredito c: tarjeta){ %>
			<form id = "formulario1<%= c.getId() %>" action= "#" method = "post"  onsubmit = "return false;">
			<!--for each y array(la c puede llamarse de cualquier forma-->
			<tr id = "<%= c.getId()%>">
				<td><%= c.getId() %></td>
				<td><%=c.getNumero() %></td>
				<td><input type = "text" name ="cupoMaximo" value="<%=c.getCupoMaximo() %>"/></td>
				<td><input type = "text" name = "cupoDisponible" value="<%=c.getCupoDisponible() %>"/></td>
				<td><%=c.getTipo() %></td>
				<td><%=c.getNumeroComprobacion() %></td>
				<td><inpt type ="text" name="contraseña" value = "<%=c.getContraseña()%>"/></td>
				<td><input type = "text" name="bloqueada" value ="<%=c.isBloqueada() %>"/></td>
				
				<td><input type = "submit" id = "OtroBtn" 
				value = "Ampliar cupo" name = "btn2<%= c.getId()%>"
				 onclick ="enviar(this);"/></td>
				 
				<td><input type= "submit" id ="OtroBtn2"
				value="Bloquear tarjeta" name = "btn3<%=c.getId() %>"
				onclick ="enviar(this);"/></td>
			
				<td><input type = "submit" id = "OtroBtn3"
				value = "Efectuar pago" name="btn4<%=c.getId() %>"
				onclick = "enviar(this);"/></td>
				
				
			</tr>
				
		
				</form>
				<%} %>
			</table>
	
		
	</body>
	
</html>
				
		
				
		
		
		
		
	
		
		
		