package by.gsu.winter20.db;

import by.gsu.winter20.model.domain.IEntity;

import java.sql.ResultSet;

public interface RowMapper<E extends IEntity> {

    E mapRow(ResultSet rs);
}
