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

import java.util.ArrayList;

public class Firebase extends Activity {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refPerguntas = database.getReference("perguntas");

    public void enviarPergunta(String titulo, String descricao, String tag) {
        String id = refPerguntas.push().getKey();
        Pergunta pergunta = new Pergunta(id, titulo, descricao, tag);
        refPerguntas.child(id).setValue(pergunta);
    }

    ArrayList<String> arrayList = new ArrayList<String>();

    public void buscarPerguntas() {
        refPerguntas.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Pergunta pergunta = dataSnapshot.getValue(Pergunta.class);
                arrayList.add(pergunta.titulo);
                Log.d("MyApp", pergunta.titulo);
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                Log.i("tag", "This'll run 300 milliseconds later");
                            }
                        },
                        1000);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void test() {
        buscarPerguntas();
        Log.d("MyApp", arrayList.size() + "");
    }

}
