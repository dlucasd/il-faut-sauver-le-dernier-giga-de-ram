package com.onepoint.javaperf.dto;

import com.onepoint.javaperf.entity.Courrier;
import com.onepoint.javaperf.entity.LotPostal;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
