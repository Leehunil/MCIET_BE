package gdsc.MCIET.global.open;

import gdsc.MCIET.domain.cuisine.service.CuisineService;
import gdsc.MCIET.domain.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final CuisineService cuisineService;
    private final RecipeService recipeService;

//    @GetMapping()
//    public ResponseEntity saveOpenApi(){
//
//    }

}
