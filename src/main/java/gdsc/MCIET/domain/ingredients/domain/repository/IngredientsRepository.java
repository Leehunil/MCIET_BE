package gdsc.MCIET.domain.ingredients.domain.repository;

import gdsc.MCIET.domain.ingredients.domain.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
}
