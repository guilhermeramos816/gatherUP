package com.example.guilhermeoramos.gatherup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Resposta {
    String pergunta_id;
    String resposta_id;
    String usuario_id;
    String resposta;
    String data;
    String likes;
    String comentarios;

    public Resposta(){

    }

    public Resposta(String pergunta_id, String resposta_id, String usuario_id, String resposta, String likes, String comentarios){
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyy");
        this.pergunta_id = pergunta_id;
        this.resposta_id = resposta_id;
        this.usuario_id = usuario_id;
        this.resposta = resposta;
        this.data = formatter.format(todayDate);
        this.likes = likes;
        this.comentarios = comentarios;
    }
}
