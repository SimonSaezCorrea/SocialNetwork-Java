/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;

/**
 * Es una clase que permite representar a los follows
 * @author Simon Saez
 */
public class Follows {
    private int amountFollows; // Cantidad de follows
    private ArrayList<User> listFollows; // Lista de usuarios que sigue o lo siguen

    
    /**
     * Constructor
     */
    public Follows() {
        this.amountFollows = 0;
        this.listFollows = new ArrayList();
    }

    /**
     * Metodo que permite saber si existe un usuario que lo siga
     * @param user El usuario que se desea compronar
     * @return Una sentencia booleana que diga si existe o no existe
     */
    public boolean existFollow(User user){
        
        for(User isUser: getListFollows()){
            if(isUser.equals(user)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que permite recoger la cantidad de follows
     * @return La cantidad de follows
     */
    public int getAmountFollows() {
        return amountFollows;
    }
    /**
     * Metodo que permite cambiar la cantidad de follows
     * @param amountFollows La cantidad de follows a cambiar
     */
    public void setAmountFollows(int amountFollows) {
        this.amountFollows = amountFollows;
    }

    /**
     * Metodo que permite recoger la lista de usuarios que sigue o lo siguen
     * @return La lista de usuarios
     */
    public ArrayList<User> getListFollows() {
        return listFollows;
    }
    /**
     * Metodo que permite cambiar la lista de usuarios que sigue o lo siguen
     * @param listFollows La lista de usuarios a cambiar
     */
    public void setListFollows(ArrayList<User> listFollows) {
        this.listFollows = listFollows;
    }
    /**
     * Metodo que permite añadir un usuario a la lista de usuarios
     * @param user El usuario a añadir
     */
    public void addListFollows(User user){
        amountFollows = amountFollows + 1;
        listFollows.add(user);
    }
    
    
}
