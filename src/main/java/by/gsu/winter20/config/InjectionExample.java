package by.gsu.winter20.config;

import by.gsu.winter20.menu.MenuItem;
import by.gsu.winter20.model.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InjectionExample {

    private  MenuItem<Role> someMenuItem;

    // @Qualifier(RoleMapper.BEAN_NAME)
    @Autowired
    public InjectionExample(@Qualifier("rolePrintAllMenuItem") MenuItem<Role> someMenuItem) {
        this.someMenuItem = someMenuItem;
    }

    @PostConstruct
    public void init() {
        System.out.println(someMenuItem.getClass());
    }
}
