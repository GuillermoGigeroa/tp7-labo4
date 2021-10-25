package dao;

import java.util.ArrayList;

import entidad.Contratacion;

public interface AccesoDatosContratacion {
	
//	Metodos de acceso a datos de Contratacion
	
	public Contratacion mostrarContratacion(int id);
	
	public ArrayList<Contratacion> listarContatacion();
	
	public Boolean eliminarContratacion(int id);

	public Boolean modificarContatacion(int _idContratacion, String _nombreUsuario, int _idSeguro, double _costoContratacion);
	
}
