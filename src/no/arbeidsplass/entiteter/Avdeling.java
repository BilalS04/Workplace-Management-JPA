package no.arbeidsplass.entiteter;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer avdeling_id;
	private String navn;
	
	@OneToOne
    @JoinColumn(name = "sjef_id")
    private Ansatt sjef;
	
	 @OneToMany(mappedBy = "avdeling")
	 private List<Ansatt> ansatte;

	
	
	public Avdeling() {}
	
	public Avdeling(String navn, Ansatt sjef) {
        this.navn = navn;
        this.sjef = sjef;
    }

	public Integer getAvdeling_id() {
        return avdeling_id;
    }

    public void setAvdeling_id(int avdeling_id) {
        this.avdeling_id = avdeling_id;
    }

    public String getNavn() {
        return navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Ansatt getSjef() {
        return sjef;
    }

    public void setSjef(Ansatt sjef) {
        this.sjef = sjef;
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }
    
    public void setAnsatte(List<Ansatt> ansatte) {
        this.ansatte = ansatte;
    }

	@Override
	public String toString() {
		return "Avdeling [avdeling_id=" + avdeling_id + ", navn=" + navn + ", sjef_id=" + sjef.getAnsatt_id() + "]" + "\n";
	}
	
}
