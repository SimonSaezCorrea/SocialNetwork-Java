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
    private ArrayList<Post> listPostShare;
    private Date date;
    private Follows followed;
    private Follows followers;

    
    public User(int id, String name, String password, Date date){
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = false;
        this.listPost = new ArrayList();
        this.listPostShare = new ArrayList();
        this.date = date;
        followed = new Follows();
        followers = new Follows();
    }

    public User(int id, String name, String password, boolean activity, ArrayList<Post> listPost, ArrayList<Post> listPostShare, Date date, Follows followed, Follows followers) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.activity = activity;
        this.listPost = listPost;
        this.listPostShare = listPostShare;
        this.date = date;
        this.followed = followed;
        this.followers = followers;
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

    public ArrayList<Post> getListPostShare() {
        return listPostShare;
    }
    public void setListPostShare(ArrayList<Post> listPostShare) {
        this.listPostShare = listPostShare;
    }
    public void addListPostShare(Post post){
        listPostShare.add(post);
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Follows getFollowed() {
        return followed;
    }
    public void setFollowed(Follows followed) {
        this.followed = followed;
    }

    public Follows getFollowers() {
        return followers;
    }
    public void setFollowers(Follows followers) {
        this.followers = followers;
    }
    
    
    
}
