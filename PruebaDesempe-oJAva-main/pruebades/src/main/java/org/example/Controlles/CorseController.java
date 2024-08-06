package org.example.Controlles;

import org.example.Models.Corse;
import org.example.Repository.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorseController {

    private static Connection connection ;

    public CorseController( ) {
        try {
           connection = DatabaseConnection.getConnection() ;
        }catch (SQLException error){
            error.printStackTrace();
        }
    }
    /**MOSTRAR TODOS CURSOS MEDIATE ID**/
    public static List<Corse> getAllCorses(){
        List<Corse> corses = new ArrayList<>();

        String query  = "SELECT * FROM corse";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");

                Corse corse = new Corse(id, name ,description);
            }

        }catch (SQLException error){
            error.printStackTrace();
        }

        return corses;
    }

    /**ELIMINAR CURSO MEDIATE ID**/
    public static boolean deleteCorse(int id){
        String query = "DELETE FROM corse WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1,id);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted >0;
        }catch (SQLException error){
            error.printStackTrace();
        }
        return  false;
    }
    /**AGREGAR CURSO **/
    public  static  void   AddCorse(Corse Corse){

        String query = "INSERT INTO corse (name , email , state) VALUES (?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1 , Corse.getName());
            preparedStatement.setString(2 , Corse.getDescription());


            preparedStatement.executeUpdate();
        }catch (SQLException error ){
            error.printStackTrace();
        }
    }



}
