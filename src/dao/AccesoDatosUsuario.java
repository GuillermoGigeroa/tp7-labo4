package dao;

import java.util.ArrayList;
import entidad.Usuario;

public interface AccesoDatosUsuario {

	// Acceso a datos del ususario
	public Usuario mostrarUsuario(String dni);

	public ArrayList<Usuario> listarUsuario();

	public Boolean eliminarUsuario(String dni);

	public Boolean modificarUsuario(String _nombreUsuario, String _password, int _tipoUsuario, String _dni,
			String _nombre, String _apellido);
}
