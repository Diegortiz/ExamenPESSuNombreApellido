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
		
		<label>Número de la tarjeta: </label>
		<input type = "text" name = "numero" id="Numero" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Número de comprobación: </label>
		<input type = "text" name = "numeroComprobacion" id="NumeroComprobacion" value="" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Contraseña: </label>
		<input type = "text" name = "contraseña" id="Contraseña" value="" required ="required"/>
		<br/><br/><br/><br/>
		
	
		<label>Cantidad: </label>
		<input type = "text" name = "cantidad" id="Cantidad" value="" required ="required"/>
		<br/><br/><br/><br/>
		
	

	<input type="submit" id="enviar" name="enviar" value="Enviar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>

	
	</form>
	
</body>
</html>