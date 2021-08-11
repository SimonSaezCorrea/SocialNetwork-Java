/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Es una clase abstracta que permite representar la informacion de la publicacion y del comentario
 * @author Simon Saez
 */
public abstract class Information {
    private int id; // Es el id
    private User author; // Es el creador
    private Date date; // Es la fecha de creacion
    private String content; // Es el contenido
    private ArrayList<Comment> listComment; // Es una lista de comentarios
    private int like; // La cantidad de likes
    private ArrayList<Like> listLike; // Una lista de likes

    /**
     * Constructor
     * @param id El id
     * @param author El creador
     * @param date La fecha de creacion
     * @param content El contenido
     */
    public Information(int id, User author, Date date, String content) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.content = content;
        this.listComment = new ArrayList();
        this.like = 0;
        this.listLike = new ArrayList();
    }

    /**
     * Metodo que permite recoger el id de la clase
     * @return El id de la clase
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo que permite cambiar el id de la clase
     * @param id El id a cambiar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que permite recoger el autor de la clase
     * @return El autor de la clase
     */
    public User getAuthor() {
        return author;
    }
    /**
     * Metodo que permite cambiar el autor de la clase
     * @param author El autor a cambiar
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    
    /**
     * Metodo que permite recoger la fecha de creacion de la clase
     * @return La fecha de creacion
     */
    public Date getDate() {
        return date;
    }
    /**
     * Metodo que permite cambiar la fecha de creacion de la clase
     * @param date La fecha a cambiar
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Metodo que permite recoger el contenido de la clase
     * @return El contenido
     */
    public String getContent() {
        return content;
    }
    /**
     * Metodo que permite cambiar el contenido de la clase
     * @param content El contenido a cambiar
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Metodo que permite recoger la lista de comentarios de la clase
     * @return La lista de comentarios
     */
    public ArrayList<Comment> getListComment() {
        return listComment;
    }
    /**
     * Metodo que permite cambiar la lista de comentarios de la clase
     * @param listComment La lista de comentario a cambiar
     */
    public void setListComment(ArrayList<Comment> listComment) {
        this.listComment = listComment;
    }
    /**
     * Metodo que permite añadir un comentario a la lista de comentarios de la clase
     * @param comment El comentario a añadir
     */
    public void addListComment(Comment comment){
        listComment.add(comment);
    }

    /**
     * Metodo que permite recoger la cantidad de likes que hay en la clase
     * @return La cantidad de likes
     */
    public int getLike() {
        return like;
    }
    /**
     * Metodos que permite cambiar la cantidad de likes de la clase
     * @param like La cantidad de like a cambiar
     */
    public void setLike(int like) {
        this.like = like;
    }

    /**
     * Metodo que permite recoger la lista de likes de la clase
     * @return La lista de likes
     */
    public ArrayList<Like> getListLike() {
        return listLike;
    }
    /**
     * Metodo que permite cambiar la lista de likes de la clase
     * @param listLike La lista de likes a cambiar
     */
    public void setListLike(ArrayList<Like> listLike) {
        this.listLike = listLike;
    }
    /**
     * Metodo que permite añadir un like a la lista de likes de la clase
     * @param like El like a añadir a la lista de likes
     */
    public void addListLike(Like like){
        this.like = this.like + 1;
        this.listLike.add(like);
    }
    
    public int creatIdLike(){
        int idLike = getListLike().size() + 1;
        return idLike;
    }
    
}
