package no.arbeidsplass.DAO;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.arbeidsplass.entiteter.Ansatt;
import no.arbeidsplass.entiteter.Avdeling;

public class AvdelingDAO {
	
	
	private EntityManagerFactory emf 
	= Persistence.createEntityManagerFactory("ansattPersistenceUnit");
	
	
	public Avdeling finnAvdelingMedId(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Avdeling.class, id);
		} finally {
			em.close();
		}
	}
	
	public void slettAvdeling(Avdeling a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		List<Ansatt> ansatte = listeAnsatteIAvdeling(a.getAvdeling_id());
		
		if(!ansatte.isEmpty()) {
			System.out.println("Kan ikke slette avdelingen på grunn av en ansatt jobber der!");
		} else {
			try {
				tx.begin();
				
				Avdeling aSlett = em.find(Avdeling.class, a.getAvdeling_id());
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
	
	
	public void ansatteIAvdeling(int avdeling_id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a where a.avdeling.avdeling_id = :avdeling_id", Ansatt.class);
			query.setParameter("avdeling_id", avdeling_id);
			List<Ansatt> ansatte = query.getResultList();
			
			Avdeling avdeling = finnAvdelingMedId(avdeling_id);
			Ansatt sjef = avdeling.getSjef();
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Ansatte i avdeling " + avdeling_id + ":");
			System.out.println("Sjef: " + sjef.getFornavn() + " " + sjef.getEtternavn());
			System.out.print(ansatte.toString());
			System.out.println("\n" + "--------------------------------------------------------------------------");
			
		} finally {
			em.close();
		}
	}
	
	
	public List<Ansatt> listeAnsatteIAvdeling(int avdeling_id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a where a.avdeling.avdeling_id = :avdeling_id", Ansatt.class);
			query.setParameter("avdeling_id", avdeling_id);
			return query.getResultList();
			
		} finally {
			em.close();
		}
	}
	
	
	public void byttAvdeling(Ansatt ansatt, int avdeling_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Avdeling ansattAvd = ansatt.getAvdeling();
		if(ansatt.getAnsatt_id().equals(ansattAvd.getSjef().getAnsatt_id())) {
			System.out.println("ERROR: Sjefen kan ikke bytte avdeling!");
		} else {
			try {
				tx.begin();
				Ansatt ans = em.find(Ansatt.class, ansatt.getAnsatt_id());
				Avdeling avd = em.find(Avdeling.class, avdeling_id);
				ans.setAvdeling(avd);
				
				tx.commit();
			} catch(Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				
			}
		}
	}
	
	
	public void lagreAvdeling(String navn, Ansatt sjef) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		if(sjef.getAnsatt_id().equals(sjef.getAvdeling().getSjef().getAnsatt_id())) {
			System.out.println("ERROR: Sjefen kan ikke bytte avdeling!");
		} else {
			Avdeling nyAvdeling = new Avdeling(navn, sjef);
			
			try {
				tx.begin();
				em.persist(nyAvdeling);
				tx.commit();
				
			} catch(Throwable e) {
				e.printStackTrace();
				tx.rollback();
			} finally {
				em.close();
			}
			byttAvdeling(sjef, nyAvdeling.getAvdeling_id());
		}	
	}
		
}
