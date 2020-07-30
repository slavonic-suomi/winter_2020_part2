package by.gsu.winter20.model;

import by.gsu.winter20.model.domain.FacebookUser;
import by.gsu.winter20.model.domain.GoogleUser;
import by.gsu.winter20.model.domain.User;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.ScannerWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserFactory implements Factory<User> {

    private final ScannerWrapper sc;

    @Override
    public User create() {
        System.out.println("1 - create plain user");
        System.out.println("2 - create facebook user");
        System.out.println("3 - create google user");

        int choice = sc.nextInt();

        System.out.println("Input login");
        String login = sc.nextLine();

        User result;
        switch (choice) {
            case 1: {
                result = new User(null, login, List.of());
                break;
            }
            case 2: {
                System.out.println("Input facebook profile");
                String profile = sc.nextLine();
                result = new FacebookUser(null, login, profile, List.of());
                break;
            }
            case 3: {
                System.out.println("Input google profile");
                String profile = sc.nextLine();
                result = new GoogleUser(null, login, profile, List.of());
                break;
            }
            default: throw new IllegalArgumentException();
        }

        return result;
    }
}
