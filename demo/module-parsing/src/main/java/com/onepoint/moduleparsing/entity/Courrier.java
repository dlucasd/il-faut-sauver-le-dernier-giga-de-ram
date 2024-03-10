package com.onepoint.moduleparsing.entity;

import com.onepoint.moduleparsing.dto.Metadonnee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Transient
	private List<Metadonnee> metadata = new ArrayList<>();

	@Transient
	private String receptionDate;

	public String getCp() {
		return this.codePostal;
	}

	public String getContenu() {
		return this.contenu;
	}

	public List<Metadonnee> getMetadata() {
		return metadata;
	}

	public void setReceptionDate(String receptionDate) {
		this.receptionDate = receptionDate;
	}

}
