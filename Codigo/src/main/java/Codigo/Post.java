/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.Date;

/**
 * Es una clase que permite representar a una publicacion
 * @author Simon Saez
 */
public class Post extends Information{
    private String typePost; // Determina el tipo de publicacion
    private int amountShare; // Cantidad de veces compartida

    /**
     * Constructor
     * @param id El id del usuario
     * @param author El creador de la publicacion
     * @param date La fecha de creacion
     * @param content El contenido
     * @param typePost El tipo de post
     */
    public Post(int id, User author, Date date, String content, String typePost) {
        super(id, author, date, content);
        this.typePost = typePost;
        this.amountShare = 0;
    }
    
    public Post(){
    }

    /**
     * Metodo que permite recoger el tipo de la publicacion
     * @return El tipo de la publicacion
     */
    public String getTypePost() {
        return typePost;
    }
    /**
     * Metodo que permite cambiar el tipo de publicacion
     * @param typePost El tipo de publicacion a cambiar
     */
    public void setTypePost(String typePost) {
        this.typePost = typePost;
    }

    /**
     * Metodo que permite recoger la cantidad de compartidas
     * @return La cantidad de veces compartida
     */
    public int getAmountShare() {
        return amountShare;
    }
    /**
     * Metodo que permite cambiar la cantidad de compartidas
     * @param amountShare La cantidad de compartidas
     */
    public void setAmountShare(int amountShare) {
        this.amountShare = amountShare;
    }
    
    /**
     * Metodo que permite pasar a string el contenido de la clase post
     * @return Un string donde esta todo el contenido de la clase post
     */
    public String ToString(){
        String string = "";
        string = string + 
                "      Autor: " + getAuthor().getName() +
                "\n      Contenido: " + getContent() + 
                "\n      Like: " + String.valueOf(getLike()) +
                "\n      Cantidad de veces compartida: " + String.valueOf(getAmountShare()) + 
                "\n      Comentarios: \n";
        if(getListComment().isEmpty()){
            string = string + "         <No hay comentarios>\n";
        }else{
            for(Comment comment: getListComment()){
                string = string + 
                        "..................................................\n" +
                        comment.ToString("          ") +
                        "..................................................\n";
            }
        }
        return string;
    }
}

