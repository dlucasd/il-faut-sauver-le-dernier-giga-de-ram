package com.onepoint.tricourrier.dto;

import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class OrdreDeTri {

	private final LotPostal lotPostal;
	private final Pattern pattern;

	public OrdreDeTri(LotPostal lotPostal, String cpRegex) {
		this.lotPostal = lotPostal;
		this.pattern = Pattern.compile(cpRegex);
	}

	public List<Courrier> getCourriers() {
		return this.lotPostal.getCourriers().stream()
		                     .filter(courrier -> pattern.matcher(courrier.getCp()).matches())
		                     .toList();
	}

}
