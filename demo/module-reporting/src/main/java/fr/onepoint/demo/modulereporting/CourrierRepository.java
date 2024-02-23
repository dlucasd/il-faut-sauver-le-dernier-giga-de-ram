package fr.onepoint.demo.modulereporting;

import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.jpa.HibernateHints.HINT_FETCH_SIZE;

@Repository
public interface CourrierRepository extends JpaRepository<Courrier, Long> {

	@Query("SELECT DISTINCT c FROM Courrier c "
			+ "LEFT JOIN FETCH c.adresses "
			+ "LEFT JOIN FETCH c.personnes ")
	@QueryHints(value = {
			@QueryHint(name = HINT_FETCH_SIZE, value = "10000")
	})
	Stream<Courrier> findAllByCustomQueryAndStream();

	@Query("SELECT DISTINCT c FROM Courrier c ")
	List<Courrier> findAllByCustomQueryAndList();
	@Query("SELECT new fr.onepoint.demo.modulereporting.CourrierDto(c.codePostal, c.ville) FROM Courrier c ")
	List<CourrierDto> findAllCourrierDto();

}
