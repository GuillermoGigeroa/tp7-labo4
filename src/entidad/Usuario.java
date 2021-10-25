package entidad;

public class Usuario {
	
//	Atributo
	private String nombreUsuario;
	private String password;
	private int tipoUsuario;
	private String dni;
	private String nombre;
	private String apellido;
	
//	Constructores
	public Usuario() {
		nombreUsuario = "Sin usuario";
		password = "Sin contratacion";
		tipoUsuario = 0;
		dni = "Sin dni";
		nombre = "Sin nombre";
		apellido = "Sin apellido";	
	}
	public Usuario(String _nombreUsuario, String _password, int _tipoUsuario, String _dni, String _nombre, String _apellido) {
		this.nombreUsuario = _nombreUsuario;
		password = _password;
		tipoUsuario = _tipoUsuario;
		dni = _dni;
		nombre = _nombre;
		apellido = _apellido;
	}
	
//	Getters y Setters
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
//	Metodo hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + tipoUsuario;
		return result;
	}
	
//	Metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}
	
//	Metodo toString
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", password=" + password + ", tipoUsuario=" + tipoUsuario
				+ ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
