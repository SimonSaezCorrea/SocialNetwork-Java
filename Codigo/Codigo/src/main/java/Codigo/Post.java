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
public class Post extends Information{
    private String typePost;
    private int amountShare;

    public Post(int id, User author, Date date, String content, String typePost) {
        super(id, author, date, content);
        this.typePost = typePost;
        this.amountShare = 0;
    }

    public Post(int id, User author, Date date, String content, ArrayList<Comment> listComment, int like, String typePost, int amountShare) {
        super(id, author, date, content, listComment, like);
        this.typePost = typePost;
        this.amountShare = amountShare;
    }

    public String getTypePost() {
        return typePost;
    }
    public void setTypePost(String typePost) {
        this.typePost = typePost;
    }

    public int getAmountShare() {
        return amountShare;
    }
    public void setAmountShare(int amountShare) {
        this.amountShare = amountShare;
    }
    
    
}

