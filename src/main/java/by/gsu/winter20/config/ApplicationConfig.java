package by.gsu.winter20.config;

import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.db.impl.UserRepository;
import by.gsu.winter20.menu.AddMenuItem;
import by.gsu.winter20.menu.MenuItem;
import by.gsu.winter20.menu.PrintAllMenuItem;
import by.gsu.winter20.menu.TopLevelMenu;
import by.gsu.winter20.model.RoleFactory;
import by.gsu.winter20.model.domain.IEntity;
import by.gsu.winter20.model.domain.Role;
import by.gsu.winter20.model.domain.User;
import by.gsu.winter20.utils.Container;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.ScannerWrapper;
import liquibase.integration.spring.SpringLiquibase;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

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

    @Bean
    public SpringLiquibase springLiquibase(DataSource ds) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(ds);
        liquibase.setChangeLog("classpath:db/changelog-master.xml");

        return liquibase;
    }

    @Bean
    public MenuItem<Role> roleAddMenuItem(Container<Role> container, Factory<Role> factory) {
        return new AddMenuItem<>(container, factory);
    }

    @Bean
    public MenuItem<Role> rolePrintAllMenuItem(Container<Role> container) {
        return new PrintAllMenuItem<>(container);
    }

    @Bean
    public TopLevelMenu<Role> roleTopLevelMenu(ScannerWrapper sc, List<MenuItem<Role>> items) {
        return new TopLevelMenu<>(sc, items, "roles", 1);
    }

    @Bean
    public MenuItem<User> userAddMenuItem(Container<User> container, Factory<User> factory) {
        return new AddMenuItem<>(container, factory);
    }

    @Bean
    public MenuItem<User> userPrintAllMenuItem(Container<User> container) {
        return new PrintAllMenuItem<>(container);
    }

    @Bean
    public TopLevelMenu<User> userTopLevelMenu(ScannerWrapper sc, List<MenuItem<User>> items) {
        return new TopLevelMenu<>(sc, items, "users", 2);
    }

    @Bean
    @SuppressWarnings("unchecked")
    public TopLevelMenu<? extends IEntity> topLevelMenu(ScannerWrapper sc, List<TopLevelMenu<? extends IEntity>> items) {
        return new TopLevelMenu(sc, items, "top", 1);
    }


}
