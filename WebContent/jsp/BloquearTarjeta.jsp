<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bloquear tarjeta</title>
<link rel= "stylesheet" href="../css/Estilos.css"/>
</head>
<body>
	<h2>Bloquear tarjeta</h2>
	
	<form action="/ExamenPESSunombreApellido/Banco/BloquearTarjeta" method="post" enctype="text/html">
	
	
		<labe>Número de la tarjeta:</labe>
		<input type = "text" name = "numero" id="Numero" value="" required ="required"/>
		<br/><br/><br/><br/>
	
		<label>Número comprobación: </label>
		<input type= "text" name= "numeroComprobacion" id="NumeroComprobacion" value = "" required ="required"/>
		<br/><br/><br/><br/>
		
		<label>Contraseña: </label>
		<input type="text" name= "contraseña" id="Contraseña" value="" required="required" />
		<br/><br/><br/><br/>
		
		<label>Bloquear: </label>
		<input type="checkbox" name= "bloqueada" id="Bloqueada" value="" required="required" />
		<br/><br/><br/><br/>
	
	
		<input type="submit" id="enviar" name="enviar" value="Enviar"/>
		<input type="reset" id="borrar" name="borrar" value="Borrar"/>
	
	
	
	</form>

</body>
</html>


