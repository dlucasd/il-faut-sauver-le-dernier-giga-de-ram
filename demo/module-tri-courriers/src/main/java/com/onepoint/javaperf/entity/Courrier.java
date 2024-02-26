package com.onepoint.javaperf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
public class Courrier {

	@Id
	private Long id;
	@Column(name = "code_postal")
	private String codePostal;
	private String ville;
	private String pays;
	private String destinataire;
	private String expediteur;
	private String contenu;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	@Fetch(FetchMode.SUBSELECT)
	private List<Adresse> adresses;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	@Fetch(FetchMode.SUBSELECT)
	private List<Personne> personnes;
	@Column(name = "lot_postal")
	private int lotPostal;

	public String getCp() {
		return this.codePostal;
	}

	public String getContenu() {
		return this.contenu;
	}

}
