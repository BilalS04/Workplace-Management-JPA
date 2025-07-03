package no.arbeidsplass.entiteter;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prosjekt_id;
	private String prosjekt_navn;
	String beskrivelse;
	
	@OneToMany(mappedBy = "prosjekt", fetch = FetchType.EAGER)
    private List<Prosjektdeltagelse> deltagelser;
	
	public Prosjekt() {}

	public Prosjekt(String prosjekt_navn, String beskrivelse, List<Prosjektdeltagelse> deltagelser) {
		this.prosjekt_navn = prosjekt_navn;
		this.beskrivelse = beskrivelse;
		this.deltagelser = deltagelser;
	}

	public String getProsjekt_navn() {
		return prosjekt_navn;
	}

	public void setProsjekt_navn(String prosjekt_navn) {
		this.prosjekt_navn = prosjekt_navn;
	}

	public List<Prosjektdeltagelse> getDeltagelser() {
		return deltagelser;
	}

	public void setDeltagelser(List<Prosjektdeltagelse> deltagelser) {
		this.deltagelser = deltagelser;
	}

	public Integer getProsjekt_id() {
		return prosjekt_id;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjekt_id=" + prosjekt_id + ", prosjekt_navn=" + prosjekt_navn + ", beskrivelse="
				+ beskrivelse + ", deltagelser=" + deltagelser.size() + "]";
	}
	
	
}
