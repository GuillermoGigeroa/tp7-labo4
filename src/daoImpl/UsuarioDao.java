package daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import dao.AccesoDatosUsuario;
import entidad.Usuario;

public class UsuarioDao implements AccesoDatosUsuario {

	// Atributo
	private ConexionDao conectar;

	// Constructor
	public UsuarioDao() {

	}

	// Metodo agregar persona

	public int agregarUsuario(Usuario user) {
		String query = "insert into usuarios (nombreUsuario, pass, tipoUsuario, dni, nombre, apellido) values ('"
				+ user.getNombreUsuario() + "','" + user.getPassword() + "', " + user.getTipoUsuario() + ",'"
				+ user.getDni() + "','" + user.getNombre() + "','" + user.getApellido() + "')";

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

	public Usuario mostrarUsuario(String dni) {

		Usuario entidad = new Usuario();

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from usuario where dni like '" + dni + "'";
			ResultSet resultado = st.executeQuery(query);
			if (resultado.next()) {
				entidad.setNombreUsuario(resultado.getString("nombreUsuario"));
				entidad.setPassword(resultado.getNString("pass"));
				entidad.setTipoUsuario(Integer.valueOf(resultado.getString("tipoUsuario")).intValue());
				entidad.setDni(resultado.getNString("dni"));
				entidad.setNombre(resultado.getNString("nombre"));
				entidad.setApellido(resultado.getString("apellido"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		conectar.cerrar();

		return entidad;
	}

	// Metodo listar personas

	public ArrayList<Usuario> listarUsuario() {
		ArrayList<Usuario> listar = new ArrayList<>();

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from usuarios";
			ResultSet resultado = st.executeQuery(query);

			while (resultado.next()) {

				Usuario entidad = new Usuario();
				entidad.setNombreUsuario(resultado.getString("nombreUsuario"));
				entidad.setPassword(resultado.getNString("pass"));
				entidad.setTipoUsuario(Integer.valueOf(resultado.getString("tipoUsuario")).intValue());
				entidad.setDni(resultado.getNString("dni"));
				entidad.setNombre(resultado.getNString("nombre"));
				entidad.setApellido(resultado.getString("apellido"));
				listar.add(entidad);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return listar;

	}

	public Boolean modificarUsuario(String _nombreUsuario, String _password, int _tipoUsuario, String _dni,
			String _nombre, String _apellido) {

		boolean hecho = false;

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Update usuarios set nombreUsuario = '" + _nombreUsuario + "', pass = '" + _password
					+ "' , tipoUsuario = " + _tipoUsuario + ", nombre = '" + _nombre + "', apellido = '" + _apellido
					+ "' where dni = " + _dni + "";
			hecho = st.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return hecho;
	}

	public Boolean eliminarUsuario(String dni) {

		boolean hecho = false;

		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Delete from usuarios where Dni = '" + dni + "'";
			hecho = st.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		conectar.cerrar();

		return hecho;
	}

}
