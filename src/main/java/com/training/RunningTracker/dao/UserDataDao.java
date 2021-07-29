package com.training.RunningTracker.dao;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDataDao {

    public static final String GET_USERDATA = "select * from \"Users\" left join \"Users_data\"on \"Users\".users_id = \"Users_data\".users_id and \"Users\".users_id=?;";
    public static final String INSERT_USERDATA = "insert into \"Users_data\" (distance, date, time, id, users_id) values (?, ?, ?, ?, ?);";
    public static final String DELETE_USERDATA = "delete from \"Users_data\" where users_id=?;";
    public static final String UPDATE_USER_RECORD = "update \"Users_data\" set distance=?, date=?, time=?, id=? where users_id=? and  id=?;";

    private final DataSource userDataSource;


    @Autowired
    public UserDataDao(DataSource userDataSource) {
        this.userDataSource = userDataSource;
    }

    public HttpStatus createUserData(Integer userId, UserData userData) {
        PreparedStatement statement;

        try (Connection connection = userDataSource.getConnection()) {
            try {
                statement = connection.prepareStatement(INSERT_USERDATA);

                statement.setFloat(1,
                        userData.getDistance());
                statement.setDate(2,
                        userData.getDate());
                statement.setTime(3,
                        userData.getTime());
                statement.setInt(4,
                        userData.getId()); //needs a generator
                statement.setInt(5,
                        userId);

                statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HttpStatus.CREATED;

    }


    public List<UserData> getUserData(User user) {
        PreparedStatement statement;
        ResultSet resultSet;
        List <UserData> dataList = new ArrayList<>();



        try (Connection connection = userDataSource.getConnection()) {

            statement = connection.prepareStatement(GET_USERDATA);
            statement.setInt(1, user.getUsers_id());
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                if(resultSet.getInt("users_id") == user.getUsers_id()){
                UserData userData = new UserData();
                userData.setDistance(resultSet.getFloat("distance"));
                userData.setDate(resultSet.getDate("date"));
                userData.setTime(resultSet.getTime("time"));
                userData.setId(resultSet.getInt("id"));
                userData.setUsersId(resultSet.getInt("users_id"));
                dataList.add(userData);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }


    public HttpStatus deleteUserData(Integer userId) {
        PreparedStatement statement;

        try (Connection connection = userDataSource.getConnection()) {
            statement = connection.prepareStatement(DELETE_USERDATA);
            statement.setInt(1,
                    userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HttpStatus.GONE;
    }

    public HttpStatus updateUserData(Integer userId, Integer recordId, UserData userData) {
        PreparedStatement statement;

        try (Connection connection = userDataSource.getConnection()) {
            try {
                statement = connection.prepareStatement(UPDATE_USER_RECORD);

                statement.setFloat(1,
                        userData.getDistance());
                statement.setDate(2,
                        userData.getDate());
                statement.setTime(3,
                        userData.getTime());
                statement.setInt(4,
                        userData.getId());
                statement.setInt(5,
                        userId);
                statement.setInt(6,
                        recordId);
                statement.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return HttpStatus.OK;
    }
}
