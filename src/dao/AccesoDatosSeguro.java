package dao;

import java.util.ArrayList;
import entidad.Seguros;

public interface AccesoDatosSeguro {
	
//	Metodos de acceso a datos de Seguros
	
	public Seguros mostrarSeguro(int id);
	
	public ArrayList<Seguros> listarSeguro();
	
	public Boolean eliminarSeguro(int id);

	public Boolean modificarSeguro(int _idSeguro, String _descripcion, int _idTipo, double _costoContratacion, double _costoAdicional);
	
}
