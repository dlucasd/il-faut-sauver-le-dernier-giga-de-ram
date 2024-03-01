package com.onepoint.modulechiffrement.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CourrierMapper {

	private static final int CP_INDEX = 0;
	private static final int VILLE_INDEX = 1;
	private static final int PAYS_INDEX = 2;
	private static final int DESTINATAIRE_INDEX = 3;
	private static final int EXPEDITEUR_INDEX = 4;
	private static final int CONTENU_INDEX = 5;
	private static final int ADRESSE_INDEX = 6;
	private static final int PERSONNE_INDEX = 7;
	private static final int LOT_POSTAL_INDEX = 8;
	private static final int START_METADATA_INDEX = 9;
	private static final int END_METADATA_INDEX = 308;
	private static final String SEMICOLON = ";";

	public Courrier mapLineToDto(String line) {
		String[] fields = line.split(SEMICOLON);
		Map<Integer, String> metadata = new HashMap<>();
		for (int i = START_METADATA_INDEX; i <= END_METADATA_INDEX; i++) {
			metadata.put(i, fields[i]);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
		String today = simpleDateFormat.format(new Date());
		return new Courrier(fields[CP_INDEX],
		                    fields[VILLE_INDEX],
		                    fields[PAYS_INDEX],
		                    fields[DESTINATAIRE_INDEX],
		                    fields[EXPEDITEUR_INDEX],
		                    fields[CONTENU_INDEX],
		                    fields[ADRESSE_INDEX],
		                    fields[PERSONNE_INDEX],
		                    Integer.parseInt(fields[LOT_POSTAL_INDEX]),
		                    metadata,
		                    today);
	}

}
