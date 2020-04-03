package com.MATC.controladordedatos;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MATC.model.Tproducto;

/**
 * Servlet implementation class ServleletControler
 */
public class ServleletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acction = request.getParameter("btn");
		EntityManager em;
		
		EntityManagerFactory emf;
		
		emf= Persistence.createEntityManagerFactory("INICIANDO-HIBERTATEE-JPA");
		
		em= emf.createEntityManager();
		Tproducto pr = new Tproducto();
		try {
		
		String id= request.getParameter("Id");
		String nombrepr= request.getParameter("Nproductos");
		String preciopr= request.getParameter("Pproductos");
		String cantidadpr= request.getParameter("Cproductos");
		String totalpr= request.getParameter("Tproductos");
		
		
		
		pr.setId(Integer.parseInt(id));
		pr.setNombreProducto(nombrepr);
		pr.setPrecioProducto(Double.parseDouble(preciopr));
		pr.setCantidadProducto(Integer.parseInt(cantidadpr));
		pr.setTotalProducto(Double.parseDouble(totalpr));
		

		}catch (Exception e) {
			
		}
		if (acction.equals("agregar")) {

			
			em.getTransaction().begin();
			em.persist(pr);
			em.flush();
			em.getTransaction().commit();
			
			
		}else if(acction.equals("eliminar")) {
			pr=em.getReference(Tproducto.class, pr.getId());
			
			em.getTransaction().begin();
			em.remove(pr);
			em.flush();
			em.getTransaction().commit();
		}else if(acction.equals("modificar")) {
			em.getTransaction().begin();
			em.merge(pr);
			em.flush();
			em.getTransaction().commit();
			
		}
		response.sendRedirect("index.jsp");
		
		
		
		
		
	}

}
