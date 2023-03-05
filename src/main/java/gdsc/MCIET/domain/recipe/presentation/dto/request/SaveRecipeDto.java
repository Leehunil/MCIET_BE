package gdsc.MCIET.domain.recipe.presentation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveRecipeDto {

    private Long cuisineId;
    private String exposition;

    public SaveRecipeDto(Long cuisineId, String exposition){
        this.cuisineId =cuisineId;
        this.exposition = exposition;
    }
}
