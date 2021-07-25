package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class UserDataDao {

    public static final String GET_USERDATA = "select * from \"Users\" inner join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id where username=?;";
    public static final String INSERT_USERDATA = "insert () \"Users\" inner join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id where username=?;";

    private DataSource userDataSource;


    @Autowired
    public UserDataDao(DataSource userDataSource) {
        this.userDataSource = userDataSource;
    }


    public UserData getUserData(User user) {
        UserData userData = new UserData();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {

            connection = userDataSource.getConnection();
            statement = connection.prepareStatement(GET_USERDATA);
            statement.setString(1, user.getUsername());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userData.setDate(resultSet.getDate("date"));
                userData.setDistance(resultSet.getFloat("distance"));
                userData.setTime(resultSet.getTime("time"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public UserData createUserData(UserData userData) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {

            connection = userDataSource.getConnection();
            statement = connection.prepareStatement(GET_USERDATA);
            statement.setString(1, user.getUsername());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userData.setDate(resultSet.getDate("date"));
                userData.setDistance(resultSet.getFloat("distance"));
                userData.setTime(resultSet.getTime("time"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;

    }

   /* public UserData addUserData(UserData userData){
        Connection connection = null;
    }

    */
}
