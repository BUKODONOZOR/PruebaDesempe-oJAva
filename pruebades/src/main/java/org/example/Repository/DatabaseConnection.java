package org.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static  final  String URL ="jdbc:mysql://localhost:3306/RiwiAcademy";
    private static  final  String USER = "root";

    private static  final  String PASSWORD = "Rlwl2023.";


    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public static void main(String[] args) {
         try(Connection connection = getConnection()){
             if(connection != null ){
                 System.out.println("CONEXION EXITOSA");
             }
         }catch (SQLException error){
             error.printStackTrace();
         }
    }
}
