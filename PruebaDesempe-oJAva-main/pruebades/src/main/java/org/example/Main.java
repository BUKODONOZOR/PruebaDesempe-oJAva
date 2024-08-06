package org.example;
import javax.swing.JOptionPane;

import org.example.Controlles.CorseController;
import org.example.Controlles.IncriptionController;
import org.example.Controlles.UserController;
import org.example.Models.Corse;
import org.example.Models.Incription;
import org.example.Models.User;

import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        UserController userController = new UserController();
        CorseController corseController = new CorseController();
        IncriptionController incriptionController = new IncriptionController();

        String opcion = JOptionPane.showInputDialog("¿Que opcion quieres?" +
                "1 Opciones de usuario  2 Opciones de curso 3 Opciones de inscripcion 4 opciones notas" );


        if(Objects.equals(opcion, "1")){
            String opcion2 = JOptionPane.showInputDialog("¿Que  deseas hacer? \"\n" +
                    " +\" Agregar usuario\" + \" Editar usuario\" + \" Ver todos\"");

            if(Objects.equals(opcion2 , "1")){
                String name = JOptionPane.showInputDialog("Dijite el nombre");
                String email = JOptionPane.showInputDialog("Dijite el correo");
                User user = new User( name , email ,1);
                UserController.addNewUser(user);

                System.out.println("Usuario creado");
            }
            if(Objects.equals(opcion2 , "2")){
                String name = JOptionPane.showInputDialog("Dijite el nombre");
                String email = JOptionPane.showInputDialog("Dijite el correo");

                User user = new User(1,name , email , 0);
                UserController.editUser(user);
            }
            if (Objects.equals(opcion2 , "3")){
                List<User> users = UserController.getAllUsers();
                for(User user : users){
                    System.out.println(user.getName() +user.getEmail() + +user.isState());
                }

            }
        }
        if(Objects.equals(opcion, "2")){
            String opcion2 =  JOptionPane.showInputDialog("¿Que  deseas hacer? \"\n" +
                    " +\" Agregar curso\" + \" Eliminar curso\" + \" Ver todos\"");

            if(Objects.equals(opcion2 , "1")){
                String name = JOptionPane.showInputDialog("Dijite el nombre");
                String description = JOptionPane.showInputDialog("Dijite la descripcion");

                Corse corse = new Corse(name , description);

                CorseController.AddCorse(corse);

                System.out.println("Curso creado");
            }

            if (Objects.equals(opcion2 , "3")){
                List<Corse> corses = CorseController.getAllCorses();
                for(Corse corse : corses){
                    System.out.println(corse.getName() + corse.getDescription());
                }

            }
        }
        if(Objects.equals(opcion, "3")){
            String opcion2 =  JOptionPane.showInputDialog("¿Que  deseas hacer? \"\n" +
                    " +\" Agregar incripcion\"+ \" Ver todas\"");

            if(Objects.equals(opcion2 , "1")){
                String idcorse = JOptionPane.showInputDialog("El id del curso");
                String iduser = JOptionPane.showInputDialog("El id del usuario");

                int idcorsep = Integer.parseInt(idcorse);
                int iduserp = Integer.parseInt(iduser);
                Incription incription = new Incription(idcorsep , iduserp);

                    IncriptionController.addNewIncription(incription);

                System.out.println("Inscripcion creada ");
            }

            if (Objects.equals(opcion2 , "2")){
                List<Incription> incriptions = IncriptionController.getAllIncription();
                for(Incription incription : incriptions){
                    System.out.println(incription.getIdcorse()  +incription.getIduser());
                }

            }
        }

    }
}