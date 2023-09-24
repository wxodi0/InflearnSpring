package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepositroy;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //구현체 변경. OCP ( open-closed Principle) 확장에는 열려있고  수정 변경에는 닫혀있다.
        // return new MemoryMemberRepository();
        //        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepositroy(dataSource);
    }
}