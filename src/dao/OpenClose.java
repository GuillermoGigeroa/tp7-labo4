package dao;

import java.sql.Connection;

public interface OpenClose {

	// Metodo conectar

	public Connection conexion();

	// Metodo cerrar coneccion

	public void cerrar();

}
