package fr.onepoint.demo.modulereporting;

import fr.onepoint.demo.model.Courrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourrierRepository extends JpaRepository<Courrier, Long> {

	List<Courrier> getByVille(String ville);

}
