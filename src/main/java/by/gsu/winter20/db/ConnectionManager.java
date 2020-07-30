package by.gsu.winter20.db;

import by.gsu.winter20.utils.ThrowableConsumer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionManager {

    @Value("${dburl}")
    private String url;
    @Value("${dbuser}")
    private String user;
    @Value("${dbpassword}")
    private String password;


    @SneakyThrows
    public ConnectionManager() {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    @SneakyThrows
    public void workWithConnection(ThrowableConsumer<Connection> connectionConsumer) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connectionConsumer.accept(connection);
        }
    }
}
