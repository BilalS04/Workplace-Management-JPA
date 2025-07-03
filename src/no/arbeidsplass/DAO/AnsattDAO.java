package no.arbeidsplass.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.arbeidsplass.entiteter.Ansatt;
import no.arbeidsplass.entiteter.Avdeling;

public class AnsattDAO {
	
	private static AvdelingDAO avdelingDAO = new AvdelingDAO();
	
	private EntityManagerFactory emf 
	= Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	
	
	public List<Ansatt> finnAlleAnsatte() {
		EntityManager em = emf.createEntityManager();
		
		try {
			String q = "select a from Ansatt as a";
			TypedQuery<Ansatt> query = em.createQuery(q, Ansatt.class);
			return query.getResultList();
			
		} finally {
			em.close();
		}
	}
	
	
	public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Ansatt.class, id);
		} finally {
			em.close();
		}
	}
	
	
	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a where a.brukernavn like :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			Ansatt a = query.getSingleResult();
			return a;
			
		} finally {
			em.close();
		}
	}
	
	
	public void lagreAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
			
		} catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
			em.close();
		}
	}
	
	
	public void lagreAnsattIAvdeling(Ansatt a, int avdeling_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Avdeling avdeling = avdelingDAO.finnAvdelingMedId(avdeling_id);
			a.setAvdeling(avdeling);
			em.persist(a);
			tx.commit();
			
		} catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
			em.close();
		}
	}
	
	
	public void slettAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		if(a.getAvdeling().getSjef().getAnsatt_id().equals(a.getAnsatt_id())) {
			System.out.println("ERROR: Ansatt er sjef hos en avdeling!");
		} else {
			try {
				tx.begin();
				
				Ansatt aSlett = em.find(Ansatt.class, a.getAnsatt_id());
				em.remove(aSlett);
				tx.commit();
			} catch(Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				em.close();
			}
		}
	}
	
	
	public void oppdaterMaanedslonn(int id, int nyLonn) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Ansatt a = em.find(Ansatt.class, id);
			a.setMaanedslonn(nyLonn);
			tx.commit();
			
		} catch(Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
	

}
