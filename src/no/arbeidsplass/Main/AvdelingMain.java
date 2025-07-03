package no.arbeidsplass.Main;

import no.arbeidsplass.DAO.AnsattDAO;
import no.arbeidsplass.DAO.AvdelingDAO;
import no.arbeidsplass.entiteter.Ansatt;
import no.arbeidsplass.entiteter.Avdeling;

public class AvdelingMain {
	private static AvdelingDAO avdelingDAO = new AvdelingDAO();
	private static AnsattDAO ansattDAO = new AnsattDAO();
	
	public static void main(String args[]) {
		
		System.out.println("-----------------------------------------------------");
		Avdeling avdeling2 = avdelingDAO.finnAvdelingMedId(2);
		System.out.println("Avdeling med avdeling_id = 2: " + "\n" + avdeling2);
		System.out.println("-----------------------------------------------------");
		
		
		Ansatt ansattMedId5 = ansattDAO.finnAnsattMedId(5);
//		avdelingDAO.byttAvdeling(ansattMedId5, 3);
		
		
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Prøver å bytte avdeling på en sjef");
		Ansatt AnsattMedId1 = ansattDAO.finnAnsattMedId(1);
		System.out.println("Sjef: " + AnsattMedId1);
		System.out.println("Bytt avdeling til 2:");
		avdelingDAO.byttAvdeling(AnsattMedId1, 2);;
		System.out.println("--------------------------------------------------------------------------");
		
		
		
		avdelingDAO.ansatteIAvdeling(1);
		
//		avdelingDAO.lagreAvdeling("Paradis", ansattDAO.finnAnsattMedId(4));
	}
}
