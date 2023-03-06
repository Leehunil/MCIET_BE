package gdsc.MCIET.global.init;

import gdsc.MCIET.domain.items.domain.ItemCategory;
import gdsc.MCIET.domain.items.domain.Items;
import gdsc.MCIET.domain.memo.domain.Memo;
import gdsc.MCIET.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@Component  // 스프링빈 등록
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor // 생성자 주입
    static class InitService {

        private final EntityManager em;


        public void dbInit1() {

            User user1 = new User("user1@gmail.com", "user1");
            User user2 = new User("user2@gmail.com", "user2");
            User user3 = new User("user3@gmail.com", "user3");
            em.persist(user1);
            em.persist(user2);
            em.persist(user3);

            Items item1 = new Items(user1, "item1", LocalDate.now(), ItemCategory.MEAT);
            Items item2 = new Items(user1, "item2", LocalDate.now(), ItemCategory.BEVERAGE);
            Items item3 = new Items(user1, "item3", LocalDate.now(), ItemCategory.FROZENFOOD);
            em.persist(item1);
            em.persist(item2);
            em.persist(item3);

            Memo memo1 = new Memo(user1, "양파1",false);
            Memo memo2 = new Memo(user1, "양파2", false);
            Memo memo3 = new Memo(user1, "양파3", false);
            em.persist(memo1);
            em.persist(memo2);
            em.persist(memo3);

            em.flush();

            em.clear();


        }


    }
}
