package fr.onepoint.demo.repository;

import fr.onepoint.demo.model.RefPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface RefPostalRepository extends JpaRepository<RefPostal, Long> {

	Stream<RefPostal> findByVille(String ville);

}
