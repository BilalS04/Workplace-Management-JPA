package no.arbeidsplass.entiteter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Prosjektdeltagelse {
	@Id
    @ManyToOne
    @JoinColumn(name = "ansatt_id", referencedColumnName = "ansatt_id")
    private Ansatt ansatt;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "prosjekt_id", referencedColumnName = "prosjekt_id")
    private Prosjekt prosjekt;
	
	private String rolle;

    private Integer arbeidstimer;
    
    public Prosjektdeltagelse() {}

	public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, String rolle, Integer arbeidstimer) {
		this.ansatt = ansatt;
		this.prosjekt = prosjekt;
		this.rolle = rolle;
		this.arbeidstimer = arbeidstimer;
	}

	public Ansatt getAnsatt() {
		return ansatt;
	}

	public void setAnsatt(Ansatt ansatt) {
		this.ansatt = ansatt;
	}

	public Prosjekt getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(Prosjekt prosjekt) {
		this.prosjekt = prosjekt;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public Integer getArbeidstimer() {
		return arbeidstimer;
	}

	public void setArbeidstimer(Integer arbeidstimer) {
		this.arbeidstimer = arbeidstimer;
	}
	

	@Override
	public String toString() {
		return "Prosjektdeltagelse [ansatt=" + ansatt.getFornavn() + ansatt.getEtternavn() + ", prosjekt_id=" + prosjekt.getProsjekt_id() + ", rolle=" + rolle
				+ ", antall_timer=" + arbeidstimer + "]" + "\n";
	}
	
	
    
    

}
