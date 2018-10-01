package com.example.guilhermeoramos.gatherup;

public class Usuario {
    private String usuario_id;
    private String nome;
    private String email;
    private String senha;

    public Usuario() {

    }

    public Usuario(String usuario_id, String nome, String email, String senha) {
        this.usuario_id = usuario_id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
