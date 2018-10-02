package com.example.guilhermeoramos.gatherup;

public class Grupo {
    private String grupo_id;
    private String usuario_id;
    private String titulo;
    private String descricao;

    public Grupo(String grupo_id, String usuario_id, String titulo, String descricao) {
        this.grupo_id = grupo_id;
        this.usuario_id = usuario_id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(String grupo_id) {
        this.grupo_id = grupo_id;
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

}
