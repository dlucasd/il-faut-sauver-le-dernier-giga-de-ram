package com.onepoint.tricourrier.repository;

import com.onepoint.tricourrier.entity.Adresse;
import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;
import com.onepoint.tricourrier.entity.Personne;

import java.util.List;
import java.util.stream.IntStream;

public class LotPostalRepository {

	public static LotPostal findAll() {
		List<Courrier> courriers = IntStream.range(0, 10000000)
		                                    .parallel()
		                                    .mapToObj(index -> {
			                                    Courrier courrier = new Courrier(index, "29900",
			                                                                     "Concarneau",
			                                                                     "France",
			                                                                     "toto",
			                                                                     "titi",
			                                                                     "contenu",
			                                                                     1);
			                                    courrier.addAdress(new Adresse(1L, 29900,
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
		return new LotPostal(1, courriers);
	}

}
