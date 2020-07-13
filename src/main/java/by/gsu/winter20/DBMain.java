package by.gsu.winter20;


import by.gsu.winter20.model.domain.FacebookUser;
import by.gsu.winter20.model.domain.GoogleUser;
import by.gsu.winter20.model.domain.User;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DBMain {

    @SneakyThrows
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement( "insert into user (login, type) values (?, 'p')")) {

            User userToSave = new User(null, "User12", List.of());

            preparedStatement.setString(1, userToSave.getLogin());
            int count = preparedStatement.executeUpdate();

            System.out.println(count);

        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from user")) {

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(parseUser(resultSet));

            }

            users.forEach(System.out::println);
        }
    }

    @SneakyThrows
    private static User parseUser(ResultSet resultSet) {
        int id = resultSet.getInt("id");
        String login = resultSet.getString("login");
        String type = resultSet.getString("type");

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

        return result;
    }
}
