package by.gsu.winter20.db.impl.mapper;

import by.gsu.winter20.db.BaseRepository;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.db.impl.RoleRepository;
import by.gsu.winter20.model.domain.FacebookUser;
import by.gsu.winter20.model.domain.GoogleUser;
import by.gsu.winter20.model.domain.Role;
import by.gsu.winter20.model.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class UserMapper implements RowMapper<User> {

    private final RoleRepository roleBaseRepository;

    @Override
    @SneakyThrows
    public User mapRow(ResultSet resultSet) {
        int id = resultSet.getInt("id");
        String login = resultSet.getString("login");
        String type = resultSet.getString("type");

        List<Role> roles = roleBaseRepository.getRolesByUser(id);

        User result;
        switch (type) {
            case "p" : {
                result = new User(id, login, List.of());
                break;
            }
            case "f" : {
                String profile = resultSet.getString("facebook_profile");
                result = new FacebookUser(id, login, profile, List.of());
                break;
            }
            case "g" : {
                String uid = resultSet.getString("google_uid");
                result = new GoogleUser(id, login, uid, List.of());
                break;
            }
            default: throw new IllegalArgumentException("unknown user type");
        }

        result.setRole(roles);
        return result;
    }
}
