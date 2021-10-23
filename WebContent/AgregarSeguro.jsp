<%@page import="daoImpl.SegurosDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="formato.css">
<title>Agregar seguro</title>
</head>
<body>
	<div class="titulo">
		<a href="Inicio.jsp">Inicio</a>
		<a href="AgregarSeguro.jsp">Agregar seguro</a>
		<a href="ListarSeguro.jsp">Listar seguros</a>
	</div>
	<div class="titulo">
        <h1>Agregar Seguros</h1>
    </div>
	<form action="servletAgregarSeguros">
		<ul>
			<li class="container">
                <label id="lblSeguro" class="mitad">ID Seguro</label>
                <label id="txtSeguro" class="mitad centrado">
					<%=(new SegurosDao()).getProximoID()%>
                </label>
			</li>
			<li class="container">
				<label for="descripcion" class="mitad">Descripcion</label>
				<input type="text" name="apellido" class="mitad"/>
			</li>
			<li class="container">
				<label class="mitad">Tipo de seguro</label>
				<select name="tipoSeguros" class="mitad centrado">
					<option value="1">Seguro de casas 1</option>
					<option value="2">Seguro de casas 2</option>
					<option value="3">Seguro de casas 3</option>
				</select>
			</li>
			<li class="container">
				<label class="mitad">Costo contrataci�n</label>
				<input type="text" name="costoCont" class="mitad"/>
			</li>
			<li class="container">
				<label class="mitad">Costo m�ximo asegurado</label>
                <input type="text" name="costoMax" class="mitad"/>
			</li>
            <li class="container">
                <label class="mitad">&nbsp;</label>
                <input type="submit" name="btnAceptar" value="Aceptar" class="mitad centrado"/>
            </li>
		</ul>
	</form>
</body>
</html>