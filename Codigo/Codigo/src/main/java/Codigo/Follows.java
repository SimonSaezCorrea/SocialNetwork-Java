/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public class Follows {
    private int amountFollows;
    private ArrayList<User> listFollows;

    
    public Follows() {
        this.amountFollows = 0;
        this.listFollows = new ArrayList();
    }
    public Follows(int amountFollows, ArrayList<User> listFollows) {
        this.amountFollows = amountFollows;
        this.listFollows = listFollows;
    }

    public boolean existFollow(User user){
        
        for(User isUser: getListFollows()){
            if(isUser.equals(user)){
                return true;
            }
        }
        return false;
    }
    
    public int getAmountFollows() {
        return amountFollows;
    }
    public void setAmountFollows(int amountFollows) {
        this.amountFollows = amountFollows;
    }

    public ArrayList<User> getListFollows() {
        return listFollows;
    }
    public void setListFollows(ArrayList<User> listFollows) {
        this.listFollows = listFollows;
    }
    public void addListFollows(User user){
        amountFollows = amountFollows + 1;
        listFollows.add(user);
    }
    
    
}
