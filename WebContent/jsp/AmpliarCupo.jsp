<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ampliar cupo</title>
<link rel= "stylesheet" href=" ../css/Estilos.css"/>
</head>
<body>
	<h2>Ampliar el cupo disponible</h2>
	<form action = "/ExamenPESSuNombreApellido/Banco/AmpliarCupo" method = "post" enctype ="text/html">
		
		<input type = "hidden" name="id" id="id" value="0"/>
		
		<labe>Número de la tarjeta:</labe>
		<input type = "text" name = "numero" id="Numero" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Cupo máximo: </label>
		<input type = "text" name = "cupoMaximo" id ="CupoMaximo" value="" required = "required"/>
		<br/><br/><br/><br/>
		
		<label>Cantidad a ingresar: </label>
		<input type= "text" name = "cupoDisponible" id="CupoDisponible" value="" required = "required"/>
		<br/><br/><br/><br/>
		
		<label>Tipo: </label>
		<label>Visa: </label>
		<input type = "radio" name = "tipo" id="Visa" value ="Visa" checked = "checked"/>
		<label>Mastercard:</label>
		<input type = "radio" name="tipo" id="Mastercard" value="Mastercard"/>
		<br/><br/><br/><br/>
		
		
		<label>Número de comprobación: </label>
		<input type = "text" name = "numeroComprobacion" id="NumeroComprobacion" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Contraseña: </label>
		<input type = "text" name = "contraseña" id="Contraseña" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Bloqueada: </label>
		<input type="radio" name= "bloqueada" id="Bloqueada" value="si" checked="checked"/>Sí
		<input type="radio" name= "bloqueada" id="Bloqueada" value="no"/>No
		<br/><br/><br/><br/>
		
		
		<input type="submit" id="enviar" name="enviar" value="Enviar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>

		
		
	</form>
	
</body>
</html>
	
