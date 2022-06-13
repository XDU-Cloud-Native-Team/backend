package xdu.cloudnative.service.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 邓乐丰
 */
@SpringBootApplication
@ServletComponentScan("xdu.cloudnative.service.authority.controller")
@ComponentScan({"xdu.cloudnative.model.file", "xdu.cloudnative.model.authority", "xdu.cloudnative.model.group"})
public class AuthorityServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityServiceApplication.class,args);
    }
}
