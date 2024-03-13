package com.onepoint.tricourrier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class CsvWriter {

	private static final Logger LOGGER = LoggerFactory.getLogger(CsvWriter.class);

	private CsvWriter() {
	}

	public static void save(List<String> ligne) {
		LOGGER.info("Fichier csv créé : courriers_{}.csv", LocalDate.now());
	}

}
