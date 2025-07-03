package no.arbeidsplass.Main;

import java.util.List;

import no.arbeidsplass.DAO.AnsattDAO;
import no.arbeidsplass.DAO.ProsjektDAO;
import no.arbeidsplass.DAO.ProsjektdeltagelseDAO;
import no.arbeidsplass.entiteter.Ansatt;
import no.arbeidsplass.entiteter.Prosjektdeltagelse;

public class ProsjektdeltagelseMain {
	
	private static ProsjektdeltagelseDAO prosjektdeltagelseDAO = new ProsjektdeltagelseDAO();
	private static AnsattDAO ansattDAO = new AnsattDAO();
	private static ProsjektDAO prosjektDAO = new ProsjektDAO();
	
	public static void main(String args[]) {
		
		System.out.println("-------------------------------------------------------");
		Prosjektdeltagelse PD1 = prosjektdeltagelseDAO.finnProsjektdeltagelseMedId(1);
		System.out.println(PD1);
		System.out.println("-------------------------------------------------------");
		
		
		
		Ansatt nyA1 = ansattDAO.finnAnsattMedId(11);
		Ansatt nyA2 = ansattDAO.finnAnsattMedId(12);
		Ansatt nyA3 = ansattDAO.finnAnsattMedId(13);
		Prosjektdeltagelse PDA1 = new Prosjektdeltagelse(nyA1, prosjektDAO.finnProsjektMedId(1), "Kjøper", 45);
		Prosjektdeltagelse PDA2 = new Prosjektdeltagelse(nyA2, prosjektDAO.finnProsjektMedId(2), "Presenterer", 75);
		Prosjektdeltagelse PDA3 = new Prosjektdeltagelse(nyA3, prosjektDAO.finnProsjektMedId(3), "Kjøper", 45);
//		prosjektdeltagelseDAO.lagreProsjektdeltagelse(PDA1);
//		prosjektdeltagelseDAO.lagreProsjektdeltagelse(PDA2);
//		prosjektdeltagelseDAO.lagreProsjektdeltagelse(PDA3);
		
		
		Prosjektdeltagelse Ansatt1 = prosjektdeltagelseDAO.finnProsjektdeltagelseMedId(1);
//		prosjektdeltagelseDAO.leggTilTimer(Ansatt1, 10);
		
		
		
		List<Prosjektdeltagelse> PDMedId2 = prosjektdeltagelseDAO.finnAlleProsjektdeltagereMedId(2);
		System.out.println(PDMedId2.toString());
		
		
		
		System.out.println("-------------------------------------------------------");
		int totalTimerForProsjekt2 = prosjektdeltagelseDAO.totalTimerForProsjektMedId(2);
		System.out.println("Total arbeidstimer for prosjekt 2 = " + totalTimerForProsjekt2 + "timer");
		System.out.println("-------------------------------------------------------");
		
	}
}
