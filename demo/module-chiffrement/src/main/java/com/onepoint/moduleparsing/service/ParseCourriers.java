package com.onepoint.moduleparsing.service;

import com.onepoint.moduleparsing.dto.Courrier;
import com.onepoint.moduleparsing.dto.CourrierMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParseCourriers {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParseCourriers.class);
	private static final String COURRIERS_CSV = "courriers.csv";

	public void daVinciRun() {
		parseCsv();
	}

	private void parseCsv() {
		CourrierMapper courrierMapper = new CourrierMapper();
		List<Courrier> courriers = new ArrayList<>();
		InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(COURRIERS_CSV);
		if (resourceAsStream != null) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))) {
				String line;
				while ((line = br.readLine()) != null) {
					courriers.add(courrierMapper.mapLineToDto(line));
				}
			} catch (IOException e) {
				LOGGER.error("ouch", e);
			}
		}
	}
}
