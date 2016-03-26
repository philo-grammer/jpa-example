package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sykim on 2016. 3. 26..
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}

/*
// Spring framework 미사용 item repository
@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {
            em.persist();
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
*/