package com.onepoint.tricourrier.service;

import com.onepoint.tricourrier.dto.OrdreDeTri;
import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;
import com.onepoint.tricourrier.repository.LotPostalRepository;
import fr.onepoint.demo.repository.RefPostalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TriCourrierService {

	private static final String PHILADELPHIE = "75009";
	private static final Logger LOGGER = LoggerFactory.getLogger(TriCourrierService.class);
	private final RefPostalRepository refPostalRepository;

	public TriCourrierService(RefPostalRepository refPostalRepository) {
		this.refPostalRepository = refPostalRepository;
	}

	@Transactional
	public void runForestRun() {
		LOGGER.info("Récupération des données...");
		LotPostal lotPostal = LotPostalRepository.findAll();
		OrdreDeTri ordreDeTri = new OrdreDeTri(lotPostal, "\\d{5}");
		processCourriers(ordreDeTri);
	}

	private void processCourriers(OrdreDeTri ordreDeTri) {
		LOGGER.info("Traitement d'une liste de {} courriers...", ordreDeTri.getCourriers().size());
		updateContenu(ordreDeTri);
		List<String> lignes = ordreDeTri.getCourriers().stream()
		                                .sorted(Comparator.comparingInt(courrier -> Integer.parseInt(courrier.getCp())))
		                                .map(Courrier::getContenu)
		                                .toList();
		Optional<Courrier> courrierPourPhiladelphie = ordreDeTri.getCourriers().stream()
		                                                        .filter(courrier -> PHILADELPHIE.equals(courrier.getCp()))
		                                                        .findFirst();
		courrierPourPhiladelphie.ifPresent(c -> CsvWriter.save(lignes));
	}

	private void updateContenu(OrdreDeTri ordreDeTri) {
		ordreDeTri.getCourriers().stream()
		          .filter(c -> c.getContenu() == null)
		          .forEach(c -> refPostalRepository.findByVille(c.getVille())
		                                           .findAny()
		                                           .ifPresent(ref -> c.setContenu(c.getVille() + " sans contenu.")));
	}

}
