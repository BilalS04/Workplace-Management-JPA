package no.arbeidsplass.Main;

import java.time.LocalDate;
import java.util.List;

import no.arbeidsplass.DAO.AnsattDAO;
import no.arbeidsplass.DAO.AvdelingDAO;
import no.arbeidsplass.entiteter.Ansatt;
import no.arbeidsplass.entiteter.Avdeling;

public class AnsattMain {
	
	private static AnsattDAO ansattDAO = new AnsattDAO();
	private static AvdelingDAO avdelingDAO = new AvdelingDAO();
	public static void main(String args[]) {
		
		System.out.println("--------------------------------------------------------------------------");
		List<Ansatt> list = ansattDAO.finnAlleAnsatte();
		System.out.println(list.toString());
		System.out.println("--------------------------------------------------------------------------");
		
		
		
		System.out.println("--------------------------------------------------------------------------");
		Ansatt AnsattMedId2 = ansattDAO.finnAnsattMedId(2);
		System.out.println("Ansatt med ansatt_id = 2: " + AnsattMedId2);
		System.out.println("--------------------------------------------------------------------------");
		
		
	
		LocalDate ansattDato = LocalDate.of(2021, 1, 7);
		Avdeling avdeling1 = avdelingDAO.finnAvdelingMedId(1);
		Ansatt nyAnsatt = new Ansatt("tas", "Thea", "Saher", ansattDato, "Assistent", 10000, avdeling1);
//		ansattDAO.lagreAnsatt(nyAnsatt);
		
		
		
		Ansatt Vegard = ansattDAO.finnAnsattMedId(3);
//		ansattDAO.slettAnsatt(Vegard);
		
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Prøver å slette en sjef");
		Ansatt AnsattMedId1 = ansattDAO.finnAnsattMedId(1);
		System.out.println("Sjef: " + AnsattMedId1);
		System.out.println("Slett:");
		ansattDAO.slettAnsatt(AnsattMedId1);
		System.out.println("--------------------------------------------------------------------------");
		
		
//		ansattDAO.oppdaterMaanedslonn(7, 32000);
		
		
		
		System.out.println("--------------------------------------------------------------------------");
		Ansatt AMedBNbsa = ansattDAO.finnAnsattMedBrukernavn("bsa");
		System.out.println("Ansatt med brukernavn = bsa: " + "\n" + AMedBNbsa);
		System.out.println("--------------------------------------------------------------------------");
		
		
		
		LocalDate ansattDato1 = LocalDate.of(2022, 3, 1);
		Ansatt nyAnsatt2 = new Ansatt("rba", "Robin", "Band", ansattDato1, "Gamer", 12000, null);
//		ansattDAO.lagreAnsattIAvdeling(nyAnsatt2, 2);
		
		
		
		
	}

}