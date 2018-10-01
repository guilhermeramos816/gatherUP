package com.example.guilhermeoramos.gatherup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Resposta {
    private String pergunta_id;
    private String resposta_id;
    private String usuario_id;
    private String resposta;
    private String data;
    private String likes;
    private String comentarios;

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


    public String getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(String pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getResposta_id() {
        return resposta_id;
    }

    public void setResposta_id(String resposta_id) {
        this.resposta_id = resposta_id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

}
