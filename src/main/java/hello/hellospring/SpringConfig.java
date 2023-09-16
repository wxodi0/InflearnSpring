package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
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
<<<<<<< HEAD
=======
        //구현체 변경. OCP ( open-closed Principle) 확장에는 열려있고  수정 변경에는 닫혀있다.
>>>>>>> 9543731 (Add testCase in MemberServiceIntegration)
// return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}