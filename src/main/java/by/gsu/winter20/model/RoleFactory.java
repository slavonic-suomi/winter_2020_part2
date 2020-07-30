package by.gsu.winter20.model;

import by.gsu.winter20.model.domain.Role;
import by.gsu.winter20.utils.Factory;
import by.gsu.winter20.utils.ScannerWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleFactory implements Factory<Role> {

    private final ScannerWrapper sc;

    @Override
    public Role create() {
        System.out.println("Input role name");
        var name = sc.nextLine();
        return new Role(null, name);
    }
}
