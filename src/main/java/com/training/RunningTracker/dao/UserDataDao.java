package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UserDataDao {

    private DataSource userDataSource;

    @Autowired
    public UserDataDao(DataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    //new method
    public UserData getUserData(UserData userData) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "select date, distance, time from \"Users_data\"";
        try {
            connection = userDataSource.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

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
}
