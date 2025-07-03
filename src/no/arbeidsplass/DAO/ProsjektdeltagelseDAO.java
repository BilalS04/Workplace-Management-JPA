package no.arbeidsplass.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.arbeidsplass.entiteter.Prosjektdeltagelse;

public class ProsjektdeltagelseDAO {
	private static EntityManagerFactory emf =
	Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	
	public Prosjektdeltagelse finnProsjektdeltagelseMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Prosjektdeltagelse.class, id);
		} finally {
			em.close();
		}
	}
	
	public void lagreProsjektdeltagelse(Prosjektdeltagelse pd) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(pd);
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public void slettProsjektdeltagelse(Prosjektdeltagelse pd) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.remove(pd);
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public void leggTilTimer(Prosjektdeltagelse pd, int timer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Prosjektdeltagelse PD = em.find(Prosjektdeltagelse.class, pd.getAnsatt().getAnsatt_id());
			PD.setArbeidstimer(PD.getArbeidstimer() + timer);
			tx.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	
	public List<Prosjektdeltagelse> finnAlleProsjektdeltagereMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Prosjektdeltagelse> query = em.createQuery(
					"select p from Prosjektdeltagelse p where p.prosjekt.prosjekt_id = :id", Prosjektdeltagelse.class);
			query.setParameter("id", id);
			return query.getResultList();
			
		} finally {
			em.close();
		}
	}
	
	public int totalTimerForProsjektMedId(int id) {
		int timer = 0;
		List<Prosjektdeltagelse> PD = finnAlleProsjektdeltagereMedId(id);
		
		for(int i = 0; i < PD.size(); i++) {
			timer += ((Prosjektdeltagelse) PD.toArray()[i]).getArbeidstimer();
		}
		return timer;
	}

}
