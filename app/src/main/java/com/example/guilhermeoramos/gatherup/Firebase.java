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

    public void enviarPergunta(String titulo, String descricao, String tag) {
        String id = refPerguntas.push().getKey();
        Pergunta pergunta = new Pergunta(id, titulo, descricao, tag, "0", "0");
        refPerguntas.child(id).setValue(pergunta);
    }

    public void enviarCadastro(String nome, String email, String senha) {
        String id = refUsuarios.push().getKey();
        Usuario usuario = new Usuario(id, nome, email, senha);
        refUsuarios.child(id).setValue(usuario);
    }

    public void enviarResposta(String pergunta_id, String resposta_texto) {
        String id = refRespostas.push().getKey();
        Resposta resposta = new Resposta(pergunta_id, id, "1", resposta_texto, "0", "0");
        refRespostas.child(id).setValue(resposta);
    }


}
