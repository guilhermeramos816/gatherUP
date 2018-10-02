package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PerguntaActivity extends Activity {
    private ArrayList<String> mPerguntasID = new ArrayList<>();
    private ArrayList<String> mRespostasID = new ArrayList<>();
    private ArrayList<String> mRespostas = new ArrayList<>();
    private ArrayList<String> mAutores = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();
    private ArrayList<String> mLikes = new ArrayList<>();
    private ArrayList<String> mComentarios = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refRespostas = database.getReference("respostas");

    private String perguntaID;
    private String usuarioID;

    FloatingActionButton btnResponder;
    ImageButton btnExcluir;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);

        btnResponder = findViewById(R.id.pergunta_responder);
        btnExcluir = findViewById(R.id.pergunta_excluir);

        getIncomingIntent();
        verificarUsuario();

        readData(new MyCallback() {
            @Override
            public void onCallback() {
                initRecyclerView();
            }
        });

        responder();
    }

    private void goMain() {
        Intent intent = new Intent(PerguntaActivity.this, MainActivity.class);
        PerguntaActivity.this.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void verificarUsuario() {
        Log.d("myApp", usuarioID);
        if (usuarioID.equals("1")) {
            btnExcluir.setVisibility(View.VISIBLE);
            btnExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Firebase firebase = new Firebase();
                    firebase.deletarPergunta(perguntaID);
                    goMain();
                }
            });
        }
    }

    private void responder() {
        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerguntaActivity.this, ResponderActivity.class);
                intent.putExtra("perguntaid", perguntaID);
                PerguntaActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    public interface MyCallback {
        void onCallback();
    }

    public void readData(final MyCallback myCallback) {
        refRespostas
                .orderByChild("pergunta_id")
                .startAt(perguntaID)
                .endAt(perguntaID)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            Resposta resposta = ds.getValue(Resposta.class);
                            mPerguntasID.add(resposta.getPergunta_id());
                            mRespostasID.add(resposta.getResposta_id());
                            mRespostas.add(resposta.getResposta());
                            mAutores.add("Por Guilherme Ramos, em ");
                            mDatas.add(resposta.getData());
                            mLikes.add(resposta.getLikes());
                            mComentarios.add(resposta.getComentarios());
                        }
                        myCallback.onCallback();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo") && getIntent().hasExtra("titulo")) {
            String titulo = getIntent().getStringExtra("titulo");
            String descricao = getIntent().getStringExtra("descricao");
            String data = getIntent().getStringExtra("data");
            String autor = getIntent().getStringExtra("autor");
            perguntaID = getIntent().getStringExtra("perguntaid");
            usuarioID = getIntent().getStringExtra("usuarioid");

            TextView txtTitulo = findViewById(R.id.pergunta_titulo);
            txtTitulo.setText(titulo);
            TextView txtDescricao = findViewById(R.id.pergunta_descricao);
            txtDescricao.setText(descricao);
//            TextView txtData = findViewById(R.id.pergunta_data);
//            txtData.setText(data);
//            TextView txtAutor = findViewById(R.id.pergunta_autor);
//            txtAutor.setText(autor);

        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.pergunta_recyclerView);
        RecyclerViewAdapterRespostas adapter = new RecyclerViewAdapterRespostas(mRespostasID, mRespostas, mAutores, mDatas, mLikes, mComentarios, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
