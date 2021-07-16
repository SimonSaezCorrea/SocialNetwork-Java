/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
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
