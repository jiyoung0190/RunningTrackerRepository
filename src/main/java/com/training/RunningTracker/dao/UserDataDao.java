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
            //here, we'll need to implement inner communication within 2 classes - UserDao and UserDataDao
            connection = userDataSource.getConnection();
            statement = connection.prepareStatement("select * from \"Users\" inner join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id where username=" + user.getUsername() + ";");
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
