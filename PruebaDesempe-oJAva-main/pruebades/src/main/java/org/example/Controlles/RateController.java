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
  /**Metodo para ver todas las notas*/
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
    /**Metodo para agregar las notas*/
    public static void addNewRate(Rate Rate){
        String query = "INSERT INTO user (iduser , idincription , value) VALUES (?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1 , Rate.getIduser());
            preparedStatement.setInt(2 , Rate.getIdincription());
            preparedStatement.setInt(3 , Rate.getValue());


            preparedStatement.executeUpdate();
        }catch (SQLException error ){
            error.printStackTrace();
        }


    };
    /**Metodo para editar  las notas*/
    public static boolean  editUser(Rate Rate){
        String query = "UPDATE rate SET iduser = ? , idincription = ? , value = ?  WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1 , Rate.getIduser());
            preparedStatement.setInt(2 , Rate.getIdincription());
            preparedStatement.setInt(3 , Rate.getValue());
            preparedStatement.setInt(4 , Rate.getId());

            int RowsUpdate = preparedStatement.executeUpdate();
            return RowsUpdate> 0;
        }catch (SQLException error){
            error.printStackTrace();
            return false;
        }
    }


    /**Metodo eliminar  las notas*/
    public static boolean deleteRate(int id){
        String query = "DELETE FROM rate WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1,id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted >0;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return  false;
    }


}
