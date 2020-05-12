package com.Edwin.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Edwin.model.TbHistorial;

import net.bytebuddy.asm.Advice.Return;

public class historialDAO {

public void agregardatoshistorial(TbHistorial His) {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	em.getTransaction().begin();
	em.persist(His);
	em.flush();
	em.getTransaction().commit();
}

public List<Object> Historial()  {
	List<Object> HISTO= new ArrayList();
	
	EntityManager em;
	EntityManagerFactory emf;
	
	emf = Persistence.createEntityManagerFactory("Logueo");
	em = emf.createEntityManager();
	
	try {
		
		em.getTransaction().begin();
		HISTO = em.createQuery("SELECT his.idHistorial, his.Logueo.idlogueo, his.fecha, \"\r\n" + 
				"					+\"usu.nombres_Usuario, usu.apellidos_Usuario\"\r\n" + 
				"					+\" FROM TbHistorial AS his \"\r\n" + 
				"					+\"INNER JOIN Logueo AS usu ON usu.idlogueo = his.Logueo.idlogueo").getResultList();
		em.getTransaction().commit();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e+"Error");
	}
	return HISTO;
}

}
