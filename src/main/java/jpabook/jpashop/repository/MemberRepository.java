package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sykim on 2016. 3. 26..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);
}


/*
@Repository
public class MemberRepository {

    // @PersistenceContext
    // 스프링이나 J2EE 컨테이너를 사용하면 컨테이너가 엔티티 매니저를 관리하고 제공해준다.
    // 따라서 엔티티 매니저 팩토리에서 엔티티 매니저를 직접 생성해서 사용하는 것이 아니라
    // 컨테이너가 제공하는 엔티티 매니저를 사용해야 한다

    @PersistenceContext // 엔티티 매니저 주입
    EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m " +
                                "from Member m", Member.class)
                .getResultList();
    }

    // JPQL을 사용해서 이름(name)으로 회원 엔티티들을 조회한다
    public List<Member> findByName(String name) {
        return em.createQuery("select m " +
                                "from Member m " +
                               "where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
*/
