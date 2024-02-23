package com.onepoint.modulechiffrement.dto;

import java.util.HashMap;
import java.util.Map;

public class Courrier {

	private final String codePostal;
	private final String ville;
	private final String pays;
	private final String destinataire;
	private final String expediteur;
	private final String contenu;
	private final String adresses;
	private final String personnes;
	private final int lotPostal;
	private final Map<Integer, String> metadata;
	private final String dateTraitement;

	public Courrier(String codePostal,
	                String ville,
	                String pays,
	                String destinataire,
	                String expediteur,
	                String contenu,
	                String adresses,
	                String personnes,
	                int lotPostal,
	                Map<Integer, String> metadata, String dateTraitement) {
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.destinataire = destinataire;
		this.expediteur = expediteur;
		this.contenu = contenu;
		this.adresses = adresses;
		this.personnes = personnes;
		this.lotPostal = lotPostal;
		this.metadata = metadata;
		this.dateTraitement = dateTraitement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getVille() {
		return ville;
	}

	public String getPays() {
		return pays;
	}

	public String getDestinataire() {
		return destinataire;
	}

	public String getExpediteur() {
		return expediteur;
	}

	public String getContenu() {
		return contenu;
	}

	public String getAdresses() {
		return adresses;
	}

	public String getPersonnes() {
		return personnes;
	}

	public int getLotPostal() {
		return lotPostal;
	}

	public Map<Integer, String> getMetadata() {
		return metadata;
	}

	@Override
	public String toString() {
		return "Courrier{" +
				"codePostal='" + codePostal + '\'' +
				", ville='" + ville + '\'' +
				", pays='" + pays + '\'' +
				", destinataire='" + destinataire + '\'' +
				", expediteur='" + expediteur + '\'' +
				", contenu='" + contenu + '\'' +
				", adresses='" + adresses + '\'' +
				", personnes='" + personnes + '\'' +
				", lotPostal=" + lotPostal +
				", metadata=" + metadata +
				", dateTraitement='" + dateTraitement + '\'' +
				'}';
	}

}
