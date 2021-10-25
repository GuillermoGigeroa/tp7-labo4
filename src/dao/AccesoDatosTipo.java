package dao;

import java.util.ArrayList;
import entidad.Tipo;

public interface AccesoDatosTipo {
	
//	Metodos de acceso a datos de tipo se seguros
	
	public Tipo mostrarTipo(int id);
	
	public ArrayList<Tipo> listarTipo();
	
	public Boolean eliminarTipo(int id);

	public Boolean modificarTipo(int _idTipoSeguro, String _descripcion);
	
}
