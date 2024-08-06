package org.example.Controlles;

import org.example.Models.Incription;
import org.example.Models.User;
import org.example.Repository.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncriptionController {

    private static Connection connection ;

    public  IncriptionController(){
        try{
            connection = DatabaseConnection.getConnection();
        }catch (SQLException error){
            error.printStackTrace();
        }
    }

    public static List<Incription> getAllIncription(){
        List<Incription> incriptions = new ArrayList<>();

        String query  = "SELECT * FROM incription";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int iduser = resultSet.getInt("iduser");
                int idcorse = resultSet.getInt("idcorse");


                Incription incription = new Incription(id, iduser, idcorse );
                incriptions.add(incription);
            }

        }catch (SQLException error){
            error.printStackTrace();
        }

        return incriptions;
    }

    public static void addNewIncription(Incription Incription){
        String query = "INSERT INTO user (iduser , idcorse ) VALUES (?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1 , Incription.getIduser());
            preparedStatement.setInt(2 , Incription.getIdcorse());

            preparedStatement.executeUpdate();
        }catch (SQLException error ){
            error.printStackTrace();
        }


    };
}
