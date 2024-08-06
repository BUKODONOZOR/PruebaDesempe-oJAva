package org.example.Controlles;

import org.example.Models.Rate;
import org.example.Models.User;
import org.example.Repository.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateController {

    private static  Connection connection;

    public RateController(){
        try{
            connection = DatabaseConnection.getConnection();
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

    public  static  List<Rate>  getAllRates(){
        List<Rate> rates = new ArrayList<>();

        String query  = "SELECT * FROM rate";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int iduser = resultSet.getInt("iduser");
                int idincription = resultSet.getInt("idincription");
                int value = resultSet.getInt("value");

                Rate rate = new Rate(id, iduser ,idincription ,value);
                rates.add(rate);
            }

        }catch (SQLException error){
            error.printStackTrace();
        }

        return rates;
    }

    public static void addNewUser(User User){
        String query = "INSERT INTO user (id , iduser , idi) VALUES (?,?,?)";

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
