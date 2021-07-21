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
public abstract class Information {
    private int id;
    private User author;
    private Date date;
    private String content;
    private ArrayList<Comment> listComment;
    private int like;

    public Information(int id, User author, Date date, String content) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.content = content;
        this.listComment = new ArrayList();
        this.like = 0;
    }

    public Information(int id, User author, Date date, String content, ArrayList<Comment> listComment, int like) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.content = content;
        this.listComment = listComment;
        this.like = like;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
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

    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like;
    }
}
