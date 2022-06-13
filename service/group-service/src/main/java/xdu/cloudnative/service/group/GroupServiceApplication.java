package xdu.cloudnative.service.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 邓乐丰@xduTD
 */
@SpringBootApplication
@ServletComponentScan("xdu.cloudnative.service.group.controller")
@ComponentScan({"xdu.cloudnative.model.file", "xdu.cloudnative.model.authority", "xdu.cloudnative.model.group"})
public class GroupServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupServiceApplication.class, args);
    }
}
