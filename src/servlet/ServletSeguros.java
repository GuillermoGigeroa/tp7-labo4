package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SegurosDao;
import daoImpl.TipoSeguroDao;
import entidad.Seguros;
import entidad.Tipo;

/**
 * Servlet implementation class ServletSeguros
 */
@WebServlet("/ServletSeguros")
public class ServletSeguros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSeguros() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("n") != null) {
			TipoSeguroDao dao = new TipoSeguroDao();
			ArrayList<Tipo> listaTipo = dao.listarTipo();
			
			request.setAttribute("listaTSeguro", listaTipo.iterator());
			RequestDispatcher rd = request.getRequestDispatcher ( "AgregarSeguro.jsp" );     
			rd.forward (request, response); 
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SegurosDao dao = new SegurosDao();
		Seguros seguro = new Seguros();
		
		if(request.getParameter("btnAceptar")!= null){
			seguro.setDescripcion(request. getParameter("txtDescripcion"));
			seguro.setIdTipo(Integer.valueOf(request.getParameter("tipo")));
			seguro.setCostoContratacion(Double.valueOf(request.getParameter("txtCosto")));
			seguro.setCostoAseguradora(Double.valueOf(request.getParameter("txtCostoMax")));
			
			int resultado = dao.agregarSeguro(seguro);
			if (resultado == 1) {
				request.setAttribute("funciono", true);
			}
			RequestDispatcher rd = request.getRequestDispatcher ( "AgregarSeguro.jsp" );     
			rd.forward (request, response); 
		}
		
		if(request.getParameter("btnFiltrar")!= null) {
			ArrayList<Seguros> lista = dao.listarSeguro(Integer.valueOf(request.getParameter("tipo")));
			request.setAttribute("ListaSeguros", lista);
			RequestDispatcher rd = request.getRequestDispatcher ( "ListarSeguro.jsp" );     
			rd.forward (request, response); 
		}
}
}