package fr.onepoint.demo.modulereporting;

import fr.onepoint.demo.model.Courrier;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class ReportingRunner {

	private CourrierRepository courrierRepository;

	public ReportingRunner(CourrierRepository courrierRepository) {
		this.courrierRepository = courrierRepository;
	}

	public void runForestRun() {
		System.out.println("ETAPE 1 - Récupération des données en bases de données...");
		List<Courrier> courriers = courrierRepository.getByVille("Philadelphie");

		System.out.println("ETAPE 2 - Écriture du reporting dans le fichier CSV...");
		writeCSV(courriers);
	}

	private void writeCSV(List<Courrier> courriers) {
		try (FileWriter writer = new FileWriter("courriers.csv")) {
			courriers.forEach(courrier -> {
				try {
					writer.write(courrier.getVille() + "," + courrier.getDestinataire() + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
