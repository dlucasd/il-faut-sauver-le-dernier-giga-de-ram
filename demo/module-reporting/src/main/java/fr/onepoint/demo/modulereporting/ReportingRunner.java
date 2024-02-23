package fr.onepoint.demo.modulereporting;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Component
public class ReportingRunner {

	private CourrierRepository courrierRepository;
	private final EntityManager entityManager;

	public ReportingRunner(CourrierRepository courrierRepository, EntityManager entityManager) {
		this.courrierRepository = courrierRepository;
		this.entityManager = entityManager;
	}

	@Transactional(readOnly = true)
	public void process() {
		System.out.println("Processing...");
//				List<Courrier> courriers = courrierRepository.findAllByCustomQueryAndList();
//				writeCSV(courriers);
		try (Stream<Courrier> courriers = courrierRepository.findAllByCustomQueryAndStream()) {
			writeCSV(courriers);
		}
	}

	private void writeCSV(Stream<Courrier> courriers) {
		System.out.println("Writing to courriers.csv ...");
		try (FileWriter writer = new FileWriter("courriers.csv")) {
			courriers.forEach(courrier -> {
				try {
					writer.write(courrier.toString());
					this.entityManager.detach(courrier);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeCSV(List<Courrier> courriers) {
		System.out.println("Writing to courriers.csv ...");
		try (FileWriter writer = new FileWriter("courriers.csv")) {
			courriers.forEach(courrier -> {
				try {
					writer.write(courrier.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
