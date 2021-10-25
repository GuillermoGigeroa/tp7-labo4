package entidad;

public class Tipo {
	
//	Atributos
	private int idTipoSeguro;
	private String descripcion;
	
//	Constructores
	public Tipo() {
		idTipoSeguro = 0;
		descripcion = "Sin descripcion";
	}
	public Tipo(int _idTipo, String _descripcion) {
		this.idTipoSeguro = _idTipo;
		this.descripcion = _descripcion;
	}
	
//	Getters y Setters
	public int getIdTipoSeguro() {
		return idTipoSeguro;
	}
	public void setIdTipoSeguro(int idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
//	Metodo hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idTipoSeguro;
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
		Tipo other = (Tipo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idTipoSeguro != other.idTipoSeguro)
			return false;
		return true;
	}
	
//	Metodo toString
	@Override
	public String toString() {
		return "Tipo [idTipoSeguro=" + idTipoSeguro + ", descripcion=" + descripcion + "]";
	}
}
