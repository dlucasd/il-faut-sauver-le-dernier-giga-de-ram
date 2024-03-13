package com.onepoint.moduleparsing.repository;

import com.onepoint.moduleparsing.dto.Adresse;
import com.onepoint.moduleparsing.dto.Courrier;
import com.onepoint.moduleparsing.dto.LotPostal;
import com.onepoint.moduleparsing.dto.Personne;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CourrierRepository {

	private CourrierRepository() {
	}

	public static List<Courrier> findAll() {
		return IntStream.range(0, 2000000)
		                .parallel()
		                .mapToObj(index -> {
			                Courrier courrier = new Courrier(index, "29900",
			                                                 "Concarneau",
			                                                 "France",
			                                                 "toto",
			                                                 "titi",
			                                                 "contenu",
			                                                 1);
			                courrier.addAdresse(new Adresse(1L, 29900,
			                                               "Concarneau",
			                                               "France",
			                                               "ligne1",
			                                               "ligne2",
			                                               "ligne3",
			                                               "ligne4",
			                                               "ligne5",
			                                               "ligne6"));
			                courrier.addPersonne(new Personne(1L,
			                                                  "Valjean",
			                                                  "Jean"));
			                return courrier;
		                })
		                .toList();
	}

}
