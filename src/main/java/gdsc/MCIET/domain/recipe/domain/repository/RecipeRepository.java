package gdsc.MCIET.domain.recipe.domain.repository;

import gdsc.MCIET.domain.recipe.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
