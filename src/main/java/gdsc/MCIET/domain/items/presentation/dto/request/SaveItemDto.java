package gdsc.MCIET.domain.items.presentation.dto.request;

import gdsc.MCIET.domain.items.domain.ItemCategory;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SaveItemDto {

    private String email;
    private String name;
    private LocalDate expirationDate;
    private ItemCategory itemCategory;

    public SaveItemDto(String email, String name, LocalDate expirationDate, ItemCategory itemCategory){
        this.email = email;
        this.name = name;
        this.expirationDate = expirationDate;
        this.itemCategory = itemCategory;
    }
}
