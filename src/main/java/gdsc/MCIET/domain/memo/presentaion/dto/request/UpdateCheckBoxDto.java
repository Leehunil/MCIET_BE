package gdsc.MCIET.domain.memo.presentaion.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateCheckBoxDto {

    private Long memoId;
    private Boolean checkBox;

    public UpdateCheckBoxDto(Long memoId, Boolean checkBox){
        this.memoId = memoId;
        this.checkBox = checkBox;
    }
}
