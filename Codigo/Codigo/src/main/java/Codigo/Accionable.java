/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;

/**
 * Interfaz que contiene los metodos accionables a usar en el main por el usuario
 * @author Simon Saez
 */
public interface Accionable {
    public boolean login(String name, String password);
    
    public boolean register(String name, String password);
    
    public void logout();
    
    public void post(String typePost, String content);
    
    public void post(String typePost, String content, ArrayList<String> listStringUser);
    
    public void follow(String name);
    
    public void share(int idPost, ArrayList<String> listUser);
    
    public void visualize();
    
    public void comment(Post post, String text);
    
    public void comment(Comment comment, String text);
    
    public void like(Comment comment);
    
    public void like(Post post);
}
