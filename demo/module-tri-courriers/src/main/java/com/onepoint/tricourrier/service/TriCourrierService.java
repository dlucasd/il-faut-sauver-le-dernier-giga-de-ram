package com.onepoint.tricourrier.service;

import com.onepoint.tricourrier.dto.OrdreDeTri;
import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;
import com.onepoint.tricourrier.repository.LotPostalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TriCourrierService {

	private static final String MEMPHIS = "29900";
	private static final Logger LOGGER = LoggerFactory.getLogger(TriCourrierService.class);

	public void runForestRun() {
		sortByCountry();
	}

	public void sortByCountry() {
		LOGGER.info("Récupération des données...");
		LotPostal lotPostal = LotPostalRepository.findAll();
		OrdreDeTri ordreDeTri = new OrdreDeTri(lotPostal, "\\d{5}");
		processPlisAsList(ordreDeTri);
	}

	private void processPlisAsList(OrdreDeTri ordreDeTri) {
		LOGGER.info("Traitement d'une liste de {} plis...", ordreDeTri.getCourriers().size());
		String ligne = ordreDeTri.getCourriers().stream()
		                         .sorted(Comparator.comparingInt(courrier -> Integer.parseInt(courrier.getCp())))
		                         .map(Courrier::getContenu)
		                         .collect(Collectors.joining(", "));
		LOGGER.debug("Ligne générée : {}", ligne);
		Optional<Courrier> courrierPourMemphis = ordreDeTri.getCourriers().stream()
		                                              .filter(courrier -> MEMPHIS.equals(courrier.getCp()))
		                                              .findFirst();
		LOGGER.info("Un courrier pour Memphis {}", courrierPourMemphis.isPresent() ? "existe" : "n'existe pas");
	}

}
