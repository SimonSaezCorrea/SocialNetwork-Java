/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Equipo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        //Se crea la socialnetwork
        Socialnetwork SN = new Socialnetwork("TheNewSocial", Calendar.getInstance().getTime());
        
        //Se a�aden los usuarios
        
        SN.register("Simon", "123");
        SN.logout();
        SN.register("Maria", "abc");
        SN.logout();
        SN.register("Carlos", "1a2b3c4d");
        SN.logout();
        SN.register("Laura", "contrase�a");
        SN.logout();
        SN.register("Anonimo", "*****");
        SN.logout();
        
        //Se a�aden las preguntas
        SN.login("Simon", "123");
        SN.post("text", "Este es el primer post");
        SN.follow("Maria");
        SN.follow("Carlos");
        SN.follow("Laura");
        SN.follow("Anonimo");
        SN.logout();
        
        SN.login("Maria", "abc");
        SN.post("text", "Soy el segundo jaja");
        SN.follow("Simon");
        SN.follow("Carlos");
        SN.follow("Laura");
        SN.follow("Anonimo");
        SN.logout();
        
        SN.login("Carlos", "1a2b3c4d");
        SN.post("text", "Y bueno, �Ahora que?");
        SN.follow("Simon");
        SN.follow("Maria");
        SN.follow("Laura");
        SN.follow("Anonimo");
        SN.logout();
        
        SN.login("Simon", "123");
        SN.post("text", "Se va avanzando");
        SN.logout();
        
        SN.login("Simon", "123");
        SN.post("text", "Ya van siendo varios post de la gente, fantastico");
        SN.logout();
        
        //Se a�aden los comentarios
        
        //Se crean los comentarios iniciales de la socialnetwork
        /* Comment comment1 = new Comment(1, user1, Calendar.getInstance().getTime(), "Este es el primer comentario");
        Comment comment2 = new Comment(2, user4, Calendar.getInstance().getTime(), "Y yo el segundo comentario jeje");
        Comment comment3 = new Comment(3, user5, Calendar.getInstance().getTime(), "Lastima no poder comentar con una foto");
        Comment comment4 = new Comment(4, user5, Calendar.getInstance().getTime(), "Animo!");
        Comment comment5 = new Comment(5, user2, Calendar.getInstance().getTime(), "Se progresa rapido (?");*/
        
        //-----------------------------------------------------------------------------------------------------------------
        // Se inicia con la interfaz de uso
        
        //Iniciar sesion
        
        boolean runGlobal, runIniciar, runInterctivo, runCorreccion;
        String opcionElegida_S;
        int opcionElegida_I;
        Scanner eleccion = new Scanner(System.in);
        
        runGlobal = true;
        runIniciar = true;
        runCorreccion = true;
        runInterctivo = true;
        
        while(runGlobal){
            while(runIniciar){
                System.out.println("----------------------");
                System.out.println("0) Salir");
                System.out.println("1) Iniciar Sesion");
                System.out.println("2) Registrarse");
                System.out.println("3) Visualizar la red social     (Proximamente)");
                System.out.println("----------------------");

                opcionElegida_S = eleccion.nextLine();

                opcionElegida_I = Integer.parseInt(opcionElegida_S);

                String name,password;
                
                switch (opcionElegida_I) {
                    // Cerrar el programa
                    case 0:
                        runGlobal = false;
                        runIniciar = false;
                        runInterctivo = false;
                        runCorreccion = false;
                        break;
                    // Funcion login
                    case 1:
                        runCorreccion = true;
                        while(runCorreccion){
                            System.out.println("Ingrese el nombre: ");
                            name = eleccion.nextLine();
                            System.out.println("Ingrese la contrase�a: ");
                            password = eleccion.nextLine();
                            if(SN.login(name, password)){
                                runIniciar = false;
                                runInterctivo = true;
                                runCorreccion = false;
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contrase�a erroneamente");
                            }
                        }
                        break;
                    // Funcion register
                    case 2:
                        runCorreccion = true;
                        while(runCorreccion){
                            System.out.println("Ingrese el nombre: ");
                            name = eleccion.nextLine();
                            System.out.println("Ingrese la contrase�a: ");
                            password = eleccion.nextLine();
                            if(SN.register(name, password)){
                                runIniciar = false;
                                runInterctivo = true;
                                runCorreccion = false;
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contrase�a erroneamente");
                            }
                        }
                        break;
                    case 3:
                        SN.visualize();
                        break;
                    // Caso que no existe
                    default:
                        System.out.println("La opcion no existe, vuelva a intentarlo");
                        break;
                }
            }
            
            User user = new User(10, "Algo", "123", Calendar.getInstance().getTime());
            
            user.setId(3);
        
            while(runInterctivo){
                System.out.println("----------------------");
                System.out.println("0) Salir");
                System.out.println("1) Hacer una publicacion        (Proximamente)");
                System.out.println("2) Seguir a una persona         (Proximamente)");
                System.out.println("3) Compartir una publicacion    (Proximamente)");
                System.out.println("4) Visualizar la red social     (Proximamente)");
                System.out.println("5) Comentar una publicacion     (Proximamente)");
                System.out.println("6) Dar like a una publicacion   (Proximamente)");
                System.out.println("7) Cerrar sesion");
                System.out.println("----------------------");

                opcionElegida_S = eleccion.nextLine();

                opcionElegida_I = Integer.parseInt(opcionElegida_S);
                String content, typePost_S;
                int typePost_I;
                
                switch (opcionElegida_I) {
                    // Cerrar el programa
                    case 0:
                        runGlobal = false;
                        runIniciar = false;
                        runInterctivo = false;
                        break;
                    // Funcion post
                    case 1:
                        System.out.println("Que publicacion desea crear?\nContenido: ");
                        content = eleccion.nextLine();
                        
                        runCorreccion = true;
                        System.out.println("Para quienes va dirigido?\n");
                        System.out.println("1) Para uno mismo\n");
                        System.out.println("2) Para otros\n\n");
                        
                        System.out.println("Eleccion\n");
                        typePost_S = eleccion.nextLine();
                        typePost_I = Integer.parseInt(typePost_S);
                        while(runCorreccion){
                            switch (typePost_I){
                                case 1:
                                    SN.post("Text", content);
                                    runCorreccion = false;
                                    break;
                                case 2:
                                    System.out.println("Usuarios posibles a elegir:\n");
                                    int i = 1;
                                    System.out.println("0) Salir\n----------------------------------\n");
                                    for(User userEleccion: SN.getListUser()){
                                        if(userEleccion.getFollowed().existFollow(SN.searchUserActive()) && SN.searchUserActive().getFollowed().existFollow(userEleccion)){
                                            System.out.println(String.valueOf(i)+") Usuario: "+ userEleccion.getName() + "\n----------------------------------\n");
                                            i++;
                                        }
                                    }
                                    
                                    i = 0;
                                    ArrayList<String> listString = new ArrayList();
                                    while(i < SN.getListUser().size()){
                                        String name;
                                        boolean esDistinto = true;
                                        System.out.println("Que usuario eligira? (Eliga el nombre (O escriba Salir))");
                                        name = eleccion.nextLine();
                                        if(name.toLowerCase().equals("salir")){
                                                i = 10;
                                        }
                                        else if(SN.existUser(name)){
                                            for(String nameList: listString){
                                                if(!nameList.equals(name)){
                                                    esDistinto = true;
                                                }
                                                else{
                                                    esDistinto = false;
                                                    System.out.println("Eliga un id distinto, ese ya fue elegido\n");
                                                }
                                            }
                                            if(esDistinto){
                                                listString.add(name);
                                                i++;
                                            }
                                        }
                                        else{
                                            System.out.println("Eliga un id existente\n");
                                        }
                                    }

                                    for(String algo: listString){
                                        System.out.println("Name: " + algo + "\n");
                                    }
                                    SN.post("Text", content, listString);
                                    runCorreccion = false;
                                    break;

                                
                                default:
                                    System.out.println("Error, no eligio correctamente");
                                    break;
                            }
                        }
                        break;
                    // Funcion follow
                    case 2:
                        System.out.println("Usuarios posibles a elegir:\n");
                        
                        boolean existe = false;
                        for(User userEleccion: SN.getListUser()){
                            for(User userListFollow :SN.searchUserActive().getFollowed().getListFollows()){
                                if(userListFollow.getName().equals(userEleccion.getName())){
                                    existe = true;
                                }
                            }
                            if(!existe){
                                System.out.println(String.valueOf(userEleccion.getId())+") Usuario: "+ userEleccion.getName() + "\n----------------------------------\n");
                            }
                            
                            String name;
                            System.out.println("Que usuario eligira? (Eliga su numero)");
                            name = eleccion.nextLine();
                            SN.follow(name);
                        }
                        
                        
                        break;
                    // Funcion share
                    case 3:
                        break;
                    // Funcion visualize
                    case 4:
                        SN.visualize();
                        break;
                    // Funcion comment
                    case 5:
                        break;
                    // Funcion like
                    case 6:
                        break;
                    // Funcion logout
                    case 7:
                        runIniciar = true;
                        runInterctivo = false;
                        runCorreccion = true;
                        SN.logout();
                        break;
                    // Caso que no existe
                    default:
                        System.out.println("La opcion no existe, vuelva a intentarlo");
                        break;
                }
            }
        }
        
    }
    
}
