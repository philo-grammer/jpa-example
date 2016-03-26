package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by sykim on 2016. 3. 18..
 */
public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa-book");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();    // !!!!!!!!!!!!!!!!!!!!!!
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

    private static void logic(EntityManager em) {

        /*
        //== 영속성 전이를 사용하기 전==//
        Delivery delivery = new Delivery();
        em.persist(delivery);   //persist

        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();
        em.persist(orderItem1); //persist
        em.persist(orderItem2); //persist

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);  //persist
        */

        Delivery delivery = new Delivery();
        OrderItem orderItem1 = new OrderItem();
        OrderItem orderItem2 = new OrderItem();

        Order order = new Order();
        order.setDelivery(delivery);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        em.persist(order);  //delivery, orderItems 플러시 시점에서 영속성 전이

        System.out.println("Success!");

        /*
        //Order 저장
        Order order = new Order();
        order.setName("OrderA");

        em.persist(team);

        //회운 저장
        Member member = new Member();
        member.setUsername("hello");
        member.setTeam(team); // 연관관계의 주인

        em.persist(member);

        //수정
        Team teamB = new Team();
        teamB.setName("신규B");

        em.persist(teamB);

        //조회
        Member findMember = em.find(Member.class, member.getId());
        findMember.setTeam(teamB);  //수정 팀 A --> 팀 B

        int membersSize = findMember.getTeam().getMembers().size();   //역방향 조회
*/
    }
}