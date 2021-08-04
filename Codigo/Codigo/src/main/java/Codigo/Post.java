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

    public Post(int id, User author, Date date, String content, ArrayList<Comment> listComment, int like, ArrayList<Like> listLike, String typePost, int amountShare) {
        super(id, author, date, content, listComment, like, listLike);
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
    
    public String ToString(){
        String string = "";
        string = string + 
                "      Autor: " + getAuthor().getName() +
                "\n      Contenido: " + getContent() + 
                "\n      Like: " + String.valueOf(getLike()) +
                "\n      Cantidad de veces compartida: " + String.valueOf(getAmountShare()) + 
                "\n      Comentarios: \n";
        if(getListComment().isEmpty()){
            string = string + "         <No hay comentarios>\n";
        }else{
            for(Comment comment: getListComment()){
                string = string + 
                        "..................................................\n" +
                        comment.ToString("          ") +
                        "..................................................\n";
            }
        }
        return string;
    }
}

