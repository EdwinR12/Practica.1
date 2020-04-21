package com.Edwin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.loader.plan.spi.Return;

import com.Edwin.model.TblProducto;

public class ProductoDao {

	public List<TblProducto> productosLista() {

		List<TblProducto> listapr = new ArrayList<>();

		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			listapr = em.createQuery("from TblProducto").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listapr;

	}

	public void agregarDatos(TblProducto pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pr);
		em.flush();
		em.getTransaction().commit();
	}

	public void actualizarDatos(TblProducto pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();
		pr.getId();
		pr.getCantidadProducto();
		pr.getNombreProducto();
		pr.getPrecioProducto();
		pr.getTotalProducto();
		em.getTransaction().begin();
		em.merge(pr);
		em.flush();
		em.getTransaction().commit();
	}
	
	public void eliminarDatos(TblProducto pr) {
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("CRUD-JPA-HIBERNATE");
		em = emf.createEntityManager();
		pr = em.getReference(TblProducto.class, pr.getId());
		em.getTransaction().begin();
		em.remove(pr);
		em.flush();
		em.getTransaction().commit();
	}
}
