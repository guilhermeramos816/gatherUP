package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends Activity {
    ListView lista;
    EditText termo;
    FloatingActionButton pesquisar;

    ArrayList<String> resultados = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refPerguntas = database.getReference("perguntas");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

        termo = findViewById(R.id.pesquisa_termo);
        pesquisar = findViewById(R.id.pesquisa_pesquisar);

        readData(new MyCallback() {
            @Override
            public void onCallback() {
                buscar();
            }
        });
    }

    private void goPergunta(){
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String saved = termo.getText().toString().trim();
                if (termo.getText().toString().isEmpty())
                    termo.setText(lista.getItemAtPosition(i).toString());
                else
                    termo.setText(saved + "; " + lista.getItemAtPosition(i).toString());
            }
        });
    }

    private void buscar(){
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popular();
            }
        });
    }

    private ArrayList<String> filtrar(ArrayList<String> ar){
        ArrayList<String> filtrado = new ArrayList<>();
        for(String el : ar){
            if(el.toLowerCase().trim().contains(getText().toLowerCase())){
                filtrado.add(el);
            }
        }
        return filtrado;
    }

    public String getText() {
        return termo.getText().toString().trim();
    }

    public interface MyCallback {
        void onCallback();
    }

    public void readData(final MyCallback myCallback) {
        refPerguntas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Pergunta pergunta = ds.getValue(Pergunta.class);
                    resultados.add(pergunta.getTitulo());
                }
                myCallback.onCallback();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void popular() {
        lista = findViewById(R.id.pesquisa_lista);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filtrar(resultados));
        lista.setAdapter(adapter);
    }

}