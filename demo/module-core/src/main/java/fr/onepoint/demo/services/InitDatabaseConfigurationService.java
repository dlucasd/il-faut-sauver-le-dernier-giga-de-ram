package fr.onepoint.demo.services;

import fr.onepoint.demo.model.RefPostal;
import fr.onepoint.demo.repository.RefPostalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitDatabaseConfigurationService {

	private List<RefPostal> refPostal;

	public InitDatabaseConfigurationService(RefPostalRepository refPostalRepository) {
		refPostal = refPostalRepository.findAll();
	}

	public List<RefPostal> getRefPostal() {
		return refPostal;
	}

}
