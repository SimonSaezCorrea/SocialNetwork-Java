/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Es una clase que representa a una red social.
 * Para ello tiene un nombre y su fecha de creacion.
 * Ademas de que contiene usuarios, publicaciones y comentarios.
 * @author Simon Saez
 */
public class Socialnetwork implements Accionable{
    private String name; // Nombre de la socialnetwork
    private Date date; // Fecha de creacion
    private ArrayList<User> listUser; // Lista de usuarios que contiene la socialnetwork
    private ArrayList<Post> listPost; // Lista de publicaciones que contiene la socialnetwork
    private ArrayList<Comment> listComment; // Lista de comentarios que contiene la socialnetwork

    /**
     * Constructor.
     * @param name Nombre de la socialnetwork.
     * @param date Fecha de creacion de la socialnetwork.
     */
    public Socialnetwork(String name, Date date) {
        this.name = name;
        this.date = date;
        this.listUser = new ArrayList();
        this.listPost = new ArrayList();
        this.listComment = new ArrayList();
    }
    
    //------------------------------------- ACCIONABLE -------------------------------------------------------
    
    /**
     * Metodo que permite hacer login (conectar) de un usuario de la socialnetwork y retornar una verificacion booleana para saber si se activo o no.
     * @param name Nombre del usuario a conectar en la socialnetwork.
     * @param password Contrase�a del usuario a conectar en la socialnetwork.
     * @return Verificacion de conectividad.
     */
    public boolean login(String name, String password){
        if(existUser(name ,password)){
            User user = searchUser(name);
            user.setActivity(true);
            System.out.println("El usuario " + user.getName() + " se conecto a la red social");
            return true;
        }
        System.out.println("El usuario no existe");
        return false;
    }
    /**
     * Metodo que permite registrar y conectar a un nuevo usuario a la socialnetwork y retornar una verificacion booleana para saber si se creo y que en consecuencia tambien se conecta.
     * @param name Nombre del usuario a crear.
     * @param password Contrase�a del usuario a crear.
     * @return Verificacion de creacion y a su vez de conectividad.
     */
    @Override
    public boolean register(String name, String password){
        if(!existUser(name, password)){
            User user = new User(createIDUser(), name, password, Calendar.getInstance().getTime());
            user.setActivity(true);
            addListUser(user);
            System.out.println("El usuario " + user.getName() + " se creo y conecto a la red social");
            return true;
        }
        System.out.println("El usuario ya existe");
        return false;
    }
    
    /**
     * Permite desconectar a una cuenta conectada en la socialnetwork.
     */
    @Override
    public void logout(){
        
        System.out.println("El usuario " + searchUserActive().getName() + " se desconecto de la red social\n\n");
        
        searchUserActive().setActivity(false);
    }
    
    /**
     * Metodo que permite crear un post hacia si mismo.
     * @param typePost Tipo de publicacion a hacer (Puede ser "Text", "Photo", "Video", "Audio").
     * @param content Contenido de la publicion que se va a hacer.
     */
    @Override
    public void post(String typePost, String content){
        
        User author = searchUserActive();
        
        if(author != null){
            Post post = new Post(createIDPost(), author, Calendar.getInstance().getTime(), content, typePost);
            addListPost(post);
            author.addListPost(post);
            System.out.println("Publicaciones creada correctamente");
        }
    }
    /**
     * Metodo que permite crear una publicacion hacia otros usuarios (Mas de uno).
     * Los usuarios deben seguirse mutuamente para efectuar la publicacion entre ambos, es decir que el usuario que envia debe seguir al es enviado y viceversa tambien.
     * En otras formas si un user1 envia a un user2, el user 1 debe seguir al user 2 y el user 2 debe seguir al user1.
     * @param typePost Tipo de publicacion a hacer (Puede ser "Text", "Photo", "Video", "Audio").
     * @param content Contenido de la publicion que se va a hacer.
     * @param listStringUser Arreglo de nombres de usuarios a enviar la publicacion.
     */
    @Override
    public void post(String typePost, String content, ArrayList<String> listStringUser){
        
        User author = searchUserActive();
        boolean seEnvioUno = false;
        if(author != null){
            Post post = new Post(createIDPost(), author, Calendar.getInstance().getTime(), content, typePost);
            for(String nameUser: listStringUser){
                if(existUser(nameUser)){
                    User user = searchUser(nameUser);
                    if(user.getFollowers().existFollow(author) && user.getFollowed().existFollow(author)){
                        user.addListPost(post);
                        seEnvioUno = true;
                        System.out.println("Publicacion enviada correctamente a "+user.getName());
                    }
                    else{
                        System.out.println("No se puede enviar el post a "+ user.getName() +", no se siguen mutuamente");
                    }
                }
                else{
                    System.out.println("No existe el Usuario" + nameUser + "para enviarle el post");
                }
            }
            if(seEnvioUno){
                addListPost(post);
                System.out.println("Publicaciones enviadas correctamente");
            }
        }
    }
    
    /**
     * Metodo que permite hacer follow a un usuarios distinto al que lo hace.
     * Es decir que un user1 no puede seguir a user1, porque no se puede seguir a si mismo.
     * @param name El nombre del usuario a seguir.
     */
    @Override
    public void follow(String name){
        
        User userConnect = searchUserActive();
        if(!name.equals(userConnect.getName())){
            if(existUser(name)){
                User user = searchUser(name);

                userConnect.getFollowed().addListFollows(user);
                user.getFollowers().addListFollows(userConnect);
                
                System.out.println("El usuario " + userConnect.getName() + " sigue a " + user.getName());
            }else{
                System.out.println("El usuario no existe");
            }
        }else{
            System.out.println("No puedes seguir a ti mismo");
        }
        
    }
    
    /**
     * Metodo que permite compartir un post a usuarios (Y a si mismo tambien).
     * Los usuarios deben seguirse mutuamente para efectuar la publicacion entre ambos, es decir que el usuario que envia debe seguir al es enviado y viceversa tambien.
     * En otras formas si un user1 envia a un user2, el user 1 debe seguir al user 2 y el user 2 debe seguir al user1.
     * 
     * Cabe desctacar que si user1 envia una publicacion a user1, no es necesario seguirse porque es imposible que se pueda seguir.
     * @param idPost Es el id de la publicacion.
     * @param listUser Un arreglo de usuarios a la que va dirijida.
     */
    @Override
    public void share(int idPost, ArrayList<String> listUser){
        Post post = searchPost(idPost);
        for(String nameUser: listUser){
            if(existUser(nameUser)){
                User user = searchUser(nameUser);
                if(user.getName().equals(searchUserActive().getName())){
                    user.addListPostShare(post, Calendar.getInstance().getTime());
                    System.out.println("La publicacion se compartio correctamente a su cuenta");
                }
                else if(user.getFollowers().existFollow(searchUserActive()) && user.getFollowed().existFollow(searchUserActive())){
                    user.addListPostShare(post, Calendar.getInstance().getTime());
                    System.out.println("La publicacion se compartio correctamente a la cuenta de " + user.getName());
                }                
                else{
                    System.out.println("No se puede compartir, no se siguen mutuamente");
                }
            }
            else{
                System.out.println("No existe el usuario " + nameUser + "\n");
            }
            
        }
    }
    
    /**
     * Metodo que permite visualizar una socialnetwork o el usuario activo.
     */
    @Override
    public void visualize(){
        PrintSocialNetwork(SocialNetworkToString());
    }
    /**
     * Metodo que permite extraer un string del socialnetwork.
     * @return Un string donde contiene todo los datos necesarios para mostrar.
     */
    private String SocialNetworkToString(){
        String string = "";
        
        User userActivo = searchUserActive();
        
        if(userActivo != null){
            string = string + userActivo.ToString();
            return string;
        }
        
        string = string + 
                "Nombre: " + getName() +
                "\nUsuarios inscritos: \n";
        for(User users: listUser){
            string = string +
                    users.ToString() +
                    "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n";
        }
        
        return string;
    }
    /**
     * Metodo que permite mostrar la socialnetwork o usuario activo.
     * @param string Un texto que se va a mostrar.
     */
    private void PrintSocialNetwork(String string){
        System.out.println(string);
    }
    
    /**
     * Metodo que permite hacer un comentario a un post.
     * @param post Es a la publicacion que va dirijida.
     * @param text Es el comentario que se desea colocar.
     */
    @Override
    public void comment(Post post, String text){
        User author = searchUserActive();
        if(author != null){
            Comment comment = new Comment(createIDComment(), searchUserActive(), Calendar.getInstance().getTime(), text);
            User user = post.getAuthor();
            if(author.getFollowers().existFollow(user) && author.getFollowed().existFollow(user) || author.equals(user)){
                addListComment(comment);
                post.addListComment(comment);
                System.out.println("Cometario enviado correctamente a la publicacion " + post.getId());
            }
            else{
                System.out.println("No se puede enviar el comentario a la publicacion "+ post.getId() + ", no se siguen mutuamente (el autor con el que envia el comentario)");
            }
        }   
    }
    /**
     * Metodo que permite hacer un comentario a un comentario.
     * @param comment Es al comentario que va dirijida.
     * @param text Es el comentario que se desea colocar.
     */
    @Override
    public void comment(Comment comment, String text){
        User author = searchUserActive();
        if(author != null){
            Comment commentComment = new Comment(createIDComment(), searchUserActive(), Calendar.getInstance().getTime(), text);
            User user = comment.getAuthor();
            if(user.getFollowers().existFollow(author) && user.getFollowed().existFollow(author) || author.equals(user)){
                addListComment(commentComment);
                comment.addListComment(commentComment);
                System.out.println("Cometario enviado correctamente al comentario " + comment.getId());
            }
            else{
                System.out.println("No se puede enviar el comentario al comentario "+ comment.getId() + ", no se siguen mutuamente (el autor con el que envia el comentario)");
            }
        }else{
            System.out.println("No hay un usuario conectado");
        }
    }
    
    /**
     * Metodo que permite dar like a un comentario
     * @param comment El comentario a dar like
     */
    @Override
    public void like(Comment comment){
        User author = searchUserActive();
        if(author != null){
            Like like = new Like(comment.creatIdLike(), Calendar.getInstance().getTime(), searchUserActive());
            User user = comment.getAuthor();
            if(user.getFollowers().existFollow(author) && user.getFollowed().existFollow(author)){
                comment.addListLike(like);
                System.out.println("Like enviado correctamente al comentario " + comment.getId());
            }
            else{
                System.out.println("No se puede enviar el Like al comentario "+ comment.getId() + ", no se siguen mutuamente (el autor con el que envia el comentario)");
            }
        }else{
            System.out.println("No hay un usuario conectado");
        }
        
        
    }
    /**
     * Metodo que permite dar like a una publicacion
     * @param post La publicacion a dar like
     */
    @Override
    public void like(Post post){
        User author = searchUserActive();
        if(author != null){
            Like like = new Like(post.creatIdLike(), Calendar.getInstance().getTime(), searchUserActive());
            User user = post.getAuthor();
            if(user.getFollowers().existFollow(author) && user.getFollowed().existFollow(author)){
                post.addListLike(like);
                System.out.println("Like enviado correctamente a la publicacion " + post.getId());
            }
            else{
                System.out.println("No se puede enviar el Like a la publicacion "+ post.getId() + ", no se siguen mutuamente (el autor con el que envia el comentario)");
            }
        }else{
            System.out.println("No hay un usuario conectado");
        }
        
        
        
    }
    
    //--------------------------------------------------- CREACION ID -------------------------------------------------------
    
    /**
     * Metodo que permite crear el siguiente id del arreglo de usuarios.
     * @return el id siguiente que corresponde.
     */
    private int createIDUser(){
        return 1 + listUser.size();
    }
    
    /**
     * Metodo que permite crear el siguiente id del arreglo de publicaciones.
     * @return el id siguiente que corresponde.
     */
    private int createIDPost(){
        return 1 + listPost.size();
    }
    
    /**
     * Metodo que permite crear el siguiente id del arreglo de comentarios.
     * @return el id siguiente que corresponde.
     */
    private int createIDComment(){
        return 1 + listComment.size();
    }       
    
    //------------------------------------------------- EXISTENCIA --------------------------------------------------------
    
    /**
     * Metodo que permite saber si existe tal usuario mediante el nombre.
     * @param name Es el nombre del usuario que se desea saber su existencia.
     * @return Una sentencia para saber si existe.
     */
    public boolean existUser(String name){
        
        int i;
        for(i = 0; i < listUser.size(); i++){
            if(name.equals(listUser.get(i).getName())){
                return true;
            }
        }
        
        for(User user: listUser){
            if(name.equals(user.getName())){
                return true;
            }
        }
        return false;                                   
    }
    
    /**
     * Metodo que permite saber si existe tal usuario mediante su nombre y la contrase�a.
     * @param name Es el nombre del usuario que se desea saber su existencia.
     * @param password Es la contrase�a del usuario que se desea saber su existencia.
     * @return Una sentencia para saber si existe.
     */
    public boolean existUser(String name, String password){
        for(User user : listUser){
            if(name.equals(user.getName()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que permite saber si existe tal usuario mediante su id.
     * @param id Es el id del usuario que se desea saber su existencia.
     * @return Una sentencia para saber si existe.
     */
    public boolean existUser(int id){
        for(User user: listUser){
            if(id == user.getId()){
                return true;
            }
        }
        return false;
    }
    
    
    //-------------------------------------------------- SEARCH ----------------------------------------------------------
    
    /**
     * Metodo que permite buscar dentro de la lista de usuarios a un usuario que este activo.
     * @return El usuario encontrado en la lista de usuarios.
     */
    public User searchUserActive(){
        
        for(User user : listUser){
            if(user.getActivity()){
                return user;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de usuarios a un usuario mediante su nombre.
     * @param name Es el nombre del usuario que se desea buscar.
     * @return El usuario encontrado en la lista de usuarios.
     */
    public User searchUser(String name){
        for(User user : listUser){
            if(name.equals(user.getName())){
                return user;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de usuarios un usuario mediante su id.
     * @param id Es el id del usuario que se desea buscar.
     * @return El usuario encontrado en la lista de usuarios.
     */
    public User searchUser(int id){
        for(User user : listUser){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de una publicacion una publicacion mediante su id.
     * @param id Es el id de la publicacion que se desea buscar.
     * @return El post encontrado en la lista de publicaciones.
     */
    public Post searchPost(int id){
        for(Post post : listPost){
            if(id == post.getId()){
                return post;
            }
        }
        return null;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de comentarios un comentario mediante su id.
     * @param id Es el id del comentario que se desea buscar.
     * @return El comentario encontrado en la lista de comentarios.
     */
    public Comment searchComment(int id){
        for(Comment comment : listComment){
            if(id == comment.getId()){
                return comment;
            }
        }
        return null;
    }
    
    
    //--------------------------------------------- GET and SET --------------------------------------------------
    
    /**
     * Metodo que recoge el nombre de la socialnetwork.
     * @return El nombre de la socialnetwork.
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo que cambia el nombre de la socialnetwork.
     * @param name El nombre por el que se desea cambiar.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que recoge la fecha de creacion de la socialnetwork.
     * @return La fecha de creacion.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Metodo que cambia la fecha de creacion de la socialnetwork.
     * @param date La fecha de creacion por la que se desea cambiar.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Metodo que recoge el arreglo de usuario de la socialnetwork.
     * @return El arreglo de usuarios.
     */
    public ArrayList<User> getListUser() {
        return listUser;
    }
    /**
     * Metodo que cambia el arreglo de usuarios de la socialnetwork.
     * @param listUser Es el arreglo de usuarios por el que se desea cambiar.
     */
    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }
    /**
     * Metodo que permite a�adir un elemento al arreglo de usuarios.
     * @param user Es el usuario que se desea agregar.
     */
    public void addListUser(User user){
        listUser.add(user);
    }

    /**
     * Metodo que recoge el arreglo de publicaciones de la socialnetwork.
     * @return El arreglo de publicaciones.
     */
    public ArrayList<Post> getListPost() {
        return listPost;
    }
    /**
     * Metodo que cambia el arreglo de publicaciones de la socialnetwork.
     * @param listPost Es el arreglo de publicacion que se desea cambiar.
     */
    public void setListPost(ArrayList<Post> listPost) {
        this.listPost = listPost;
    }
    /**
     * Metodo que permite a�adir un elemento al arreglo de publicaciones.
     * @param post Es la publicacion que se desea agregar.
     */
    public void addListPost(Post post){
        listPost.add(post);
    }

    /**
     * Metodo que recoge el arreglo de comentarios de la socialnetwork.
     * @return El arreglo de comentarios.
     */
    public ArrayList<Comment> getListComment() {
        return listComment;
    }
    /**
     * Metodo que cambia el arreglo de comentarios de la socialnetwork.
     * @param listComment Es el arreglo de comentarios que se desea cambiar.
     */
    public void setListComment(ArrayList<Comment> listComment) {
        this.listComment = listComment;
    }
    /**
     * Metodo que permite a�adir un elemento al arreglo de comentarios.
     * @param comment Es el comentario que se desea agregar.
     */
    public void addListComment(Comment comment){
        listComment.add(comment);
    }
    
    
}
