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
 *
 * @author Equipo
 */
public class Socialnetwork {
    private String name;
    private Date date;
    private ArrayList<User> listUser;
    private ArrayList<Post> listPost;
    private ArrayList<Comment> listComment;

    public Socialnetwork(String name, Date date) {
        this.name = name;
        this.date = date;
        this.listUser = new ArrayList();
        this.listPost = new ArrayList();
        this.listComment = new ArrayList();
    }
    
    public Socialnetwork(String name, Date date, ArrayList<User> listUser, ArrayList<Post> listPost, ArrayList<Comment> listComment) {
        this.name = name;
        this.date = date;
        this.listUser = listUser;
        this.listPost = listPost;
        this.listComment = listComment;
    }
    
    //------------------------------------- ACCIONABLE -------------------------------------------------------
    
    /**
     * Metodo que permite hacer login (conectar) de un usuario en la socialnetwork
     * @param name
     * @param password
     * @return Una sentencia booleana para saber si se ha registrado o no
     */
    public boolean login(String name, String password){
        if(existUser(name ,password)){
            User user = searchUser(name);
            user.setActivity(true);
            return true;
        }
        return false;
    }
    /**
     * Metodo que permite registrar y conectar a un nuevo usuario a la socialnetwork
     * @param name
     * @param password
     * @return Una sentencia booleana para saber si se ha registrado o no
     */
    public boolean register(String name, String password){
        if(!existUser(name, password)){
            User user = new User(createIDUser(), name, password, Calendar.getInstance().getTime());
            user.setActivity(true);
            addListUser(user);
            return true;
        }
        return false;
    }
    
    /**
     * Permite desconectar a una cuenta conectada en la socialnetwork
     */
    public void logout(){
        /*
        for(User user: listUser){
            if(user.getActivity()){
                user.setActivity(false);
            }
        }
        */
        listUser.forEach(user -> {
            if(user.getActivity()){
                user.setActivity(false);
            }
        });
    }
    
    public void post(String typePost, String content){
        
        User author = searchUserActive();
        
        if(author != null){
            Post post = new Post(createIDPost(), author, Calendar.getInstance().getTime(), content, typePost);
            addListPost(post);
            author.addListPost(post);
        }
    }
    public void post(String typePost, String content, ArrayList<User> listIdUser){
        
        User author = searchUserActive();
        
        if(author != null){
            Post post = new Post(createIDPost(), author, Calendar.getInstance().getTime(), content, typePost);
            addListPost(post);
            listIdUser.forEach(user -> {
                user.addListPost(post);
            });
        }
    }
    
    public void follow(int idUser){
        User user = searchUser(idUser);
        User userConnect = searchUserActive();
        
        userConnect.getFollowed().addListFollows(user);
        user.getFollowers().addListFollows(userConnect);
    }
    
    public void visualize(){
        PrintSocialNetwork(SocialNetworkToString());
    }
    
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
    
    private void PrintSocialNetwork(String string){
        System.out.println(string);
    }
    
    //--------------------------------------------------- CREACION ID -------------------------------------------------------
    
    /**
     * Metodo que permite encontrar el ID mayor de la lista de usuarios
     * @return El id a usar (int)
     */
    public int createIDUser(){
        return 1 + listUser.size();
    }
    
    /**
     * Metodo que permite encontrar el ID mayor de la lista de publicaciones
     * @return El id a usar (int)
     */
    public int createIDPost(){
        return 1 + listPost.size();
    }
    
    /**
     * Metodo que permite encontrar el ID mayor de la lista de comentarios
     * @return El id a usar (int)
     */
    public int createIDComment(){
        return 1 + listComment.size();
    }       
    
    //------------------------------------------------- EXISTENCIA --------------------------------------------------------
    
    /**
     * Metodo que permite saber si existe tal usuario
     * @param name
     * @return Una sentencia booleana que permite saber si existe el usuario o no
     */
    public boolean existUser(String name){
        for(User user: listUser){
            if(name.equals(user.getName())){
                return true;
            }
        }
        return false;
        
        //return listUser.stream().anyMatch(user -> (name.equals(user.getName())));
    }
    
    /**
     * Metodo que permite saber si existe tal usuario
     * @param name
     * @param password
     * @return Una sentencia booleana que permite saber si existe el usuario o no
     */
    public boolean existUser(String name, String password){
        for(User user : listUser){
            if(name.equals(user.getName()) && password.equals(user.getPassword())){
                return true;
            }
        }
        return false;
    
        //return listUser.stream().anyMatch(user -> (name.equals(user.getName()) && password.equals(user.getPassword())));
    }
    
    
    //-------------------------------------------------- SEARCH ----------------------------------------------------------
    
    public User searchUserActive(){
        
        for(User user : listUser){
            if(user.getActivity()){
                return user;
            }
        }
        User user = null;
        return user;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de usuarios un usuario
     * @param name
     * @return El usuario encontrado
     */
    public User searchUser(String name){
        for(User user : listUser){
            if(name.equals(user.getName())){
                return user;
            }
        }
        User user = null;
        return user;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de usuarios un usuario
     * @param id
     * @return El usuario encontrado
     */
    public User searchUser(int id){
        for(User user : listUser){
            if(id == user.getId()){
                return user;
            }
        }
        User user = null;
        return user;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de una publicacion una publicacion
     * @param id
     * @return La publicacion encontrado
     */
    public Post searchPost(int id){
        for(Post post : listPost){
            if(id == post.getId()){
                return post;
            }
        }
        Post post = null;
        return post;
    }
    
    /**
     * Metodo que permite buscar dentro de una lista de comentarios un comentario
     * @param id
     * @return El comentario encontrado
     */
    public Comment searchComment(int id){
        for(Comment comment : listComment){
            if(id == comment.getId()){
                return comment;
            }
        }
        Comment comment = null;
        return comment;
    }
    
    
    //--------------------------------------------- GET and SET --------------------------------------------------
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }
    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }
    public void addListUser(User user){
        listUser.add(user);
    }

    public ArrayList<Post> getListPost() {
        return listPost;
    }
    public void setListPost(ArrayList<Post> listPost) {
        this.listPost = listPost;
    }
    public void addListPost(Post post){
        listPost.add(post);
    }

    public ArrayList<Comment> getListComment() {
        return listComment;
    }
    public void setListComment(ArrayList<Comment> listComment) {
        this.listComment = listComment;
    }
    public void addListComment(Comment comment){
        listComment.add(comment);
    }
    
    
}
