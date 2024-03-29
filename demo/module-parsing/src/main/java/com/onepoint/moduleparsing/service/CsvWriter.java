package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Courrier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CsvWriter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CsvWriter.class);

	private CsvWriter() {
	}

	public static void save(List<Courrier> courriers) {
		LOGGER.info("Fichier csv créé : courriers_{}.csv", courriers.size());
	}

}
