package com.onepoint.javaperf.service;

import com.onepoint.javaperf.dto.OrdreDeTri;
import com.onepoint.javaperf.entity.LotPostal;
import com.onepoint.javaperf.repository.LotPostalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CatchMeIfYouCan {

	private final LotPostalRepository lotPostalRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(CatchMeIfYouCan.class);

	public CatchMeIfYouCan(LotPostalRepository lotPostalRepository) {
		this.lotPostalRepository = lotPostalRepository;
	}

	public void run(){
		sortByCountry("Pays1");
	}

	public void sortByCountry(String country) {
		LotPostal lotPostal = lotPostalRepository.findById(1L).orElseThrow(() -> new RuntimeException("Caught me !"));
		OrdreDeTri ordreDeTri = new OrdreDeTri(lotPostal, "\\d{5}");
		LOGGER.info("Traitement de {} plis...", ordreDeTri.getCourriers().size());
	}

}
