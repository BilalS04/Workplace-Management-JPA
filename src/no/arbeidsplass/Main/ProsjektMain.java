package no.arbeidsplass.Main;

import java.util.List;

import no.arbeidsplass.DAO.ProsjektDAO;
import no.arbeidsplass.entiteter.Prosjekt;
import no.arbeidsplass.entiteter.Prosjektdeltagelse;

public class ProsjektMain {
	private static ProsjektDAO prosjektDAO = new ProsjektDAO();
	
	public static void main(String args[]) {
		
		System.out.println("-----------------------------------------------");
		Prosjekt prosjektId1 = prosjektDAO.finnProsjektMedId(1);
		System.out.println(prosjektId1);
		System.out.println("-----------------------------------------------");
		
		
		
		List<Prosjektdeltagelse> PD4 = null;
		Prosjekt prosjekt4 = new Prosjekt("Suits", "Lage sesong 10", PD4);
//		prosjektDAO.lagreProsjekt(prosjekt4);
		
		
		
		
		System.out.println("-----------------------------------------------");
		prosjektDAO.utskriftAvProsjektMedId(1);
		System.out.println("-----------------------------------------------");
		
		
				
	}
}
