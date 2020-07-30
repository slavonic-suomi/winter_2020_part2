package by.gsu.winter20.db.impl;

import by.gsu.winter20.db.BaseRepository;
import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.model.domain.Role;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoleRepository extends BaseRepository<Role> {

    public RoleRepository(ConnectionManager manager, RowMapper<Role> mapper) {
        super(manager, mapper);
    }

    @Override
    protected String getTableName() {
        return "role";
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Role element) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into role (`name`) values (?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getName());
        return statement;
    }

    public List<Role> getRolesByUser(Integer userId) {
        List<Role> result = new ArrayList<>();

        manager.workWithConnection(connection -> {
            try (PreparedStatement preparedStatement = connection.prepareStatement("select role.*" +
                    "    from user_roles, role" +
                    "    where role_id  = role.id and user_id = ?")) {

                preparedStatement.setInt(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        result.add(mapper.mapRow(resultSet, 0));
                    }
                }
            }
        });

        return result;
    }
}
