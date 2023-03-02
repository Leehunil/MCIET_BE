package gdsc.MCIET.domain.items.presentation.dto.response;

import gdsc.MCIET.domain.items.domain.Items;
import lombok.Getter;

@Getter
public class RecommendItemDto {

    private String name;

    public RecommendItemDto(Items items){
        this.name = items.getName();
    }
}
