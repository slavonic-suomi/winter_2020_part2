package by.gsu.winter20;

import by.gsu.winter20.config.ApplicationConfig;
import by.gsu.winter20.db.impl.mapper.RoleMapper;
import by.gsu.winter20.model.domain.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        RoleMapper roleMapper = context.getBean(RoleMapper.class);

        List<Role> roles = jdbcTemplate.query("select * from role", roleMapper);
        System.out.println(roles);

    }
}
