package by.gsu.winter20.db.impl;

import by.gsu.winter20.db.BaseRepository;
import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.model.domain.FacebookUser;
import by.gsu.winter20.model.domain.GoogleUser;
import by.gsu.winter20.model.domain.User;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepository extends BaseRepository<User> {

    public UserRepository(ConnectionManager manager, RowMapper<User> userRowMapper) {
        super(manager, userRowMapper);
    }

    @Override
    protected String getTableName() {
        return "user";
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User element) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "insert into user (login, password, type, fackebook_profile, google_uid) values (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );

        statement.setString(1, element.getLogin());
        statement.setNull(2, Types.VARCHAR);
        if (element instanceof FacebookUser) {
            statement.setString(3, "f");
            statement.setString(4, ((FacebookUser)element).getFacebookProfile());
            statement.setNull(5, Types.VARCHAR);
        } else
        if (element instanceof GoogleUser) {
            statement.setString(3, "g");
            statement.setNull(4, Types.VARCHAR);
            statement.setString(5, ((GoogleUser)element).getGoogleUid());
        } else {
            statement.setString(3, "p");
            statement.setNull(4, Types.VARCHAR);
            statement.setNull(5, Types.VARCHAR);
        }

        return statement;
    }
}
