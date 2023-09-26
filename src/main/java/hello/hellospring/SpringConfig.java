package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepositroy;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private final EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }


//    @Bean
//    public MemberRepository memberRepository() {
//        //구현체 변경. OCP ( open-closed Principle) 확장에는 열려있고  수정 변경에는 닫혀있다.
//        // return new MemoryMemberRepository();
//        //        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepositroy(dataSource);
////        return new JpaMemberRepository(em);ory(em);
//    }
}