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

    public void enviarPergunta(String titulo, String descricao, String tag) {
        String id = refPerguntas.push().getKey();
        Pergunta pergunta = new Pergunta(id, titulo, descricao, tag, "0", "0");
        refPerguntas.child(id).setValue(pergunta);
    }

}
