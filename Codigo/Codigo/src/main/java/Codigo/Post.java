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
public class Post {
    private int id;
    private String author;
    private Date date;
    private String typePost;
    private String content;
    private ArrayList<Comment> listComment;
    private int likes;
    private int amountShare;

    
    public Post(int id, String author, Date date, String typePost, String content){
        this.id = id;
        this.author = author;
        this.date = date;
        this.typePost = typePost;
        this.content = content;
        this.listComment = new ArrayList();
        this.likes = 0;
        this.amountShare = 0;
    }
    public Post(int id, String author, Date date, String typePost, String content, ArrayList<Comment> listComment, int likes, int amountShare) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.typePost = typePost;
        this.content = content;
        this.listComment = listComment;
        this.likes = likes;
        this.amountShare = amountShare;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypePost() {
        return typePost;
    }
    public void setTypePost(String typePost) {
        this.typePost = typePost;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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

    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getAmountShare() {
        return amountShare;
    }
    public void setAmountShare(int amountShare) {
        this.amountShare = amountShare;
    }
    
    
}

