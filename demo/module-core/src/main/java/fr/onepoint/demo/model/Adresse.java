package fr.onepoint.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Adresse {

	@Id
	private Long id;
	private Integer codePostal;
	private String ville;
	private String pays;
	private String ligne1;
	private String ligne2;
	private String ligne3;
	private String ligne4;
	private String ligne5;
	private String ligne6;
	@ManyToOne
	private Courrier courrier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getLigne1() {
		return ligne1;
	}

	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}

	public String getLigne2() {
		return ligne2;
	}

	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}

	public String getLigne3() {
		return ligne3;
	}

	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}

	public String getLigne4() {
		return ligne4;
	}

	public void setLigne4(String ligne4) {
		this.ligne4 = ligne4;
	}

	public String getLigne5() {
		return ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}

	public String getLigne6() {
		return ligne6;
	}

	public void setLigne6(String ligne6) {
		this.ligne6 = ligne6;
	}

	public Courrier getCourrier() {
		return courrier;
	}

	public void setCourrier(Courrier courrier) {
		this.courrier = courrier;
	}

}
