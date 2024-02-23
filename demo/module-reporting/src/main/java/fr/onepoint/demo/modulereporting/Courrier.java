package fr.onepoint.demo.modulereporting;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity
public class Courrier {

	@Id
	private Long id;
	private Integer codePostal;
	private String ville;
	private String pays;
	private String destinataire;
	private String expediteur;
	private String contenu;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private Set<Adresse> adresses;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private Set<Personne> personnes;

	@Override
	public String toString() {
		return id + "," + codePostal + "," + ville + "," + pays + "," + destinataire + "," + expediteur + "," + contenu + "\n";
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

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
