package gdsc.MCIET.domain.cuisine.domain.repository;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
}
