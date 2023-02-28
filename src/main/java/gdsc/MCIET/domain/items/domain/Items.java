package gdsc.MCIET.domain.items.domain;

import gdsc.MCIET.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Items {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "items_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String name;
    private LocalDate expirationDate;

    @Builder
    public Items(User user, String name, LocalDate expirationDate){
        this.user = user;
        this.name = name;
        this.expirationDate = expirationDate;
    }
}
