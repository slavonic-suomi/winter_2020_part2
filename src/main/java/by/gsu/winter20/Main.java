package by.gsu.winter20;

import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.impl.RoleRepository;
import by.gsu.winter20.db.impl.UserRepository;
import by.gsu.winter20.db.impl.mapper.RoleMapper;
import by.gsu.winter20.db.impl.mapper.UserMapper;
import by.gsu.winter20.menu.*;
import by.gsu.winter20.model.RoleFactory;
import by.gsu.winter20.model.UserFactory;
import by.gsu.winter20.model.domain.Role;
import by.gsu.winter20.model.domain.User;
import by.gsu.winter20.utils.Factory;
import lombok.SneakyThrows;


public class Main {

    @SneakyThrows
    public static void main(String[] args) {

        ConnectionManager manager = new ConnectionManager();

        RoleMapper roleMapper = new RoleMapper();
        RoleRepository roleRepository = new RoleRepository(manager, roleMapper);

        UserMapper userMapper = new UserMapper(roleRepository);
        UserRepository userRepository = new UserRepository(manager, userMapper);

        Factory<User> userFactory = new UserFactory();
        Factory<Role> roleFactory = new RoleFactory();

        MenuItem<Role>[] roleItems = new MenuItem[3];

        roleItems[0] = new AddMenuItem<>(roleRepository, roleFactory);
        roleItems[1] = new DeleteMenuItem<>(roleRepository);
        roleItems[2] = new PrintAllMenuItem<>(roleRepository);
        TopLevelMenu<Role> roleMenu = new TopLevelMenu<>(roleItems, "roles", 1);

        MenuItem<User>[] userItems = new MenuItem[3];

        userItems[0] = new AddMenuItem<>(userRepository, userFactory);
        userItems[1] = new DeleteMenuItem<>(userRepository);
        userItems[2] = new PrintAllMenuItem<>(userRepository);
        TopLevelMenu<User> userMenu = new TopLevelMenu<>(userItems, "users", 2);


        MenuItem<?>[] globalItems = {roleMenu, userMenu};
        TopLevelMenu<?> globalMenu = new TopLevelMenu(globalItems, "global", 0);

        globalMenu.run();
    }
}
