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
public class User {
    private int id;
    private String name;
    private String password;
    private boolean activity;
    private ArrayList<Post> listPost;
    private ArrayList<Post> listPostComp;
    private Date date;
    private int amountFollowed;
    private int amountFollowers;
    private ArrayList<User> listAmFollowed;
    private ArrayList<User> listAmFollowers;

    
    public User(int id, String name, String password, Date date){
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = false;
        this.listPost = new ArrayList();
        this.listPostComp = new ArrayList();
        this.date = date;
        this.amountFollowed = 0;
        this.amountFollowers = 0;
        this.listAmFollowed = new ArrayList();
        this.listAmFollowers = new ArrayList();
    }
    public User(int id, String name, String password, boolean activity, ArrayList<Post> listPost, ArrayList<Post> listPostComp, Date date, int amountFollowed, int amountFollowers, ArrayList<User> listAmFollowed, ArrayList<User> listAmFollowers) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = activity;
        this.listPost = listPost;
        this.listPostComp = listPostComp;
        this.date = date;
        this.amountFollowed = amountFollowed;
        this.amountFollowers = amountFollowers;
        this.listAmFollowed = listAmFollowed;
        this.listAmFollowers = listAmFollowers;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivity() {
        return activity;
    }
    public void setActivity(boolean activity) {
        this.activity = activity;
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

    public ArrayList<Post> getListPostComp() {
        return listPostComp;
    }
    public void setListPostComp(ArrayList<Post> listPostComp) {
        this.listPostComp = listPostComp;
    }
    public void addListPostComp(Post post){
        listPostComp.add(post);
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmountFollowed() {
        return amountFollowed;
    }
    public void setAmountFollowed(int amountFollowed) {
        this.amountFollowed = amountFollowed;
    }

    public int getAmountFollowers() {
        return amountFollowers;
    }
    public void setAmountFollowers(int amountFollowers) {
        this.amountFollowers = amountFollowers;
    }

    public ArrayList<User> getListAmFollowed() {
        return listAmFollowed;
    }
    public void setListAmFollowed(ArrayList<User> listAmFollowed) {
        this.listAmFollowed = listAmFollowed;
    }
    public void addListAmFollowed(User user){
        listAmFollowed.add(user);
    }

    public ArrayList<User> getListAmFollowers() {
        return listAmFollowers;
    }
    public void setListAmFollowers(ArrayList<User> listAmFollowers) {
        this.listAmFollowers = listAmFollowers;
    }
    public void addListAmFollowers(User user){
        listAmFollowers.add(user);
    }
    
    
}
