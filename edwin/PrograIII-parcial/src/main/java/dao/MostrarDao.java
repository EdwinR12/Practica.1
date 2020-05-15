package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Consul;
import model.Usuar;

public class MostrarDao {
	
	public List<Consul> mostrar() {
		List<Consul> listad = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("PrograIII");
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			listad = em.createQuery("SELECT c.nombre, c.apellido, c.id FROM Consulta as c").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listad;
	}
	
	
		public void Eliminar(Consul gr) {
			EntityManager em;
			EntityManagerFactory emf;
			emf = Persistence.createEntityManagerFactory("PrograIII");
			em = emf.createEntityManager();
			gr = em.getReference(Consul.class,gr.getId());
	        em.getTransaction().begin();
			em.remove(gr);
			em.flush();
			em.getTransaction().commit();
			
		}
}
