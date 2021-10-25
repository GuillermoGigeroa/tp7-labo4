package daoImpl;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AccesoDatosTipo;
import entidad.Tipo;

public class TipoSeguroDao implements AccesoDatosTipo{
	
//	Atributo
	private ConexionDao conectar = new ConexionDao();
	
//	Constructor
	
	public TipoSeguroDao()  {
		
	}
	  
//	Metodo agregar persona
	
	public int agregarTipo(Tipo tipoSeguro) {
		String query = "insert into tiposeguros (idTipo, descripcion) values (" +tipoSeguro.getIdTipoSeguro() + ",'" + tipoSeguro.getDescripcion() + "')'";
		
		int filas = 0;
		
		try {
//			conectar = DriverManager.getConnection(host+dbName, user, pass);
			Statement st = conectar.conexion().createStatement();
			filas = st.executeUpdate(query);		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return filas;
	}
	
//	Metodo mostrar persona
	
	public Tipo mostrarTipo(int id) {
		
		Tipo entidad = new Tipo();
			
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from tiposeguros where idTipo like "+id+ "";
			ResultSet resultado = st.executeQuery(query);
			if(resultado.next()) {
			entidad.setIdTipoSeguro(Integer.valueOf(resultado.getString("idTipo")).intValue());
			entidad.setDescripcion(resultado.getString("descripcion"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		conectar.cerrar();
		
		return entidad;
	}
	
//	Metodo listar personas
	
	public ArrayList<Tipo> listarTipo(){
		ArrayList<Tipo> listar = new ArrayList<Tipo>();
	
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from tiposeguros";
			ResultSet resultado = st.executeQuery(query);
			
			while(resultado.next()) {
				
				Tipo entidad = new Tipo();
				entidad.setIdTipoSeguro(Integer.valueOf(resultado.getString("idTipo")).intValue());
				entidad.setDescripcion(resultado.getString("descripcion"));
				listar.add(entidad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return listar;

	}

	@Override
	public Boolean modificarTipo(int _idTipoSeguro, String _descripcion) {
		
		boolean hecho = false;
		
	
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Update tiposeguros set descripcion = '" +_descripcion+"' where idTipo = "+_idTipoSeguro+ "";
			hecho = st.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return hecho;
	}

	@Override
	public Boolean eliminarTipo(int id) {
		
		boolean hecho = false;
		
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Delete from tiposeguros where Dni = '"+id+ "'";
			hecho = st.execute(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return hecho;
	}

}
