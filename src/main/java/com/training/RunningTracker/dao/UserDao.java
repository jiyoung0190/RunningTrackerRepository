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


    @Autowired
    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public User getUserByLoginAndPassword(User newUser) throws SQLException {
        User user = new User();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(GET_USER);
            statement.setString(1, newUser.getUsername());
            statement.setString(2, newUser.getPassword());
            resultSet = statement.executeQuery();


            if (resultSet.next()) {
                user.setUsers_id(resultSet.getInt("users_id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
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

    public HttpStatus deleteUser(User user) throws SQLException{
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement(DELETE_USER);
            statement.setString(1, user.getUsername());

            resultSet = statement.executeQuery();

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
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                        }
                    }
                }

            }

            return HttpStatus.GONE;

        }



    }
    
    public HttpStatus createUser(User newUser) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(CREATE_USER);

            statement.setInt(1, newUser.getUsers_id());
            statement.setString(2, newUser.getUsername());
            statement.setString(3, newUser.getPassword());

            resultSet = statement.executeQuery();

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
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                        }
                    }
                }

            }


        }

        return HttpStatus.CREATED;
    }
}
