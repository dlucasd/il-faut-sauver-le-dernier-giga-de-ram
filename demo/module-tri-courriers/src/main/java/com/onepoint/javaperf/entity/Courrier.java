package com.onepoint.javaperf.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Set;

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
	private Set<Adresse> adresses;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
	private Set<Personne> personnes;
	@Column(name = "lot_postal")
	private int lotPostal;

	public String getCp() {
		return this.codePostal;
	}

}
