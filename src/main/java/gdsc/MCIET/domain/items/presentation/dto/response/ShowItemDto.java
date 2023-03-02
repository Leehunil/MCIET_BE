package gdsc.MCIET.domain.items.presentation.dto.response;

import gdsc.MCIET.domain.items.domain.ItemCategory;
import gdsc.MCIET.domain.items.domain.Items;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ShowItemDto {

    private String name;
    private LocalDate expirationDate;
    private ItemCategory itemCategory;

    public ShowItemDto(Items items){
        this.name = items.getName();
        this.expirationDate = items.getExpirationDate();
        this.itemCategory = items.getItemCategory();
    }
}
