package daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AccesoDatosSeguro;
import entidad.Seguros;;

public class SegurosDao implements AccesoDatosSeguro {

	// Atributos
	private ConexionDao conectar = new ConexionDao();

	// Constructor

	public SegurosDao() {
	}

	// Metodo agregar persona

	public int agregarSeguro(Seguros seguro) {
		String query = "insert into seguros (descripcion, idTipo, costoContracion, costoAdicional) values ('"
				+ seguro.getDescripcion() + "','" + seguro.getIdTipo() + "','" + seguro.getCostoContratacion() + ","
				+ seguro.getCostoAseguradora() + "')";

		int filas = 0;

		try {
			// conectar = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = conectar.conexion().createStatement();
			filas = st.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return filas;
	}

	// Metodo mostrar persona

	public Seguros mostrarSeguro(int id) {

		Seguros entidad = new Seguros();

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from seguros where id like " + id + "";
			ResultSet resultado = st.executeQuery(query);
			if (resultado.next()) {
				entidad.setIdSeguro(Integer.valueOf(resultado.getString("id")).intValue());
				entidad.setDescripcion(resultado.getString("descripcion"));
				entidad.setCostoContratacion(Double.valueOf(resultado.getString("costoContratacion")).doubleValue());
				entidad.setCostoAseguradora(Double.valueOf(resultado.getString("costoAdicional")).doubleValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		conectar.cerrar();

		return entidad;
	}

	// Metodo listar personas

	public ArrayList<Seguros> listarSeguro() {
		ArrayList<Seguros> listar = new ArrayList<>();

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from seguros";
			ResultSet resultado = st.executeQuery(query);

			while (resultado.next()) {

				Seguros entidad = new Seguros();
				entidad.setIdSeguro(Integer.valueOf(resultado.getString("id")).intValue());
				entidad.setDescripcion(resultado.getString("descripcion"));
				entidad.setCostoContratacion(Double.valueOf(resultado.getString("costoContratacion")).doubleValue());
				entidad.setCostoAseguradora(Double.valueOf(resultado.getString("costoAdicional")).doubleValue());
				listar.add(entidad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return listar;

	}

	public Boolean modificarSeguro(int _idSeguro, String _descripcion, int _idTipo, double _costoContratacion,
			double _costoAdicional) {

		boolean hecho = false;

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Update seguros set descripcion = '" + _descripcion + "', idTipo = " + _idTipo
					+ " , costoContratacion = " + _costoContratacion + ", costoAdicional= " + _costoAdicional
					+ " where id = " + _idSeguro + "";
			hecho = st.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return hecho;
	}

	public Boolean eliminarSeguro(int id) {

		boolean hecho = false;

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Delete from seguros where Dni = '" + id + "'";
			hecho = st.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return hecho;
	}
	
	public int getProximoID() {
		int proximo = -1;
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'segurosgroup' AND TABLE_NAME = 'seguros'";
			ResultSet resultado = st.executeQuery(query);
			resultado.next();
			proximo = resultado.getInt("AUTO_INCREMENT");
		} catch (Exception e) {
			e.printStackTrace();
		}
		conectar.cerrar();
		return proximo;
	}

}
