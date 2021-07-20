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
        User user = new User();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = connection.prepareStatement("select users_id, username, password from \"Users\" where username=" + newUser.getUsername() + " and password=" + newUser.getPassword());
        try {
            connection = dataSource.getConnection();
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getInt("users_id"));
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

    /*public User deleteUser(User newUser) throws SQLException{
        User user = new User();
        Connection connection = null;
        PreparedStatement statement = connection.prepareStatement("delete * from \"Users\" where username=" + newUser.getUsername());
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();
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
            System.out.println("User removed");
            return user;

        }



    }

     */
}
