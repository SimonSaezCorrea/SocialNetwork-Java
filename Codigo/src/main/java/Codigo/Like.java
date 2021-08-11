/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.Date;

/**
 * Es una clase que permite representar a un like
 * @author Simon Saez
 */
public class Like {
    int id; // El id del like
    Date date; // La fecha de creacion del dato
    User author; // El autor 

    /**
     * Constructor
     * @param id El id del like
     * @param date La fecha de creacion del like
     * @param author El autor del like
     */
    public Like(int id, Date date, User author) {
        this.id = id;
        this.date = date;
        this.author = author;
    }

    /**
     * Metodo que permite recoger el id del like
     * @return El id del like
     */
    public int getId() {
        return id;
    }
    /**
     * Metodo que permite cambiar el id del like
     * @param id El id a cambiar del like
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo que permite recoger la fecha de creacion del like
     * @return La fecha de creacion del like
     */
    public Date getDate() {
        return date;
    }
    /**
     * Metodo que permite cambiar la fecha de creacion del like
     * @param date La fecha de creacion a cambiar del like
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Metodo que permite recoger el autor del like
     * @return EL autor del like
     */
    public User getAuthor() {
        return author;
    }
    /**
     * Metodo que permite cambiar el autor del like
     * @param author El autor a cambiar del like
     */
    public void setAuthor(User author) {
        this.author = author;
    }
    
    
}
