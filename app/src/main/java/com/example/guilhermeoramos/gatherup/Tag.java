package com.example.guilhermeoramos.gatherup;

public class Tag {
    private String tag_id;
    private String titulo;

    public Tag(String tag_id, String titulo) {
        this.tag_id = tag_id;
        this.titulo = titulo;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
