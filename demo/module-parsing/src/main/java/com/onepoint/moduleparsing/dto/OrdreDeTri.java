package com.onepoint.moduleparsing.dto;

import com.onepoint.moduleparsing.dto.Courrier;
import com.onepoint.moduleparsing.dto.LotPostal;

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
		                     .filter(courrier -> codePostalPattern.matcher(courrier.getCodePostal()).matches())
		                     .toList();
	}
}
