package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.entity.LotPostal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ParsingService {

	private static final int MAX_METADATA = 300;
	private final ParsingCourriers parsingCourriers;
	private static final Logger LOGGER = LoggerFactory.getLogger(ParsingService.class);

	public ParsingService(ParsingCourriers parsingCourriers) {
		this.parsingCourriers = parsingCourriers;
	}

	public void run() {
		LotPostal lotPostal = parsingCourriers.parseLotPostal();
		LOGGER.info("Début du parsing des métadonnées");
		lotPostal.getCourriers().forEach(c -> ParsingMetadata.parseMetadata(c, MAX_METADATA));
		lotPostal.getCourriers().forEach(DateUpdateService::update);
		CsvWriter.save(lotPostal);
		LOGGER.info("Traitement terminé le : {}", LocalDate.now());
	}

}
