
package jpabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class JpashopApplication {

    // 단축키 : psvm
    public static void main(String[] args) {
        SpringApplication.run(JpashopApplication.class, args);
    }
}
