package gdsc.MCIET.domain.ingredients.domain;

import gdsc.MCIET.domain.cuisine.domain.Cuisine;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
 public class Ingredients {
                                       
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredients_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    private String name;
    private Integer quantity;

    @Builder
    public Ingredients(Cuisine cuisine, String name, Integer quantity){
        this.cuisine = cuisine;
        this.name = name;
        this.quantity = quantity;
    }
}
