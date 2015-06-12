<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dar de alta tarjeta</title>
<link rel= "stylesheet" href=" ../css/Estilos.css"/>
</head>
<body>
	<h2>Dar de alta tarjeta</h2>
	<form action = "/ExamenPESSuNombreApellido/Banco/DarAltaTarjeta" method = "post" enctype ="text/html">
		<labe>Número:</labe>
		<input type = "text" name = "numero" id="Numero" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Cupo máximo: </label>
		<input type = "text" name = "cupoMaximo" id ="CupoMaximo" value="" required = "required"/>
		<br/><br/><br/><br/>
		
		<label>Cupo disponible: </label>
		<input type= "text" name = "cupoDisponible" id="CupoDisponible" value="" required = "required"/>
		<br/><br/><br/><br/>
		
		<label>Visa: </label>
		<input type = "checkbox" name = "visa" id="Visa" value ="" required ="required"/>
		<label>Mastercard: </label>
		<input type = "checkbox" name="mastercard" id="Mastercard" value="" required = "required"/>
		<br/><br/><br/><br/>
		
		<label>Número comprobación: </label>
		<input type= "text" name= "numeroComprobacion" id="NumeroComprobacion" value = "" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Contraseña: </label>
		<input type="text" name= "contraseña" id="Contraseña" value="" required="required" />
		<br/><br/><br/><br/>
		
		<label>Bloqueada: </label>
		<input type="radio" name= "bloqueada" id="Bloqueada" value="" required="required" />
		<br/><br/><br/><br/>
		
		<input type="submit" id="enviar" name="enviar" value="Enviar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>
		
		
		<input type = "hidden" name="id" id="id"/>
		
		<br/><br/><br/><br/>
		
	
	</form>



</body>
</html>