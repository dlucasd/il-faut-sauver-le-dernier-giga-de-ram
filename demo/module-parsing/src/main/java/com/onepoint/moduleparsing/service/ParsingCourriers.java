package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.entity.LotPostal;
import com.onepoint.moduleparsing.repository.LotPostalRepository;
import org.springframework.stereotype.Service;

@Service
public class ParsingCourriers {
	private final LotPostalRepository lotPostalRepository;

	public ParsingCourriers(LotPostalRepository lotPostalRepository) {
		this.lotPostalRepository = lotPostalRepository;
	}

	public LotPostal parseLotPostal() {
		return lotPostalRepository.findById(2L).orElseThrow(() -> new RuntimeException("Caught me !"));
	}
}
