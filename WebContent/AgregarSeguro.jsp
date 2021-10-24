<%@page import="daoImpl.SegurosDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="formato.css">
<title>Agregar seguro</title>
</head>
<body class="colorTerciario">
	<div class="navbar colorPrimario menu">
		<a class="colorSecundario separar bordes" href="Inicio.jsp">Inicio</a>
		<a class="colorSecundario separar bordes" href="AgregarSeguro.jsp">Agregar seguro</a>
		<a class="colorSecundario separar bordes" href="ListarSeguro.jsp">Listar seguros</a>
	</div>
	<div class="contenido colorTerciario">
		<div class="titulo centrado">
			<h2>Agregar Seguros</h2>
		</div>
		<form action="servletAgregarSeguros" class="centrado">
			<ul>
				<li class="container">
					<label id="lblSeguro" class="mitad izquierda">
						ID Seguro
					</label>
					<label id="txtSeguro" class="mitad centrado">
						<%=(new SegurosDao()).getProximoID()%>
					</label>
				</li>
				<li class="container">
					<label for="descripcion" class="mitad izquierda">Descripcion</label>
					<input type="text" name="apellido" class="mitad" />
				</li>
				<li class="container">
					<label class="mitad izquierda">Tipo de seguro</label>
					<select name="tipoSeguros" class="mitad centrado">
						<option value="1">Seguro de casas 1</option>
						<option value="2">Seguro de casas 2</option>
						<option value="3">Seguro de casas 3</option>
					</select>
				</li>
				<li class="container">
					<label class="mitad izquierda">Costo contratacion</label>
					<input type="text" name="costoCont" class="mitad" />
				</li>
				<li class="container">
					<label class="mitad izquierda">Costo maximo asegurado</label>
					<input type="text" name="costoMax" class="mitad" />
				</li>
				<li class="container">
					<label class="mitad">&nbsp;</label>
					<input type="submit" name="btnAceptar" value="Aceptar" class="mitad centrado" />
				</li>
			</ul>
		</form>
	</div>
</body>
</html>