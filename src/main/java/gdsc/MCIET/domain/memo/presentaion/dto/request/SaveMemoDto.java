package gdsc.MCIET.domain.memo.presentaion.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveMemoDto {

    private String email;

    @NotNull
    private String contents;

    public SaveMemoDto(String email, String contents){
        this.email = email;
        this.contents = contents;
    }
}
