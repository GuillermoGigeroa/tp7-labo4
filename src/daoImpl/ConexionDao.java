package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

import dao.OpenClose;

public class ConexionDao implements OpenClose {

	private String host = "localhost/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	private String url = "jdbc:mysql://" + host + dbName;
	private Connection conectar;

	// Metodo conectar

	public Connection conexion() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conectar = DriverManager.getConnection(this.url, this.user, this.pass);
		} catch (Exception e) {
			System.out.println("Error en la base" + e.getMessage());
		}

		return this.conectar;
	}

	// Metodo cerrar coneccion

	public void cerrar() {
		if (this.conectar != null) {
			try {
				this.conectar.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
