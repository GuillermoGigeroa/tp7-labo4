<%@page import="entidad.Seguros"%>
<%@page import="entidad.Tipo"%>
<%@page import="daoImpl.TipoSeguroDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="formato.css">
<title>Listar Seguros</title>
</head>
<body class="colorTerciario">
	<div class="navbar colorPrimario menu">
		<a class="colorSecundario separar bordes" href="Inicio.jsp">Inicio</a>
		<a class="colorSecundario separar bordes" href="AgregarSeguro.jsp">Agregar seguro</a>
		<a class="colorSecundario separar bordes activo" href="ListarSeguro.jsp">Listar seguros</a>
	</div>
	<div class="contenido colorTerciario">
		<div class="titulo">
			<h2>"Tipos de seguros de la base de datos"</h2>
		</div>
		<form action="ServletSeguros" method="post">
		<div class="container centrado">
			<label class="separar">Busqueda por tipos de Seguros:</label>
			<select name="tipo" class="separar">
				<%  TipoSeguroDao dao = new TipoSeguroDao();
				    ArrayList<Tipo> listaTipo = dao.listarTipo();	
	  			    if (listaTipo != null) {
	  			    for (Tipo tipo : listaTipo) { %>
				<option value = "<%= tipo.getIdTipoSeguro() %>"
				<% if (request.getAttribute("tipoLista") != null) {
					if((int) request.getAttribute("tipoLista") == tipo.getIdTipoSeguro()){
					%>
						selected			
					<%  }
						}%>
				> <%= tipo.getDescripcion() %></option>
					<%}}%>
			</select>
			<input type="submit" name="btnFiltrar" value="Filtrar">
		</div>
		<div class="container centrado">
			<table border="1">
				<tr>
					<th>ID seguro</th>
					<th>Descripcion seguro</th>
					<th>Descripcion tipo seguro</th>
					<th>Costo contratacion</th>
					<th>Costo maximo asegurado</th>
				</tr>
				<% if(request.getAttribute("ListaSeguros") != null){
					ArrayList<Seguros> lista = (ArrayList<Seguros>) request.getAttribute("ListaSeguros");
					for (Seguros s : lista){
				%>
				<tr>
					<td><%=s.getIdSeguro()%></td>
					<td><%=s.getDescripcion()%></td>
					<td><%=s.getIdTipo()%></td>
					<td><%=s.getCostoContratacion()%></td>
					<td><%=s.getCostoAseguradora()%></td>
				</tr>
				<%}}%>
			</table>
		</div>
		</form>
	</div>
</body>
</html>