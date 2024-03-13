package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Courrier;
import com.onepoint.moduleparsing.dto.Metadonnee;

public class MetadataService {

	private MetadataService(){}

	public static void getMetadata(Courrier courrier, int amount) {
		for (int i = 0; i < amount; i++){
			courrier.addMetadonnee(new Metadonnee(i, "Métadonnée n°" + i));
		}
	}
}
