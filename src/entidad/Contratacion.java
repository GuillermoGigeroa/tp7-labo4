package entidad;

public class Contratacion {
	
//	Atributos
	
	private int idContratacion;
	private String nombreUsuario;
	private int idSeguro;
	private double costoContratacion;
	
//	Contructores	
	public Contratacion() {
		idContratacion = 0;
		nombreUsuario = "Sin nombre";
		idSeguro = 0;
		costoContratacion = 0;
	}
	public Contratacion (int _idContratacion, String _nombre, int _idSeguro, double _costo) {
		this.idContratacion = _idContratacion;
		this.nombreUsuario = _nombre;
		this.idSeguro = _idSeguro;
		this.costoContratacion = _costo;	
	}
	
//	Getters y Setters
	public int getIdContratacion() {
		return idContratacion;
	}
	public void setIdContratacion(int idContratacion) {
		this.idContratacion = idContratacion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	
//	metodo hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costoContratacion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idContratacion;
		result = prime * result + idSeguro;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		return result;
	}
	
//	metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratacion other = (Contratacion) obj;
		if (Double.doubleToLongBits(costoContratacion) != Double.doubleToLongBits(other.costoContratacion))
			return false;
		if (idContratacion != other.idContratacion)
			return false;
		if (idSeguro != other.idSeguro)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		return true;
	}
	
//	metodo toString
	@Override
	public String toString() {
		return "Contratacion [idContratacion=" + idContratacion + ", nombreUsuario=" + nombreUsuario + ", idSeguro="
				+ idSeguro + ", costoContratacion=" + costoContratacion + "]";
	}

}
