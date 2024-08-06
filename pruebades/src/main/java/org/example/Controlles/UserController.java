package org.example.Controlles;

import org.example.Models.User;
import org.example.Repository.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private static Connection connection ;

    public  UserController(){
        try{
            connection = DatabaseConnection.getConnection();
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

    public  static  List<User>  getAllUsers(){
        List<User> users = new ArrayList<>();

        String query  = "SELECT * FROM user";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int state = resultSet.getInt("state");

                User user = new User(name, email ,state);
                users.add(user);
            }

        }catch (SQLException error){
            error.printStackTrace();
        }

        return users;
    }

    public static void addNewUser(User User){
        String query = "INSERT INTO user (name , email , state) VALUES (?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1 , User.getName());
            preparedStatement.setString(2 , User.getEmail());
            preparedStatement.setInt(3 , User.isState());
            preparedStatement.setInt(4, User.getId());

            preparedStatement.executeUpdate();
        }catch (SQLException error ){
            error.printStackTrace();
        }


    };

    public static boolean  editUser(User User){
        String query = "UPDATE user SET name = ? , email = ? , state = ?  WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1 , User.getName());
            preparedStatement.setString(2 , User.getEmail());
            preparedStatement.setInt(3 , User.isState());

            int RowsUpdate = preparedStatement.executeUpdate();
            return RowsUpdate> 0;
        }catch (SQLException error){
            error.printStackTrace();
            return false;
        }
    }





}
