package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Firebase extends Activity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refPerguntas = database.getReference("perguntas");
    private DatabaseReference refUsuarios = database.getReference("usuarios");
    private DatabaseReference refRespostas = database.getReference("respostas");
    private DatabaseReference refGrupos = database.getReference("grupos");
    private DatabaseReference refTags = database.getReference("tags");

    public void enviarPergunta(String titulo, String descricao, String tag, String grupo_id) {
        String id = refPerguntas.push().getKey();
        Pergunta pergunta = new Pergunta(id, titulo, descricao, tag, "0", "0", grupo_id);
        refPerguntas.child(id).setValue(pergunta);
    }

    public void enviarCadastro(String nome, String email, String senha) {
        String id = refUsuarios.push().getKey();
        Usuario usuario = new Usuario(id, nome, email, senha);
        refUsuarios.child(id).setValue(usuario);
    }

    public void enviarGrupo(String usuario_id, String titulo, String descricao) {
        String id = refGrupos.push().getKey();
        Grupo grupo = new Grupo(id, usuario_id, titulo, descricao);
        refGrupos.child(id).setValue(grupo);
    }

    public void enviarResposta(String pergunta_id, String resposta_texto) {
        String id = refRespostas.push().getKey();
        Resposta resposta = new Resposta(pergunta_id, id, "1", resposta_texto, "0", "0");
        refRespostas.child(id).setValue(resposta);
    }

    public void deletarPergunta(String id){
        refPerguntas.child(id).removeValue();
    }

    public void enviarTags(){
        Tag a1 = new Tag("1", "Português");
        refTags.child("1").setValue(a1);
        Tag a2 = new Tag("2", "Português");
        refTags.child("2").setValue(a2);
        Tag a3 = new Tag("3", "Português");
        refTags.child("3").setValue(a3);
        Tag a4 = new Tag("4", "Português");
        refTags.child("4").setValue(a4);
        Tag a5 = new Tag("5", "Português");
        refTags.child("5").setValue(a5);
        Tag a6 = new Tag("6", "Português");
        refTags.child("6").setValue(a6);
        Tag a7 = new Tag("7", "Português");
        refTags.child("7").setValue(a7);
        Tag a8 = new Tag("8", "Português");
        refTags.child("8").setValue(a8);
        Tag a9 = new Tag("9", "Português");
        refTags.child("9").setValue(a9);
        Tag a10 = new Tag("10", "Português");
        refTags.child("11").setValue(a10);
        Tag a11 = new Tag("12", "Português");
        refTags.child("12").setValue(a11);
        Tag a12 = new Tag("13", "Português");
        refTags.child("13").setValue(a12);
    }
}
