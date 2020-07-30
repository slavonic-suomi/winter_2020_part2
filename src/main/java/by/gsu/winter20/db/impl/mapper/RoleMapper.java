package by.gsu.winter20.db.impl.mapper;

import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.model.domain.FacebookUser;
import by.gsu.winter20.model.domain.GoogleUser;
import by.gsu.winter20.model.domain.Role;
import by.gsu.winter20.model.domain.User;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.Set;

@Component
public class RoleMapper implements RowMapper<Role> {

    @Override
    @SneakyThrows
    public Role mapRow(ResultSet resultSet, int row) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new Role(id, name);
    }
}
