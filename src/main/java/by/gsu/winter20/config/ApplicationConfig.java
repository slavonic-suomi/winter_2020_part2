package by.gsu.winter20.config;

import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.db.impl.UserRepository;
import by.gsu.winter20.model.RoleFactory;
import by.gsu.winter20.model.domain.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("by.gsu.winter20")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${dburl}")
    private String url;
    @Value("${dbuser}")
    private String user;
    @Value("${dbpassword}")
    private String password;

    @Bean
    @SneakyThrows
    public DataSource dataSource() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return new DriverManagerDataSource(url, user, password);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
