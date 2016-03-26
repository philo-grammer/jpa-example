package jpabook.jpashop.service;

import jpabook.JpashopApplication;
import jpabook.jpashop.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by sykim on 2016. 3. 26..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpashopApplication.class)
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void 회원가입() throws Exception {

        // Given
        Member member = new Member();
        member.setName("kim");

        // When
        Long memberId = memberService.join(member);

        // Then
        assertEquals(member, memberService.findOne(memberId));
    }


    // @Test.expected 속성에 예외 클래스를 지정하면
    // 테스트의 결과로 지정한 예외가 발생해야 테스트가 성공한다.
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {

        // Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // When
        memberService.join(member1);
        memberService.join(member2);    // 예외 발생

        // Then
        fail("예외가 발생해야 한다.");
    }
}