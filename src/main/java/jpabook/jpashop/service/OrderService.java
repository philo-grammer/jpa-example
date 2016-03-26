package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sykim on 2016. 3. 26..
 */
@Service
@Transactional
public class OrderService {

    @Autowired
    MemberService memberService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemService itemService;

    /** 주문 */
    public Long order(Long memberId, Long itemId, int count) {

        // 엔티티 조회
        Member member = memberService.findOne(memberId);
        Item item = itemService.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem =
                OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    /** 주문 취소 */
    public void cancelOrder(Long orderId) {

        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);

        // 주문 취소
        order.cancel();
    }

    /** 주문 조회 */
    public Order findOne(Long orderId) {
        return orderRepository.findOne(orderId);
    }

    /** 주문 검색 */
/*
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch);
    }
*/
}
