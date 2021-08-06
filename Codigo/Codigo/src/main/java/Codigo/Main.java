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
        
        //Se añaden los usuarios
        SN.register("Simon", "123");
        SN.logout();
        SN.register("Maria", "abc");
        SN.logout();
        SN.register("Carlos", "1a2b3c4d");
        SN.logout();
        SN.register("Laura", "contraseña");
        SN.logout();
        SN.register("Anonimo", "*****");
        SN.logout();
        
        //Se añaden las preguntas y se hacen follows a su vez
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
        SN.post("text", "Y bueno, ¿Ahora que?");
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
        
        //Se añaden los comentarios
        
        //Se crean los comentarios iniciales de la socialnetwork
        /* Comment comment1 = new Comment(1, user1, Calendar.getInstance().getTime(), "Este es el primer comentario");
        Comment comment2 = new Comment(2, user4, Calendar.getInstance().getTime(), "Y yo el segundo comentario jeje");
        Comment comment3 = new Comment(3, user5, Calendar.getInstance().getTime(), "Lastima no poder comentar con una foto");
        Comment comment4 = new Comment(4, user5, Calendar.getInstance().getTime(), "Animo!");
        Comment comment5 = new Comment(5, user2, Calendar.getInstance().getTime(), "Se progresa rapido (?");*/
        
        //-----------------------------------------------------------------------------------------------------------------
        // Se inicia con la interfaz de uso
        
        // ~~~~~~~~~~~~~~~~~ General ~~~~~~~~~~~~~~~~~
        boolean runGlobal, runIniciar, runInteractivo, runCorreccion; // Se crean variables para declarar bucles tautologicos que completen una respuesta esperada
        String opcionElegida_S; // Se crea la variable que permite saber la opcion elegida en string
        int opcionElegida_I; // Se crea la variable que permite saber la opcion elegida en entero
        Scanner eleccion = new Scanner(System.in); // Se crea la variable Scanner para pedir cosas

        // ~~~~~~~~~~~~~~~~~ Inicio de sesion ~~~~~~~~~~~~~~~~~
        String name,password; // Declaro variables importantes para el inicio de sesion
        
        // ~~~~~~~~~~~~~~~~~ Interactiva ~~~~~~~~~~~~~~~~~
        String content, typePost_S; // Declaro variables importantes para la parte interactiva
        int typePost_I, i;
        boolean esDistinto, ejecucion;
        ArrayList<String> listUsers = new ArrayList();
        Post postComentar;
        Comment commentComentar;
        
        
        // °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° INICIO DEL MENU °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
        
        // Se coloca los datos necesarios para empezar a correr
        runGlobal = true; // bucle que es para el programa en general
        runIniciar = true; // bucle que es para el inicio (Inicio de sesion)
        runInteractivo = false; // bucle que es para la segunda fase, donde el usuario interactua
        
        
        // Inicia el bucle tautologico del programa en general
        while(runGlobal){
            
            // ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨ Iniciar sesion ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
            while(runIniciar){
                // Muestro las opciones
                System.out.println("----------------------");
                System.out.println("0) Salir");
                System.out.println("1) Iniciar Sesion");
                System.out.println("2) Registrarse");
                System.out.println("3) Visualizar la red social");
                System.out.println("----------------------");

                // Se las pido al usuario
                opcionElegida_S = eleccion.nextLine();
                opcionElegida_I = Integer.parseInt(opcionElegida_S);
                
                // Switch que permite comprobar la eleccion
                switch (opcionElegida_I) {
                    // Cerrar el programa
                    case 0:
                        // Para todo el programa
                        runGlobal = false;
                        runIniciar = false;
                        runInteractivo = false;
                        break;
                    // Funcion login
                    case 1:
                        runCorreccion = true; // bucle que es para comprobar que los datos sean correctos
                        // inicia el bucle
                        while(runCorreccion){
                            System.out.println("Ingrese el nombre: ");
                            name = eleccion.nextLine(); // Se pide el nombre
                            
                            System.out.println("Ingrese la contraseña: ");
                            password = eleccion.nextLine(); // Se pide la contraseña
                            
                            // Se comprueba que este correcto
                            if(SN.login(name, password)){
                                runIniciar = false; // Paro la primera fase
                                runInteractivo = true; // Pasa a la segunda fase de lo interactivo
                                runCorreccion = false; // La correccion se vuelve correcta, por lo que para
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contraseña erroneamente");
                            }
                        }
                        break;
                    // Funcion register
                    case 2:
                        runCorreccion = true; // bucle que es para comprobar que los datos sean correctos
                        // inicia el bucle
                        while(runCorreccion){
                            System.out.println("Ingrese el nombre: ");
                            name = eleccion.nextLine(); // Se pide el nombre
                            
                            System.out.println("Ingrese la contraseña: ");
                            password = eleccion.nextLine(); // Se pide la contraseña
                            
                            // Se comprueba que este correcto
                            if(SN.register(name, password)){
                                runIniciar = false; // Paro la primera fase
                                runInteractivo = true; // Pasa a la segunda fase de lo interactivo
                                runCorreccion = false; // La correccion se vuelve correcta, por lo que para
                            }
                            else{
                                System.out.println("Error al ingresar, ingreso nombre o contraseña erroneamente");
                            }
                        }
                        break;
                    // Mostrar los datos de la socialnetwork
                    case 3:
                        SN.visualize(); // Se muestra
                        break;
                    // Caso que no existe
                    default:
                        System.out.println("La opcion no existe, vuelva a intentarlo");
                        break;
                }
            }
            
            
            // ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨ Interactiva ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨
            while(runInteractivo){
                // Muestro todo lo que puede hacer
                System.out.println("----------------------");
                System.out.println("0) Salir");
                System.out.println("1) Hacer una publicacion");
                System.out.println("2) Seguir a una persona");
                System.out.println("3) Compartir una publicacion");
                System.out.println("4) Visualizar la red social");
                System.out.println("5) Comentar una publicacion");
                System.out.println("6) Dar like a una publicacion   (Proximamente)");
                System.out.println("7) Cerrar sesion");
                System.out.println("----------------------");

                // Pido la eleccion
                opcionElegida_S = eleccion.nextLine();
                opcionElegida_I = Integer.parseInt(opcionElegida_S);
                
                // Compruebo eleccion
                switch (opcionElegida_I) {
                    // Cerrar el programa
                    case 0:
                        // Paro todo el programa
                        runGlobal = false;
                        runIniciar = false;
                        runInteractivo = false;
                        break;
                    // Funcion post
                    case 1:
                        System.out.println("Que publicacion desea crear?\nContenido: ");
                        content = eleccion.nextLine(); // Pido el contenido de la publicacion
                        
                        runCorreccion = true;
                        // Muestro opciones para quien va dirijido
                        System.out.println("Para quienes va dirigido?\n");
                        System.out.println("0) Cancelar\n");
                        System.out.println("1) Para uno mismo\n");
                        System.out.println("2) Para otros\n\n");
                        
                        //Pido los datos
                        System.out.println("Eleccion: ");
                        typePost_S = eleccion.nextLine();
                        typePost_I = Integer.parseInt(typePost_S);
                        
                        //Compruebo si fue correcto
                        while(runCorreccion){
                            switch (typePost_I){
                                // Cancelar
                                case 0:
                                    runCorreccion = false;
                                    break;
                                // Para uno mismo
                                case 1:
                                    SN.post("Text", content); // Creo un post mediante la llamada del metodo post
                                    runCorreccion = false; // Digo que la correccion fue correcta y paro el bucle
                                    break;
                                // Para otros
                                case 2:
                                    // Muestro los usuarios a los que puede enviarlos
                                    System.out.println("Usuarios posibles a elegir:\n");
                                    i = 1;
                                    System.out.println("0) Salir\n----------------------------------\n");
                                    for(User userEleccion: SN.getListUser()){
                                        // Pregunto que el usuario userEleccion sigue al usuario activo y de la misma manera en viceversa, si se cumple muestro al usuario
                                        if(userEleccion.getFollowed().existFollow(SN.searchUserActive()) && SN.searchUserActive().getFollowed().existFollow(userEleccion)){
                                            System.out.println(String.valueOf(i)+") Usuario: "+ userEleccion.getName() + "\n----------------------------------\n");
                                            i++;
                                        }
                                    }
                                    
                                    // Pregunto a que usuario elegirá
                                    i = 0;
                                    listUsers.clear(); //Creo la lista donde se registrará
                                    
                                    while(i == 0){
                                        esDistinto = true;
                                        System.out.println("Que usuario eligira? (Eliga el nombre (O escriba Salir))");
                                        name = eleccion.nextLine(); // Pido el dato
                                        
                                        // -------- Empiezo a comprobar los casos ---------
                                        
                                        //Le da a salir, osea terminó de elegir a los usuarios
                                        if(name.toLowerCase().equals("salir")){
                                                i = 1;
                                        }
                                        //Eligio a un usuario y compruebo de que exista
                                        else if(SN.existUser(name)){
                                            //Compruebo de que el usuario elegido sea distinto al elegido anteriormente
                                            for(String nameList: listUsers){
                                                if(nameList.equals(name)){
                                                    esDistinto = false;
                                                    System.out.println("Eliga un user distinto, ese ya fue elegido\n");
                                                }
                                            }
                                            
                                            if(esDistinto){
                                                listUsers.add(name); //Agrego el usuario
                                            }
                                        }else{
                                            System.out.println("Eliga un user existente\n");
                                        }
                                    }
                                    
                                    SN.post("Text", content, listUsers); // Creo un post mediante la llamada del metodo post
                                    runCorreccion = false; // Digo que la correccion fue correcta y paro el bucle
                                    break;
                                // No coloco bien la cosas
                                default:
                                    System.out.println("Error, no eligio correctamente");
                                    break;
                            }
                        }
                        break;
                    // Funcion follow
                    case 2:
                        // Muestro los usuarios disponibles
                        System.out.println("Usuarios posibles a elegir:\n");
                        System.out.println("0) Salir\n----------------------------------\n");
                        i = 1;
                        
                        //Recorro la lista de usuarios
                        for(User userEleccion: SN.getListUser()){
                            // Pregunto que el userEleccion es distinto al usuario activo, si es asi paso a la segunda fase
                            if(!userEleccion.equals(SN.searchUserActive())){
                                // Recorro la lista de seguidores del usuario activo
                                for(User userListFollow :SN.searchUserActive().getFollowed().getListFollows()){
                                    // Pregunto que el userListFollow es distinto al usuario userEleccion, ya que significaria que no lo sigue y lo muestro
                                    if(!userListFollow.equals(userEleccion)){
                                        System.out.println(String.valueOf(i)+") Usuario: "+ userEleccion.getName() + "\n----------------------------------\n");
                                        i++;
                                    }
                                }
                            }
                        }
                        
                        // Pregunto a que usuario eligirá
                        System.out.println("Que usuario eligira? (Elige el nombre, en caso de salir escriba 'Salir')");
                        name = eleccion.nextLine(); //Pido el dato
                        
                        if(!name.toLowerCase().equals("salir")){
                            SN.follow(name); // Llamo el metodo follow para hacer la operacion
                        }
                        
                        
                        break;
                    // Funcion share
                    case 3:
                        // Muestro las publicaciones disponibles
                        System.out.println("Que publicacion desea elegir?\n");
                        System.out.println("0) Salir\n----------------------------------\n");
                        // Recorro la lista de publicaciones y muestro la publicacion
                        for(Post mostrarPost: SN.getListPost()){
                            System.out.println(String.valueOf(mostrarPost.getId())+") Contenido: "+ mostrarPost.getContent()+ "\n----------------------------------\n");
                        }
                        
                        runCorreccion = true;
                        ejecucion = false;
                        while(runCorreccion){
                            //Pido los datos
                            typePost_S = eleccion.nextLine();
                            typePost_I = Integer.parseInt(typePost_S);
                            
                            //-------- Compruebo que hayan sido correctamente puestos --------
                            // Cancela la operacion
                            if(typePost_I == 0){
                                runCorreccion = false;
                            }
                            // Elige una pregunta
                            else if(typePost_I > 0 && typePost_I <= SN.getListPost().size()){
                                ejecucion = true;
                                runCorreccion = false;
                            }
                            // Elige erroneamente
                            else{
                                System.out.println("No se eligio un post existente\n");
                            }
                        }
                        
                        // Hace la operacion de share
                        if(ejecucion){
                            runCorreccion = true;
                            
                            // Muestro las opciones
                            System.out.println("Para quienes va dirigido?\n");
                            System.out.println("0) Cancelar\n");
                            System.out.println("1) Para uno mismo\n");
                            System.out.println("2) Para otros\n\n");

                            // Pido los datos
                            System.out.println("Eleccion\n");
                            typePost_S = eleccion.nextLine();
                            typePost_I = Integer.parseInt(typePost_S);
                            
                            // Arreglo que los almacenará
                            listUsers.clear();
                            
                            // Comienzo el bucle de seleccion
                            while(runCorreccion){
                                switch (typePost_I){
                                    // Cancela la operacion
                                    case 0:
                                        runCorreccion = false;
                                        break;
                                    // Elige que sea para si mismo
                                    case 1:
                                        listUsers.add(SN.searchUserActive().getName()); // Añado al arraylist
                                        SN.share(typePost_I, listUsers); // Llamo al metodo share para efectuar la operacion
                                        runCorreccion = false; // Termino el ciclo de manera exitosa
                                        break;
                                    // Elige que sea para otros
                                    case 2:
                                        // Muestro los usuarios disponibles
                                        System.out.println("Usuarios posibles a elegir:\n");
                                        i = 1;
                                        System.out.println("0) Salir\n----------------------------------\n");
                                        // Recorro la lista de usuarios
                                        for(User userEleccion: SN.getListUser()){
                                            // Pregunto que el usuario userEleccion sigue al usuario activo y de la misma manera en viceversa, si se cumple muestro al usuario
                                            if(userEleccion.getFollowed().existFollow(SN.searchUserActive()) && SN.searchUserActive().getFollowed().existFollow(userEleccion)){
                                                System.out.println(String.valueOf(i)+") Usuario: "+ userEleccion.getName() + "\n----------------------------------\n");
                                                i++;
                                            }
                                        }
                                        
                                        // Comienza un ciclo de eleccion
                                        i = 0;
                                        while(i == 0){
                                            // Empiezo a pedir los datos
                                            esDistinto = true;
                                            System.out.println("Que usuario eligira? (Eliga el nombre (O escriba Salir))");
                                            name = eleccion.nextLine();
                                            
                                            // Termina de elegir
                                            if(name.toLowerCase().equals("salir")){
                                                    i = 1;
                                            }
                                            // Elige a un usuario
                                            else if(SN.existUser(name)){
                                                // Recorro la lista de usuarios
                                                for(String nameList: listUsers){
                                                    // Pregunto si ya fue elegido aquel usuario
                                                    if(nameList.equals(name)){
                                                        esDistinto = false;
                                                        System.out.println("Eliga un user distinto, ese ya fue elegido\n");
                                                    }
                                                }
                                                // Compruebo de que sea distinto
                                                if(esDistinto){
                                                    listUsers.add(name); // Lo agrego
                                                }
                                            }
                                            // Elige incorrectamente
                                            else{
                                                System.out.println("Eliga un user existente\n");
                                            }
                                        }

                                        SN.share(typePost_I, listUsers); // Llamo al metodo share para afectuar la operacion
                                        runCorreccion = false; // Termino el ciclo de manera exitosa
                                        break;
                                    // No elige correctamente
                                    default:
                                        System.out.println("Error, no eligio correctamente");
                                        break;
                                }
                            }
                        }
                        
                        break;
                    // Funcion visualize
                    case 4:
                        SN.visualize(); // Muestro al usuario
                        break;
                    // Funcion comment
                    case 5:
                        //Muestro las publicaciones
                        System.out.println("Que publicacion desea elegir? (Elija su id)\n");
                        System.out.println("0) Salir\n----------------------------------\n");
                        
                        // Recorro la lista de publicaciones
                        for(Post mostrarPost: SN.getListPost()){
                            // Pregunto si el autor de ese post sigue al usuario activo y de manera viceversa tambien o si el autor es el usuario activo
                            if((SN.searchUser(mostrarPost.getAuthor().getName()).getFollowers().existFollow(SN.searchUserActive()) && 
                                    SN.searchUser(mostrarPost.getAuthor().getName()).getFollowed().existFollow(SN.searchUserActive())) || 
                                    SN.searchUserActive().equals(mostrarPost.getAuthor())){
                                System.out.println(String.valueOf(mostrarPost.getId())+") Contenido: "+ mostrarPost.getContent()+ "\n----------------------------------\n");
                            }
                        }
                        
                        // Inicio la eleccion de la pregunta
                        runCorreccion = true;
                        ejecucion = false;
                        postComentar = null;
                        while(runCorreccion){
                            //Pido los datos
                            typePost_S = eleccion.nextLine();
                            typePost_I = Integer.parseInt(typePost_S);
                            
                            //Cancela la operacion
                            if(typePost_I == 0){
                                runCorreccion = false;
                            }
                            //Elige una pregunta existente
                            else if(typePost_I > 0 && typePost_I <= SN.getListPost().size()){
                                ejecucion = true; // Inicio el nivel de ejecucion
                                postComentar = SN.searchPost(typePost_I); // Busco el post
                                runCorreccion = false; // Termino la eleccion de preguntas
                            }
                            //Elige una opcion no existente
                            else{
                                System.out.println("No se eligio un post existente\n");
                            }
                        }
                        
                        // Comienza la segunda fase
                        if(ejecucion){
                            //Muestro los comentarios existentes en ese post
                            System.out.println("Que comentario desea elegir? (Elija su id)\n");
                            System.out.println("0) Ninguno\n----------------------------------\n");
                            for(Comment mostrarComment: postComentar.getListComment()){
                                System.out.println(String.valueOf(mostrarComment.getId())+") Contenido: "+ mostrarComment.getContent()+ "\n----------------------------------\n");
                            }
                            
                            // Comienza el ciclo de eleccion
                            runCorreccion = true;
                            while(runCorreccion){
                                // Pido los datos
                                typePost_S = eleccion.nextLine();
                                typePost_I = Integer.parseInt(typePost_S);
                                
                                // No elige un comentario
                                if(typePost_I == 0){
                                    // Pido el comentario que hará
                                    System.out.println("Que desea comentar?\n");
                                    content = eleccion.nextLine();
                                    
                                    SN.comment(postComentar, content); // Llamo al metodo comment y efectuo la operacion
                                    runCorreccion = false; // Termino con exito la operacion
                                }
                                // Elige un comentario
                                else if(typePost_I > 0 && typePost_I <= SN.getListPost().size()){
                                    // Pido el comentario que hará
                                    commentComentar = SN.searchComment(typePost_I);
                                    System.out.println("Que desea comentar?\n");
                                    content = eleccion.nextLine();
                                    
                                    SN.comment(commentComentar, content); // Llamo al metodo comment y efectuo la operacion
                                    runCorreccion = false; // Termino con exito la operacion
                                }
                                // Eleccion no existente
                                else{
                                    System.out.println("No se eligio un comentario existente\n");
                                }
                            }
                        }
                        break;
                    // Funcion like
                    case 6:
                        break;
                    // Funcion logout
                    case 7:
                        runIniciar = true; // Vuelve al inicio de sesion
                        runInteractivo = false; // Termina de operar en la interaccion
                        SN.logout(); // Llama a la funcion logout y efectuar su operacion
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
