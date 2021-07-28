package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class UserDao {

    private final DataSource dataSource;
    public static final String CREATE_USER = "insert into \"Users\" (users_id, username, password) values (?, ?, ?);";
    public static final String DELETE_USER = "delete from \"Users\" where username=?;";
    public static final String GET_USER = "select users_id, username, password from \"Users\" where username=? and password=?;";
    public static final String GET_USER_BY_USERNAME = "select users_id, username, password from \"Users\" where username=?;";
    public static final String UPDATE_USER = "update \"Users\" set username=?, password =? where users_id=?;";

    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User getUser(User user) {
        User returnedUser = new User();
        ResultSet resultSet;
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement(GET_USER);
            statement.setString(1,
                    user.getUsername());
            statement.setString(2,
                    user.getPassword());

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                returnedUser.setUsers_id(resultSet.getInt("users_id"));
                returnedUser.setUsername(resultSet.getString("username"));
                returnedUser.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnedUser;
    }

    public boolean deleteUser(User user) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement(DELETE_USER);
            statement.setString(1,
                    user.getUsername());
            return statement.execute(); //statement.execute() returns either true (if its SELECT) or false (if nothing is retrieved)
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public User createUser(User newUser) {
        User createdUser = new User();
        ResultSet resultSet;
        PreparedStatement statement;
        try (Connection connection = dataSource.getConnection()) {

            statement = connection.prepareStatement(CREATE_USER);
            statement.setInt(1,
                    newUser.getUsers_id());
            statement.setString(2,
                    newUser.getUsername());
            statement.setString(3,
                    newUser.getPassword());
            statement.executeUpdate();


            statement = connection.prepareStatement(GET_USER_BY_USERNAME);
            statement.setString(1,
                    newUser.getUsername());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                createdUser.setUsers_id(resultSet.getInt("users_id"));
                createdUser.setUsername(resultSet.getString("username"));
                createdUser.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createdUser;
    }

    public User updateUser(User user) {
        User updatedUser = new User();
        PreparedStatement statement;
        ResultSet resultSet;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1,
                    user.getUsername());
            statement.setString(2,
                    user.getPassword());
            statement.setInt(3,
                    user.getUsers_id());
            statement.executeUpdate();


            statement = connection.prepareStatement(GET_USER_BY_USERNAME);
            statement.setString(1,
                    user.getUsername());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                updatedUser.setUsers_id(resultSet.getInt("users_id"));
                updatedUser.setUsername(resultSet.getString("username"));
                updatedUser.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedUser;
    }
}


