package com.onepoint.javaperf.service;

import com.onepoint.javaperf.dto.OrdreDeTri;
import com.onepoint.javaperf.entity.Courrier;
import com.onepoint.javaperf.entity.LotPostal;
import com.onepoint.javaperf.repository.LotPostalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatchMeIfYouCan {

	private static final String MEMPHIS = "37501";
	private final LotPostalRepository lotPostalRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(CatchMeIfYouCan.class);

	public CatchMeIfYouCan(LotPostalRepository lotPostalRepository) {
		this.lotPostalRepository = lotPostalRepository;
	}

	public void runForestRun() {
		sortByCountry();
	}

	public void sortByCountry() {
		LotPostal lotPostal = lotPostalRepository.findById(1L).orElseThrow(() -> new RuntimeException("Caught me !"));
		OrdreDeTri ordreDeTri = new OrdreDeTri(lotPostal, "\\d{5}");
		processPlisAsList(ordreDeTri);
		processPlisAsStream(ordreDeTri);
		processPlisAsParallelStream(ordreDeTri);
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

	private void processPlisAsStream(OrdreDeTri ordreDeTri) {
		LOGGER.info("Traitement d'un stream de {} plis...", ordreDeTri.getCourriersAsStream().count());
		String ligne = ordreDeTri.getCourriersAsStream()
		                         .sorted(Comparator.comparingInt(courrier -> Integer.parseInt(courrier.getCp())))
		                         .map(Courrier::getContenu)
		                         .collect(Collectors.joining(", "));
		LOGGER.debug("Ligne générée : {}", ligne);
		Optional<Courrier> courrierPourMemphis = ordreDeTri.getCourriersAsStream()
		                                              .filter(courrier -> MEMPHIS.equals(courrier.getCp()))
		                                              .findFirst();
		LOGGER.info("Un courrier pour Memphis {}", courrierPourMemphis.isPresent() ? "existe" : "n'existe pas");
	}

	private void processPlisAsParallelStream(OrdreDeTri ordreDeTri) {
		LOGGER.info("Traitement d'un stream de {} plis...", ordreDeTri.getCourriersAsParallelStream().count());
		String ligne = ordreDeTri.getCourriersAsParallelStream()
		                         .sorted(Comparator.comparingInt(courrier -> Integer.parseInt(courrier.getCp())))
		                         .map(Courrier::getContenu)
		                         .collect(Collectors.joining(", "));
		LOGGER.debug("Ligne générée : {}", ligne);
		Optional<Courrier> courrierPourMemphis = ordreDeTri.getCourriersAsParallelStream()
		                                              .filter(courrier -> MEMPHIS.equals(courrier.getCp()))
		                                              .findFirst();
		LOGGER.info("Un courrier pour Memphis {}", courrierPourMemphis.isPresent() ? "existe" : "n'existe pas");
	}

}
