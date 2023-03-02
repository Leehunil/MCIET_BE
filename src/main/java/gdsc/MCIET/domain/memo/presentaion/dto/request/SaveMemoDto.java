package gdsc.MCIET.domain.memo.presentaion.dto.request;

import lombok.Getter;

@Getter
public class SaveMemoDto {

    private String email;
    private String contents;

    public SaveMemoDto(String email, String contents){
        this.email = email;
        this.contents = contents;
    }
}
