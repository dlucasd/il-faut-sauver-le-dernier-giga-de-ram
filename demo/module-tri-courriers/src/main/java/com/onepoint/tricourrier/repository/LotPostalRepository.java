package com.onepoint.tricourrier.repository;

import com.onepoint.tricourrier.entity.Adresse;
import com.onepoint.tricourrier.entity.Courrier;
import com.onepoint.tricourrier.entity.LotPostal;
import com.onepoint.tricourrier.entity.Personne;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LotPostalRepository {

	public static LotPostal findAll() {
		Stream<Courrier> courriers1 = IntStream.range(0, 10000000)
		                                       .parallel()
		                                       .mapToObj(index -> {
			                                       Courrier courrier = new Courrier(index, "75009",
			                                                                        "Philadelphie",
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
		                                       });
		Stream<Courrier> courriers2 = IntStream.range(0, 10000)
		                                       .parallel()
		                                       .mapToObj(index -> {
			                                       Courrier courrier = new Courrier(index, "75009",
			                                                                        "Philadelphie",
			                                                                        "France",
			                                                                        "toto",
			                                                                        "titi",
			                                                                        null,
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
		                                       });

		return new LotPostal(1, Stream.concat(courriers1, courriers2).toList());
	}

}
