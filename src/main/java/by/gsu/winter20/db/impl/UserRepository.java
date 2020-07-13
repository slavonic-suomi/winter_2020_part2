package by.gsu.winter20.db.impl;

import by.gsu.winter20.db.BaseRepository;
import by.gsu.winter20.db.ConnectionManager;
import by.gsu.winter20.db.RowMapper;
import by.gsu.winter20.model.domain.User;

public class UserRepository extends BaseRepository<User> {

    public UserRepository(ConnectionManager manager, RowMapper<User> userRowMapper) {
        super(manager, userRowMapper);
    }

    @Override
    protected String getTableName() {
        return "user";
    }
}
