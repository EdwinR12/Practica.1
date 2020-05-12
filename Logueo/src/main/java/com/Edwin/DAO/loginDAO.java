package com.Edwin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Edwin.model.Logueo;


public class loginDAO {
	
public List<Logueo> ingresarUser(Logueo user){
	
	List<Logueo> usuario = new ArrayList ();
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		usuario = em.createQuery("from Logueo as u where u.usuario ='"+user.getUsuario()+"'and u.password= '"+user.getPassword()+"'").getResultList();
		em.getTransaction().commit();
		
		for (Logueo datosids: usuario) {
			user.setIdlogueo(datosids.getIdlogueo());
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e+"TIENES UN ERROR");
	}
	
	return usuario;
}

public List<Logueo> registrolista(){
	
	List<Logueo> listaL = new ArrayList<>();
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	try {
		em.getTransaction().begin();
		
		listaL = em.createQuery("from Logueo").getResultList();
		em.getTransaction().commit();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
	
	return listaL;
}

public void agregarDatos(Logueo l) {
	
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	em.getTransaction().begin();
	em.persist(l);
	em.flush();
	em.getTransaction().commit();
}
}
