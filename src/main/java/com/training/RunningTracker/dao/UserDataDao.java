package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class UserDataDao {

    public static final String GET_USERDATA = "select * from \"Users\" left join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id and \"Users\".users_id=?;";
    public static final String INSERT_USERDATA = "insert into \"Users_data\" (distance, date, time, id, users_id) values (?, ?, ?, ?, ?) inner join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id";
    public static final String DELETE_USERDATA = "delete from \"Users_data\" where username=?;";

    private DataSource userDataSource;


    @Autowired
    public UserDataDao(DataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    //works now
    public UserData getUserData(Integer users_id) {
        UserData userData = new UserData();
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try(Connection connection = userDataSource.getConnection()){

            statement = connection.prepareStatement(GET_USERDATA);
            statement.setInt(1, users_id);
            resultSet = statement.executeQuery();


            if (resultSet.next()) {

                userData.setDate(resultSet.getDate("date"));
                userData.setDistance(resultSet.getFloat("distance"));
                userData.setTime(resultSet.getTime("time"));
                userData.setId(resultSet.getInt("id"));
                userData.setUsersId(resultSet.getInt("users_id"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public HttpStatus createUserData(UserData userData) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {

            connection = userDataSource.getConnection();
            statement = connection.prepareStatement(INSERT_USERDATA);

            statement.setFloat(1, userData.getDistance());
            statement.setDate(2, (Date) userData.getDate());
            statement.setTime(3, userData.getTime());
            statement.setInt(4, userData.getId());
            statement.setInt(4, userData.getUsersId());

            resultSet = statement.executeQuery();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HttpStatus.CREATED;

    }

    public HttpStatus deleteUserData(UserData userData) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = userDataSource.getConnection();
            statement = connection.prepareStatement(DELETE_USERDATA);

            statement.setFloat(1, userData.getDistance());
            statement.setDate(2, (Date) userData.getDate());
            statement.setTime(3, userData.getTime());
            statement.setInt(4, userData.getId());
            statement.setInt(4, userData.getUsersId());

            resultSet = statement.executeQuery();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return HttpStatus.GONE;
    }
}
