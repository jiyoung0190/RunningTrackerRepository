package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class UserDao {

    private DataSource dataSource;

    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public User getUserByLoginAndPassword(User newUser) throws SQLException {
        User user = new User(newUser.getUsername(), newUser.getPassword());
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "select * from \"Users\" where username=" + user.getUsername() + " and password=" + user.getPassword();
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                    }
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                        }
                    }
                }

            }
            return user;

        }
    }
}
