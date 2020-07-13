package by.gsu.winter20.db;

import by.gsu.winter20.utils.ThrowableConsumer;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Consumer;

public class ConnectionManager {

    @SneakyThrows
    public void workWithConnection(ThrowableConsumer<Connection> connectionConsumer) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root")) {
            connectionConsumer.accept(connection);
        }
    }
}
