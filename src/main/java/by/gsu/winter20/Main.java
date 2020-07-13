package by.gsu.winter20;

import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.impl.RoleRepository;
import by.gsu.winter20.db.impl.UserRepository;
import by.gsu.winter20.db.impl.mapper.RoleMapper;
import by.gsu.winter20.db.impl.mapper.UserMapper;
import by.gsu.winter20.model.domain.User;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.ReflectionFactory;
import by.gsu.winter20.utils.ScannerWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;


public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        Factory<User> factory = new ReflectionFactory<>(User.class, new ScannerWrapper());
//
//        User user = factory.create();
//        System.out.println(user);
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        String userJson = mapper.writeValueAsString(user);
//        System.out.println(userJson);

        ConnectionManager manager = new ConnectionManager();

        RoleMapper roleMapper = new RoleMapper();
        RoleRepository roleRepository = new RoleRepository(manager, roleMapper);

        UserMapper userMapper = new UserMapper(roleRepository);
        UserRepository userRepository = new UserRepository(manager, userMapper);


        System.out.println(userRepository.size());

        System.out.println(userRepository.getAll());

        System.out.println(roleRepository.getAll());

    }
}
