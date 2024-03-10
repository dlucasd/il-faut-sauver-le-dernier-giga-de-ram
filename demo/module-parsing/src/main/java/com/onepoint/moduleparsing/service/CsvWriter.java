package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.entity.LotPostal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvWriter {
	private static final Logger LOGGER = LoggerFactory.getLogger(CsvWriter.class);

	private CsvWriter(){}

	public static void save(LotPostal lotPostal) {
		LOGGER.info("Fichier csv créé : lot_postal_{}.csv", lotPostal.getId());
	}

}
