package entidad;

public class Seguros {

	// Atributos
	private int idSeguro;
	private String descripcion;
	private int idTipo;
	private double costoContratacion;
	private double costoAseguradora;

	// Construtores

	public Seguros() {
		idSeguro = 0;
		descripcion = "Sin descripcion";
		idTipo = 0;
		costoContratacion = 0;
		costoAseguradora = 0;
	}

	public Seguros(int _idSeguro, String _descripcion, int _idTipo, double _costoContratacion, double _costoAdicional) {
		this.idSeguro = _idSeguro;
		this.descripcion = _descripcion;
		this.idTipo = -idTipo;
		this.costoContratacion = _costoContratacion;
		this.costoAseguradora = _costoAdicional;
	}

	// Settersy Getters

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public double getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public double getCostoAseguradora() {
		return costoAseguradora;
	}

	public void setCostoAseguradora(double costoAseguradora) {
		this.costoAseguradora = costoAseguradora;
	}

	// Metodo hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costoAseguradora);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(costoContratacion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idSeguro;
		result = prime * result + idTipo;
		return result;
	}

	// Metodo equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seguros other = (Seguros) obj;
		if (Double.doubleToLongBits(costoAseguradora) != Double.doubleToLongBits(other.costoAseguradora))
			return false;
		if (Double.doubleToLongBits(costoContratacion) != Double.doubleToLongBits(other.costoContratacion))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idSeguro != other.idSeguro)
			return false;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}

	// Metodo toString
	@Override
	public String toString() {
		return "Seguros [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + idTipo
				+ ", costoContratacion=" + costoContratacion + ", costoAseguradora=" + costoAseguradora + "]";
	}

}
