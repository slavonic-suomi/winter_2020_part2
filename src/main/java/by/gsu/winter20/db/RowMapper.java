package by.gsu.winter20.db;

import by.gsu.winter20.model.domain.IEntity;


public interface RowMapper<E extends IEntity> extends org.springframework.jdbc.core.RowMapper<E> {
}
