package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Courrier;
import com.onepoint.moduleparsing.repository.CourrierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParsingService {

	private static final int MAX_METADATA = 300;
	private static final Logger LOGGER = LoggerFactory.getLogger(ParsingService.class);

	public void runForestRun() {
		List<Courrier> courriers = CourrierRepository.findAll();
		LOGGER.info("Début du parsing des métadonnées");
		courriers.forEach(c -> MetadataService.getMetadata(c, MAX_METADATA));
		courriers.forEach(DateUpdateService::update);
		CsvWriter.save(courriers);
		LOGGER.info("Traitement terminé le : {}", LocalDate.now());
	}

}
