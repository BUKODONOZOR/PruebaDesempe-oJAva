package org.example.Controlles;

import org.example.Models.User;
import org.example.Repository.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private static Connection connection ;
   /*Constructor UserController*/
    public  UserController(){
        try{
            connection = DatabaseConnection.getConnection();
        }catch (SQLException error){
            error.printStackTrace();
        }
    }
    /*Metodo Para obtener todos los usuarios*/
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
    /*Metodo para agregar un nuevo usuario*/
    public static void addNewUser(User User){
        String query = "INSERT INTO user (name , email , state) VALUES (?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1 , User.getName());
            preparedStatement.setString(2 , User.getEmail());
            preparedStatement.setInt(3 , User.isState());


            preparedStatement.executeUpdate();
        }catch (SQLException error ){
            error.printStackTrace();
        }


    };
    /*Metodo para editar un nuevo usuario*/
    public static boolean  editUser(User User){
        String query = "UPDATE user SET name = ? , email = ? , state = ?  WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1 , User.getName());
            preparedStatement.setString(2 , User.getEmail());
            preparedStatement.setInt(3 , User.isState());
            preparedStatement.setInt(4, User.getId());

            int RowsUpdate = preparedStatement.executeUpdate();
            return RowsUpdate> 0;
        }catch (SQLException error){
            error.printStackTrace();
            return false;
        }
    }

    public static User getUserById(int id){
        String query = "SELECT * FROM user * WHERE id = ?";
                try(PreparedStatement PreparedStatement = connection.prepareStatement(query))
                {
                    PreparedStatement.setInt(1 ,id);
                    ResultSet resultSet = PreparedStatement.executeQuery();
                    if (resultSet.next()){
                        String name = resultSet.getString("name");
                        String email = resultSet.getString("email");
                        int state = resultSet.getInt("state");
                        return new User(id , name , email , state);
                    }

                }catch (SQLException error){
                    error.printStackTrace();
                }
                return null;
    }




}
