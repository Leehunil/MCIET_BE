package gdsc.MCIET.domain.memo.domain;

import gdsc.MCIET.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String contents;
    private Boolean checkBox;

    @Builder
    public Memo(User user, String contents, Boolean checkBox){
        this.user = user;
        this.contents = contents;
        this.checkBox = checkBox;
    }

    public void updateCheck(Boolean checkBox){
        this.checkBox = checkBox;
    }
}
