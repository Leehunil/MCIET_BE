package gdsc.MCIET.domain.cuisine.domain;

import gdsc.MCIET.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cuisine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuisine_id")
    private Long id;

    private String title;
    private String ingredients;

    @Builder
    public Cuisine(String title, String ingredients){
        this.title = title;
        this.ingredients = ingredients;
    }
}
