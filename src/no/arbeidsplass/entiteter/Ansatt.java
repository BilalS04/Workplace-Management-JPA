package no.arbeidsplass.entiteter;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ansatt_id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansatt_dato;
	private String stilling;
	private Integer maanedslonn;
	
	@ManyToOne
    @JoinColumn(name = "avdeling_id")
    private Avdeling avdeling;
	
	@OneToMany(mappedBy = "ansatt", fetch = FetchType.EAGER)
    private List<Prosjektdeltagelse> deltagelser;
	
	public Ansatt() {}
	
	public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate ansatt_dato, String stilling, Integer maanedslonn, Avdeling avdeling) {
	    this.brukernavn = brukernavn;
	    this.fornavn = fornavn;
	    this.etternavn = etternavn;
	    this.ansatt_dato = ansatt_dato;
	    this.stilling = stilling;
	  	this.maanedslonn = maanedslonn;
	  	this.avdeling = avdeling;
	}

	public Integer getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(Integer maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public Integer getAnsatt_id() {
		return ansatt_id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}

	@Override
	public String toString() {
		return "Ansatt [ansatt_id=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", ansatt_dato=" + ansatt_dato + ", stilling=" + stilling + ", maanedslonn=" + maanedslonn
				+ ", avdeling_id=" + avdeling.getAvdeling_id() + "]" + "\n";
	}
	
}
