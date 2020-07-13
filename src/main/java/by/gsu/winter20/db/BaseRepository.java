package by.gsu.winter20.db;

import by.gsu.winter20.model.domain.IEntity;
import by.gsu.winter20.utils.Container;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


//MVC
@RequiredArgsConstructor
public abstract class BaseRepository<E extends IEntity> implements Container<E> {

    protected final ConnectionManager manager;
    protected final RowMapper<E> mapper;

    protected abstract String getTableName();

    @Override
    public int size() {
        AtomicInteger result = new AtomicInteger(0);

        manager.workWithConnection(connection -> {
            try(Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(*) from " + getTableName())) {
                resultSet.next();
                result.set(resultSet.getInt(1));
            }
        });

        return result.get();
    }

    @Override
    public void add(E element) {

    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public Collection<E> getAll() {
        List<E> result = new ArrayList<>();
        manager.workWithConnection(connection -> {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("select * from " + getTableName())) {

                while (resultSet.next()) {
                    E element = mapper.mapRow(resultSet);
                    result.add(element);
                }

            }
        });
        return result;
    }
}
