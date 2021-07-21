/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

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
        
        //Se crean los usuarios iniciales de la socialnetwork
        User user1 = new User(1, "Simon", "123", Calendar.getInstance().getTime());
        User user2 = new User(2, "Maria", "abc", Calendar.getInstance().getTime());
        User user3 = new User(3, "Carlos", "1a2b3c4d", Calendar.getInstance().getTime());
        User user4 = new User(4, "Laura", "contraseña", Calendar.getInstance().getTime());
        User user5 = new User(5, "Anonimo", "*****", Calendar.getInstance().getTime());
        
        //Se cren los post iniciales de la socialnetwork
        Post post1 = new Post(1, user1, Calendar.getInstance().getTime(), "Este es el primer post", "text");
        Post post2 = new Post(2, user2, Calendar.getInstance().getTime(), "Soy el segundo jaja", "text"); 
        Post post3 = new Post(3, user3, Calendar.getInstance().getTime(), "La primera imagen? Aunque es textual...", "photo");
        Post post4 = new Post(4, user1, Calendar.getInstance().getTime(), "Se va avanzando", "text");
        Post post5 = new Post(5, user1, Calendar.getInstance().getTime(), "Ya van siendo varios post de la gente, fantastico", "text");
        
        //Se crean los comentarios iniciales de la socialnetwork
        Comment comment1 = new Comment(1, user1, Calendar.getInstance().getTime(), "Este es el primer comentario");
        Comment comment2 = new Comment(2, user4, Calendar.getInstance().getTime(), "Y yo el segundo comentario jeje");
        Comment comment3 = new Comment(3, user5, Calendar.getInstance().getTime(), "Lastima no poder comentar con una foto");
        Comment comment4 = new Comment(4, user5, Calendar.getInstance().getTime(), "Animo!");
        Comment comment5 = new Comment(5, user2, Calendar.getInstance().getTime(), "Se progresa rapido (?");
        
        //Se crea la socialnetwork
        Socialnetwork SN = new Socialnetwork("TheNewSocial", Calendar.getInstance().getTime());
        
        //Se añaden los usuarios
        SN.addListUser(user1);
        SN.addListUser(user2);
        SN.addListUser(user3);
        SN.addListUser(user4);
        SN.addListUser(user5);
        
        //Se añaden los post
        SN.addListPost(post1);
        SN.addListPost(post2);
        SN.addListPost(post3);
        SN.addListPost(post4);
        SN.addListPost(post5);
        
        //Se añaden los comentarios
        SN.addListComment(comment1);
        SN.addListComment(comment2);
        SN.addListComment(comment3);
        SN.addListComment(comment4);
        SN.addListComment(comment5);
        
        //Se añaden los comentarios a los post
        post1.addListComment(comment1);
        post2.addListComment(comment2);
        post3.addListComment(comment3);
        post4.addListComment(comment4);
        post4.addListComment(comment5);
        
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
                System.out.println("1) Iniciar Sesion   (Proximamente)");
                System.out.println("2) Registrarse      (Proximamente)");
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
                            System.out.println("Ingrese la contraseña: ");
                            password = eleccion.nextLine();
                            if(SN.login(name, password)){
                                runIniciar = false;
                                runInterctivo = true;
                                runCorreccion = false;
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contraseña erroneamente");
                            }
                        }
                        break;
                    // Funcion register
                    case 2:
                        runInterctivo = true;
                        while(runInterctivo){
                            System.out.println("Ingrese el nombre: ");
                            name = eleccion.nextLine();
                            System.out.println("Ingrese la contraseña: ");
                            password = eleccion.nextLine();
                            if(SN.register(name, password)){
                                runIniciar = false;
                                runInterctivo = true;
                                runCorreccion = false;
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contraseña erroneamente");
                            }
                        }
                        break;
                    // Caso que no existe
                    default:
                        System.out.println("La opcion no existe, vuelva a intentarlo");
                        break;
                }
            }
            
            
            while(runInterctivo){
                System.out.println("----------------------");
                System.out.println("0) Salir");
                System.out.println("1) Hacer una publicacion        (Proximamente)");
                System.out.println("2) Seguir a una persona         (Proximamente)");
                System.out.println("3) Compartir una publicacion    (Proximamente)");
                System.out.println("4) Visualizar la red social     (Proximamente)");
                System.out.println("5) Comentar una publicacion     (Proximamente)");
                System.out.println("6) Dar like a una publicacion   (Proximamente)");
                System.out.println("7) Cerrar sesion                (Proximamente)");
                System.out.println("----------------------");

                opcionElegida_S = eleccion.nextLine();

                opcionElegida_I = Integer.parseInt(opcionElegida_S);
                
                switch (opcionElegida_I) {
                    // Cerrar el programa
                    case 0:
                        runGlobal = false;
                        runIniciar = false;
                        runInterctivo = false;
                        break;
                    // Funcion post
                    case 1:
                        break;
                    // Funcion follow
                    case 2:
                        break;
                    // Funcion share
                    case 3:
                        break;
                    // Funcion visualize
                    case 4:
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
