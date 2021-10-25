package daoImpl;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.AccesoDatosContratacion;
import entidad.Contratacion;

public class ContratacionDao implements AccesoDatosContratacion {
	
//	Atributos
	private ConexionDao conectar;
	
//	Constructor
	public ContratacionDao() {
		
	}
	  
//	Metodo agregar persona
	
	public int agregarContratacion(Contratacion contrato) {
		String query = "insert into contratacion (nombreUsuario, idSeguro, costoContracion) values ('" +contrato.getNombreUsuario() + "'," + contrato.getIdSeguro()+ "," + contrato.getCostoContratacion()+"')";
		
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
	
	public Contratacion mostrarContratacion(int id) {
		
		Contratacion entidad = new Contratacion();
			
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from contratacion where idContratacion like "+id+ "";
			ResultSet resultado = st.executeQuery(query);
			if(resultado.next()) {
				entidad.setIdContratacion(Integer.valueOf(resultado.getString("idContratacion")).intValue());
				entidad.setNombreUsuario(resultado.getString("nombreUsuario"));
				entidad.setIdSeguro(Integer.valueOf(resultado.getString("idSeguro")).intValue());
				entidad.setCostoContratacion(Double.valueOf(resultado.getString("costoContratacion")).doubleValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		conectar.cerrar();
		
		return entidad;
	}
	
//	Metodo listar personas
	
	public ArrayList<Contratacion> listarContatacion(){
		ArrayList<Contratacion> listar = new ArrayList<>();
	
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Select * from contratacion";
			ResultSet resultado = st.executeQuery(query);
			
			while(resultado.next()) {
				
				Contratacion entidad = new Contratacion();
				entidad.setIdContratacion(Integer.valueOf(resultado.getString("isContratacion")).intValue());
				entidad.setIdSeguro(Integer.valueOf(resultado.getString("idContratacion")).intValue());
				entidad.setNombreUsuario(resultado.getString("nombreUsuario"));
				entidad.setCostoContratacion(Double.valueOf(resultado.getString("costoContratacion")).doubleValue());
				listar.add(entidad);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return listar;

	}

	public Boolean modificarContatacion(int _idContratacion, String _nombreUsuario, int _idSeguro, double _costoContratacion) {
		
		boolean hecho = false;
		
	
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Update contratacion set nombreUsuario = '" +_nombreUsuario+"', idSeguro = " +_idSeguro+ " , costoContratacion = " +_costoContratacion+ " where idContratacion = "+_idContratacion+ "";
			hecho = st.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return hecho;
	}

	@Override
	public Boolean eliminarContratacion(int id) {
		
		boolean hecho = false;
		
		try {
			Statement st = conectar.conexion().createStatement();
			String query = "Delete from contratacion where idContratacion = "+id+ "";
			hecho = st.execute(query);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		conectar.cerrar();
		
		return hecho;
	}

}
