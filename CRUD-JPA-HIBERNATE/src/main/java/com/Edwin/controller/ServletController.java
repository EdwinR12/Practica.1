package com.Edwin.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import com.Edwin.dao.ProductoDao;
import com.Edwin.model.TblProducto;
import com.google.gson.Gson;
import com.mysql.fabric.Response;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TblProducto pr = new TblProducto();
		ProductoDao prd = new ProductoDao();

		String id = null;
		String nombreProducto = null;
		String precioProducto = null;
		String cantidadProducto = null;
		String totalProducto = null;

		try {

			id = request.getParameter("Id");
			nombreProducto = request.getParameter("Nproductos");
			precioProducto = request.getParameter("Pproductos");
			cantidadProducto = request.getParameter("Cproductos");
			totalProducto = request.getParameter("Tproductos");

			pr.setId(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));

		} catch (Exception e) {

		}

		String action = request.getParameter("btn");

		if (action.equals("Guardar")) {

			pr.setId(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));

			prd.agregarDatos(pr);

		} else if (action.equals("Actualizar")) {

			pr.setId(Integer.parseInt(id));
			pr.setNombreProducto(nombreProducto);
			pr.setPrecioProducto(Double.parseDouble(precioProducto));
			pr.setCantidadProducto(Integer.parseInt(cantidadProducto));
			pr.setTotalProducto(Double.parseDouble(totalProducto));

			prd.actualizarDatos(pr);

		} else if (action.equals("Eliminar")) {
			try {
				pr.setId(Integer.parseInt(id));
				prd.eliminarDatos(pr);
			} catch (Exception e) {
				System.out.println(e);
			}

		}

		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductoDao prdao = new ProductoDao();

		Gson json = new Gson();

		try {
			response.getWriter().append(json.toJson(prdao.productosLista()));

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
