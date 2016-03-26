package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sykim on 2016. 3. 26..
 */

public interface OrderRepository extends JpaRepository<Order, Long> {

    //List<Order> findAll(OrderSearch );
}

/*    
@Repository
public class OrderRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

   // public List<Order> findAll(OrderSearch orderSearch) {
        
   // }

}
*/