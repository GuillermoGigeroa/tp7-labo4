<%@page import="java.util.Iterator"%>
<%@page import="entidad.Tipo"%>
<%@page import="daoImpl.TipoSeguroDao"%>
<%@page import="daoImpl.SegurosDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="formato.css">
<title>Agregar seguro</title>
</head>
<body class="colorTerciario">
	<div class="navbar colorPrimario menu">
		<a class="colorSecundario separar bordes" href="Inicio.jsp">Inicio</a>
		<a class="colorSecundario separar bordes activo" href="AgregarSeguro.jsp">Agregar seguro</a>
		<a class="colorSecundario separar bordes" href="ListarSeguro.jsp">Listar seguros</a>
	</div>
	<div class="contenido colorTerciario">
		<div class="titulo centrado">
			<h2>Agregar Seguros</h2>
		</div>
		<form action="ServletSeguros" method="post" class="centrado">
			<ul>
				<li class="container">
					<label id="idSeguro" class="mitad izquierda">
						ID Seguro
					</label>
					<label id="txtSeguro" class="mitad centrado">
						<%=(new SegurosDao()).getProximoID()%>
					</label>
				</li>
				<li class="container">
					<label for="descripcion" class="mitad izquierda">Descripcion</label>
					<input type="text" id="descripcion" required name="txtDescripcion" class="mitad" />
				</li>
				<li class="container">
					<label for="lista" class="mitad izquierda">Tipo de seguro</label>
					<select name="tipo" id="lista" class="mitad centrado">
						<%  TipoSeguroDao dao = new TipoSeguroDao();
						    ArrayList<Tipo> listaTipo = dao.listarTipo();	
			  			    if (listaTipo != null) {
			  			    for (Tipo tipo : listaTipo) { %>
						<option value = "<%= tipo.getIdTipoSeguro() %>"> <%= tipo.getDescripcion() %></option>
							<%}}%>
					</select>
				</li>
				<li class="container">
					<label for="costo" class="mitad izquierda">Costo contratacion</label>
					<input type="number" id="costo" required name="txtCosto" class="mitad" />
				</li>
				<li class="container">
					<label for="costoMax" class="mitad izquierda">Costo maximo asegurado</label>
					<input type="number" id="costoMax" required name="txtCostoMax" class="mitad" />
				</li>
				<li class="container">
					<label class="mitad">&nbsp;</label>
					<input type="submit" name="btnAceptar" value="Aceptar" class="mitad centrado" />
				</li>
			</ul>
		</form>
		<% if(request.getAttribute("funciono") != null) {
			boolean funciono = (boolean) request.getAttribute("funciono");
			if(funciono) {
		%>
		<label>Se agregó correctamente.</label>
		<%
		}}
		%>
	</div>
</body>
</html>