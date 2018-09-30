package com.example.guilhermeoramos.gatherup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pergunta {
    String pergunta_id;
    String usuario_id;
    String titulo;
    String descricao;
    String tag;
    String data;

    public Pergunta(){

    }

    public Pergunta(String pergunta_id, String titulo, String descricao, String tag){
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyy");
        this.pergunta_id = pergunta_id;
        this.usuario_id = "1";
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = formatter.format(todayDate);
        this.tag = tag;
    }

}
