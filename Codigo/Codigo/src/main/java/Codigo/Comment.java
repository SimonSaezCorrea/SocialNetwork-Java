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
public class Comment extends Information{

    public Comment(int id, User author, Date date, String content) {
        super(id, author, date, content);
    }

    public Comment(int id, User author, Date date, String content, ArrayList<Comment> listComment, int like) {
        super(id, author, date, content, listComment, like);
    }
    
    
}
