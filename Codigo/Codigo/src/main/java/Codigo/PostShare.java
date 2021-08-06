/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.Date;

/**
 *
 * @author Equipo
 */
public class PostShare {
    private Post post;
    private Date date;

    public PostShare(Post post, Date date) {
        this.post = post;
        this.date = date;
    }

    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
