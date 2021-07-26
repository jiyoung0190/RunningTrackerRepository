package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class UserDao {

    private DataSource dataSource;
    //added constants and setting statements to prevent SQL-injections
    public static final String CREATE_USER = "insert into \"Users\" (users_id, username, password) values (?, ?, ?);";
    public static final String DELETE_USER = "delete from \"Users\" where username=?;";
    public static final String GET_USER = "select users_id, username, password from \"Users\" where username=? and password=?;";
    public static final String GET_USER_BY_USERNAME = "select users_id, username, password from \"Users\" where username=?;";
    public static final String UPDATE_USER = "update \"Users\" set username =? where username=?;";

    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public User getUserByLoginAndPassword(String username, User passwordBody) throws SQLException { //passwordBody of User type is reserved for user's password input

        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = dataSource.getConnection()) {

            statement = connection.prepareStatement(GET_USER);
            statement.setString(1, username);
            statement.setString(2, passwordBody.getPassword());

            resultSet = statement.executeQuery();


            if (resultSet.next()) {

                user.setUsers_id(resultSet.getInt("users_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
            return user;

        }

    public HttpStatus deleteUser(String username) throws SQLException{

        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try(Connection connection = dataSource.getConnection()){
            try{
                statement = connection.prepareStatement(DELETE_USER);
                statement.setString(1, username);

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try{
                statement = connection.prepareStatement(GET_USER_BY_USERNAME);
                statement.setString(1, username);
                resultSet = statement.executeQuery();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
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
                    }
                }

            }

            return HttpStatus.GONE;

        }

    public HttpStatus createUser(User newUser) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try(Connection connection = dataSource.getConnection()) {

            try {
                statement = connection.prepareStatement(CREATE_USER);

                statement.setInt(1, newUser.getUsers_id());
                statement.setString(2, newUser.getUsername());
                statement.setString(3, newUser.getPassword());

               statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try{
                statement = connection.prepareStatement(GET_USER_BY_USERNAME);
                statement.setString(1, newUser.getUsername());
                resultSet = statement.executeQuery();

                if(resultSet.next()){

                    newUser.setUsers_id(resultSet.getInt("users_id"));
                    newUser.setUsername(resultSet.getString("username"));
                    newUser.setPassword(resultSet.getString("password"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

                    }
                }
            }

        return HttpStatus.CREATED;
    }

    public User updateUser(String oldUsername, User user){
        User updatedUser = new User();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = dataSource.getConnection()){
            try {
                statement = connection.prepareStatement(UPDATE_USER);
                statement.setString(1,
                        user.getUsername());
                statement.setString(2,
                        oldUsername);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try{
                statement = connection.prepareStatement(GET_USER_BY_USERNAME);
                statement.setString(1, user.getUsername());
                resultSet = statement.executeQuery();

                if(resultSet.next()){

                    updatedUser.setUsers_id(resultSet.getInt("users_id"));
                    updatedUser.setUsername(resultSet.getString("username"));
                    updatedUser.setPassword(resultSet.getString("password"));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedUser;
    }
}
