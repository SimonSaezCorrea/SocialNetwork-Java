/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Es una clase que permite representar a un usuario
 * @author Simon Saez
 */
public class User {
    public int id; // Es el identificador de cada usuario
    private String name; // Es el nombre del usuario
    private String password; // Es la contraseña del usuario
    private boolean activity; // Es si el usuario se encuentra activo o no
    private ArrayList<Post> listPost; // Es donde se almacenan las publicaciones creadas hacia él
    private ArrayList<PostShare> listPostShare; // Es donde se almacenan las publicaciones compartidas a él
    private Date date; // Es la fecha de creacion del usuario
    private Follows followed; // Corresponde a las personas que sigue
    private Follows followers; // Corresponde a las personas que lo siguen

    /**
     * Construcor.
     * @param id El id del usuario.
     * @param name El nombre del usuario.
     * @param password La contraseña del usuario.
     * @param date La fecha de creacion del usuario.
     */
    public User(int id, String name, String password, Date date){
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = false;
        this.listPost = new ArrayList();
        this.listPostShare = new ArrayList();
        this.date = date;
        followed = new Follows();
        followers = new Follows();
    }

    /**
     * Constructor.
     * @param id El id del usuario.
     * @param name El nombre del usuario.
     * @param password La contraseña del usuario.
     * @param activity La actividad del usuario, si está activo o no.
     * @param listPost El arreglo de publicaciones del usuario.
     * @param listPostShare El arreglo de publicaciones compartidas del usuario.
     * @param date La fecha de creacion del usuario.
     * @param followed Las personas que sigue el usuario.
     * @param followers Las personas que siguen al usuario.
     */
    public User(int id, String name, String password, boolean activity, ArrayList<Post> listPost, ArrayList<PostShare> listPostShare, Date date, Follows followed, Follows followers) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = activity;
        this.listPost = listPost;
        this.listPostShare = listPostShare;
        this.date = date;
        this.followed = followed;
        this.followers = followers;
    }
    
    
    //--------------------------------------------- GET and SET --------------------------------------------------

    /**
     * Metodo que recoge el id del usuario.
     * @return El id del usuario.
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo que cambia el id del usuario.
     * @param id Es el id a cambiar para usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que recoge el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getName() {
        return name;
    }
    /**
     * Metodo que cambia el nombre del usuario.
     * @param name El nombre a cambiar para el usuario.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que recoge la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Metodo que cambia la contraseña del usuario.
     * @param password Es la contraseña a cambiar para usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo que recoge la actividad del usuario.
     * @return La actividad del usuario.
     */
    public boolean getActivity() {
        return activity;
    }
    /**
     * Metodo que cambia la actividad del usuario.
     * @param activity Es la actividad a cambiar para usuario.
     */
    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    /**
     * Metodo que recoge el arreglo de publicaciones del usuario.
     * @return El arreglo de publicaciones del usuario.
     */
    public ArrayList<Post> getListPost() {
        return listPost;
    }
    /**
     * Metodo que cambia el arreglo de publicaciones del usuario.
     * @param listPost Es el arreglo de publicaciones a cambiar para usuario.
     */
    public void setListPost(ArrayList<Post> listPost) {
        this.listPost = listPost;
    }
    /**
     * Metodo que añade una publicacion al arreglo del usuario.
     * @param post La publicacion a añadir.
     */
    public void addListPost(Post post){
        listPost.add(post);
    }

    /**
     * Metodo que recoge el arreglo de publicaciones compartidas del usuario.
     * @return El arreglo de publicaciones compartidas del usuario.
     */
    public ArrayList<PostShare> getListPostShare() {
        return listPostShare;
    }
    /**
     * Metodo que cambia el arreglo de publicaciones compartidas del usuario.
     * @param listPostShare Es el arreglo de publicaciones compartidas a cambiar para usuario.
     */
    public void setListPostShare(ArrayList<PostShare> listPostShare) {
        this.listPostShare = listPostShare;
    }
    /**
     * Metodo que añade una publicacion compartida al arreglo del usuario.
     * @param post La publicacion compartida a añadir.
     */
    public void addListPostShare(Post post, Date date){
        PostShare postShare = new PostShare(post, date);
        listPostShare.add(postShare);
    }

    /**
     * Metodo que recoge la fecha de creacion del usuario.
     * @return La fecha de creacion del usuario.
     */
    public Date getDate() {
        return date;
    }
    /**
     * Metodo que cambia la fecha de creacion del usuario.
     * @param date Es la fecha de creacion a cambiar para usuario.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Metodo que recoge los seguidos del usuario.
     * @return Los seguidos del usuario.
     */
    public Follows getFollowed() {
        return followed;
    }
    /**
     * Metodo que cambia los seguidos del usuario.
     * @param followed Son los seguidos a cambiar para usuario.
     */
    public void setFollowed(Follows followed) {
        this.followed = followed;
    }

    /**
     * Metodo que recoge los seguidores del usuario.
     * @return Los seguidores del usuario.
     */
    public Follows getFollowers() {
        return followers;
    }
    /**
     * Metodo que cambia los seguidores del usuario.
     * @param followers Son los seguidores a cambiar para usuario.
     */
    public void setFollowers(Follows followers) {
        this.followers = followers;
    }
    
    //---------------------------------------------- TO STRING ---------------------------------------------------
    
    /**
     * Metodo que transforma el contenido de la clase en un string a mostrar para mejor visibidad y ver los cambios.
     * @return Un string que contiene todo los datos a mostrar.
     */
    public String ToString(){
        String string = "";
        string = string + 
                "   ID: " + String.valueOf(getId()) + 
                "\n   Nombre: " + getName() + 
                "\n   Follows: " + String.valueOf(getFollowed().getAmountFollows()) + " | " + String.valueOf(getFollowers().getAmountFollows()) + 
                "\n   Lista de publicaciones en el perfil: \n";
        if(getListPost().isEmpty()){
            string = string + "      <No hay publicaciones>\n";
        }else{
            for(Post post: getListPost()){
                string = string +
                        post.ToString() + 
                        "-------------------------------------\n";
            }
        }
        string = string + "   Lista de publicaciones compartidas en el perfil: \n";
        if(getListPostShare().isEmpty()){
            string = string + "      <No hay publicaciones compartidas>\n";
        }else{
            for(PostShare postShare: getListPostShare()){
                string = string +
                        postShare.getPost().ToString() + 
                        "-------------------------------------\n";
            }
        }
        
        return string;
    }
    
}
