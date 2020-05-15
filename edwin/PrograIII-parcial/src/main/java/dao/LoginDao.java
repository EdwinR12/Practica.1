package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuar;

public class LoginDao {
	public List<Usuar> Login(Usuar u) {
		List<Usuar> listads = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("PrograIII");
		em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			listads = em.createQuery("FROM Usuario AS u where u.nombre='"+u.getNombre()+"' and u.contrasenia='"+u.getContrasenia()+"'").getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		return listads;
	}
}
