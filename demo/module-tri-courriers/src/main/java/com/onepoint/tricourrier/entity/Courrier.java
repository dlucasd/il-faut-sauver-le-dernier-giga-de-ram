package com.onepoint.tricourrier.entity;

import java.util.ArrayList;
import java.util.List;

public class Courrier {

	private int id;
	private String codePostal;
	private String ville;
	private String pays;
	private String destinataire;
	private String expediteur;
	private String contenu;
	private List<Adresse> adresses = new ArrayList<>();
	private List<Personne> personnes = new ArrayList<>();
	private int lotPostal;

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

	public void addAdress(Adresse adresse) {
		this.adresses.add(adresse);
	}

	public void addPersonne(Personne personne) {
		this.personnes.add(personne);
	}

	public String getCp() {
		return this.codePostal;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getVille() {
		return ville;
	}

}
