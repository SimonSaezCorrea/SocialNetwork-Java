/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.Date;

/**
 * Es una clase que permite representar a una publicacion compartida
 * @author Simon Saez
 */
public class PostShare {
    private Post post; // El post compartido
    private Date date; // La fecha que se compartido

    /**
     * Constructor
     * @param post EL post que se compartio
     * @param date La fecha en la que se compartido
     */
    public PostShare(Post post, Date date) {
        this.post = post;
        this.date = date;
    }

    /**
     * Metodo que permite recoger el post compartido
     * @return El post compartido
     */
    public Post getPost() {
        return post;
    }
    /**
     * Metodo que permite cambiar el post compartido
     * @param post El post compartido a cambiar
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Metodo que permite recoger la fecha compartida
     * @return La fecha compartida
     */
    public Date getDate() {
        return date;
    }
    /**
     * Metodo que permite cambiar la fecha compartida
     * @param date La fecha compartida a cambiar
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
