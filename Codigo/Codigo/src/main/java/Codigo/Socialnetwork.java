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

    public boolean login(String name, String password){
        if(existUser(name ,password)){
            User user = searchUser(name);
            user.setActivity(true);
            return true;
        }
        return false;
    }
    public boolean register(String name, String password){
        if(!existUser(name, password)){
            User user = new User(createIDUser(), name, password, Calendar.getInstance().getTime());
            user.setActivity(true);
            return true;
        }
        return false;
    }
    
    public void logout(){
        int i;
        for(i = 0; i < listUser.size(); i++){
            if(listUser.get(i).getActivity()){
                listUser.get(i).setActivity(false);
            }
        }
    }
    
    
    public int createIDUser(){
        return 1 + listUser.size();
    }
    
    public int createIDPost(){
        return 1 + listPost.size();
    }
    
    public int createIDComment(){
        return 1 + listComment.size();
    }       
    
    public boolean existUser(String name){
        int i;
        for(i = 0; i < listUser.size(); i++){
            if(name.equals(listUser.get(i).getName())){
                return true;
            }
        }
        return false;
    }
    public boolean existUser(String name, String password){
        int i;
        for(i = 0; i < listUser.size(); i++){
            if(name.equals(listUser.get(i).getName()) && password.equals(listUser.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
    
    public User searchUser(String name){
        int i;
        User user = null;
        for(i = 0; i < listUser.size();i++){
            if(name.equals(listUser.get(i).getName())){
                user = listUser.get(i);
            }
        }
        return user;
    }
    public User searchUser(int id){
        int i;
        User user = null;
        for(i = 0; i < listUser.size();i++){
            if(id == listUser.get(i).getId()){
                user = listUser.get(i);
            }
        }
        return user;
    }
    
    public Post searchPost(int id){
        int i;
        Post post = null;
        for(i = 0; i < listPost.size();i++){
            if(id == listPost.get(i).getId()){
                post = listPost.get(i);
            }
        }
        return post;
    }
    
    public Comment searchComment(int id){
        int i;
        Comment comment = null;
        for(i = 0; i < listComment.size();i++){
            if(id == listComment.get(i).getId()){
                comment = listComment.get(i);
            }
        }
        return comment;
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
