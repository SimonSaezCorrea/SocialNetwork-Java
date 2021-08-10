/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Es una clase que permite representar a un comentario
 * @author Simon Saez
 */
public class Comment extends Information{

    /**
     * Constructor
     * @param id El id del comentario
     * @param author El autor del comentario
     * @param date La fecha de creacion del comentario
     * @param content El contenido del comentario
     */
    public Comment(int id, User author, Date date, String content) {
        super(id, author, date, content);
    }
    
    /**
     * Metodo que permite pasar a string el contenido de la clase
     * @param bloques Es la cantidad de espacios que debe haber para mostrar con identacion
     * @return Un string que muestra la clase
     */
    public String ToString(String bloques){
        String string = "";
        
        string = string + 
                bloques + "Autor: " + getAuthor().getName() +
                "\n" + bloques + "Contenido: " + getContent() + 
                "\n" + bloques + "Like: " + String.valueOf(getLike())+
                "\n" + bloques + "Comentarios: \n";
        
        if(getListComment().isEmpty()){
            string = string + bloques + "     <No hay comentarios>\n";
        }else{
            for(Comment comment: getListComment()){
                string = string + 
                        "..................................................\n" +
                        comment.ToString(bloques + "     ") +
                        "..................................................\n";
            }
        }
        
        return string;
    }
    
}
