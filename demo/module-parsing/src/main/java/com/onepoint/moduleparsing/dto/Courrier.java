package com.onepoint.moduleparsing.dto;

import java.util.ArrayList;
import java.util.List;

public class Courrier {

	private final int id;
	private final String codePostal;
	private final String ville;
	private final String pays;
	private final String destinataire;
	private final String expediteur;
	private final String contenu;
	private final List<Adresse> adresses = new ArrayList<>();
	private final List<Personne> personnes = new ArrayList<>();
	private final List<Metadonnee> metadonnees = new ArrayList<>();
	private final int lotPostal;
	private String dateReception;

	public Courrier(int id,
	                String codePostal,
	                String ville,
	                String pays,
	                String destinataire,
	                String expediteur,
	                String contenu,
	                int lotPostal) {
		this.id = id;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.destinataire = destinataire;
		this.expediteur = expediteur;
		this.contenu = contenu;
		this.lotPostal = lotPostal;
	}

	public void addAdresse(Adresse adresse) {
		this.adresses.add(adresse);
	}

	public void addPersonne(Personne personne) {
		this.personnes.add(personne);
	}

	public void setDateReception(String date) {
		this.dateReception = date;
	}

	public void addMetadonnee(Metadonnee metadonnee) {
		this.metadonnees.add(metadonnee);
	}

	public String getCodePostal() {
		return codePostal;
	}

}
