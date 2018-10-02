package com.example.guilhermeoramos.gatherup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pergunta {
    private String pergunta_id;
    private String usuario_id;
    private String titulo;
    private String descricao;
    private String tag;
    private String data;
    private String likes;
    private String comentarios;
    private String grupo_id;

    public Pergunta() {

    }

    public Pergunta(String pergunta_id, String titulo, String descricao, String tag, String likes, String comentarios, String grupo_id) {
        Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyyy");
        this.pergunta_id = pergunta_id;
        this.usuario_id = "1";
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = formatter.format(todayDate);
        this.tag = tag;
        this.likes = likes;
        this.comentarios = comentarios;
        this.grupo_id = grupo_id;
    }

    public String getPergunta_id() {
        return pergunta_id;
    }

    public void setPergunta_id(String pergunta_id) {
        this.pergunta_id = pergunta_id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
    }

}
