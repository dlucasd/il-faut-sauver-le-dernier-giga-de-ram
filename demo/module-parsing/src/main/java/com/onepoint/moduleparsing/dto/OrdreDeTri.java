package com.onepoint.moduleparsing.dto;

import com.onepoint.moduleparsing.entity.Courrier;
import com.onepoint.moduleparsing.entity.LotPostal;

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

	public Stream<Courrier> getCourriersAsStream() {
		return this.lotPostal.getCourriers().stream()
		                     .filter(courrier -> codePostalPattern.matcher(courrier.getCp()).matches());
	}

}
