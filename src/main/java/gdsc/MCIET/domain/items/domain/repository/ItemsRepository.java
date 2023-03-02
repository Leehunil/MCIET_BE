package gdsc.MCIET.domain.items.domain.repository;

import gdsc.MCIET.domain.items.domain.Items;
import gdsc.MCIET.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Long> {

    Items save(Items items);

    List<Items> findByUser(User user);
}
