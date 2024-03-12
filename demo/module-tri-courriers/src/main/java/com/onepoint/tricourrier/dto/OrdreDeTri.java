package com.onepoint.tricourrier.dto;

import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;

import java.util.List;
import java.util.regex.Pattern;

public class OrdreDeTri {

	private final LotPostal lotPostal;
	private final Pattern codePostalPattern;

	public OrdreDeTri(LotPostal lotPostal, String codePostalRegex) {
		this.lotPostal = lotPostal;
		this.codePostalPattern = Pattern.compile(codePostalRegex);
	}

	public List<Courrier> getCourriers() {
		return this.lotPostal.getCourriers().stream()
		                     .filter(courrier -> codePostalPattern.matcher(courrier.getCp()).matches())
		                     .toList();
	}
}
