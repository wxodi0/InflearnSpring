package hello.hellospring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

    @Test
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

}
