package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Metadonnee;
import com.onepoint.moduleparsing.entity.Courrier;

public class ParsingMetadata {

	private ParsingMetadata(){}

	public static void parseMetadata(Courrier courrier, int amount) {
		for (int i = 0; i < amount; i++){
			courrier.getMetadata().add(new Metadonnee(i, "Métadonnée n°" + i));
		}
	}
}
