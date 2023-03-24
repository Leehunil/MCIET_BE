package gdsc.MCIET.domain.items.presentation.dto.response;

import gdsc.MCIET.domain.items.domain.Item;
import lombok.Getter;

@Getter
public class Show1DayDto {

    private String name;
    private String filePath;

    public Show1DayDto(Item item){
        this.name = item.getName();
        this.filePath = item.getFilePath();
    }
}
