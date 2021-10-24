<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<a class="colorSecundario separar bordes" href="ListarSeguro.jsp">Listar seguros</a>
	</div>
	<div class="contenido colorTerciario">
		<div class="titulo">
			<h2>"Tipos de seguros de la base de datos"</h2>
		</div>
		<div class="container centrado">
			<label class="separar">Busqueda por tipos de Seguros:</label>
			<select name="tipoSeguros" class="separar">
				<option value="1">Seguro de casas 1</option>
				<option value="2">Seguro de casas 2</option>
				<option value="3">Seguro de casas 3</option>
			</select>
			<input type="submit" name="btnFiltrar" value="Filtrar">
		</div>
		<div class="container centrado">
			<table border="1">
				<tr>
					<th>ID seguro</th>
					<th>Descripcion seguro</th>
					<th>Descripcion tipo seguro</th>
					<th>Costo contrataci�n</th>
					<th>Costo m�ximo asegurado</th>
				</tr>
				<tr>
					<td>1</td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
				</tr>
				<tr>
					<td>2</td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
					<td>null</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>