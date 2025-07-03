package no.arbeidsplass.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import no.arbeidsplass.entiteter.Prosjekt;
import no.arbeidsplass.entiteter.Prosjektdeltagelse;

public class ProsjektDAO {
	
	private static ProsjektdeltagelseDAO prosjektdeltagelseDAO = new ProsjektdeltagelseDAO();
	
	private EntityManagerFactory emf
	= Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	
	public Prosjekt finnProsjektMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Prosjekt.class, id);
		} finally {
			em.close();
		}
	}
	
	
	public void lagreProsjekt(Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Prosjekt prosjekt = em.find(Prosjekt.class, p.getProsjekt_id());
			em.persist(prosjekt);
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public void slettProsjekt(Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Prosjekt prosjekt = em.find(Prosjekt.class, p.getProsjekt_id());
			em.remove(prosjekt);
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public void utskriftAvProsjektMedId(int id) {
		Prosjekt p = finnProsjektMedId(id);
		List<Prosjektdeltagelse> PD = prosjektdeltagelseDAO.finnAlleProsjektdeltagereMedId(id);
		int totalTimer = prosjektdeltagelseDAO.totalTimerForProsjektMedId(id);
		
		System.out.println("Prosjekt " + id + ":");
		System.out.println(p);
		
		System.out.println("Deltagere: ");
		System.out.println(PD.toString());
		
		System.out.println("Total arbeidstimer for prosjektet = " + totalTimer);
		
		
	}
	
}
