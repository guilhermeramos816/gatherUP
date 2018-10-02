package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OverviewMonthActivity extends Activity {
    private ArrayList<String> mTitulos = new ArrayList<>();
    private ArrayList<String> mDescricoes = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();
    private ArrayList<String> mAutores = new ArrayList<>();
    private ArrayList<String> mLikes = new ArrayList<>();
    private ArrayList<String> mComentarios = new ArrayList<>();
    private ArrayList<String> mPerguntasID = new ArrayList<>();
    private ArrayList<String> mUsuariosID = new ArrayList<>();

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refPerguntas = database.getReference("perguntas");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_month);
        getIncomingIntent();

        readData(new MyCallback() {
            @Override
            public void onCallback() {
                initRecyclerView();
            }
        });
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
                    mTitulos.add(pergunta.getTitulo());
                    mDescricoes.add(pergunta.getDescricao());
                    mDatas.add(pergunta.getData());
                    mAutores.add("Por Guilherme Ramos, em ");
                    mLikes.add(pergunta.getLikes());
                    mComentarios.add(pergunta.getComentarios());
                    mPerguntasID.add(pergunta.getPergunta_id());
                    mUsuariosID.add(pergunta.getUsuario_id());
                }
                myCallback.onCallback();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.overview_month_recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitulos, mDescricoes, mDatas, mAutores, mLikes, mComentarios, mPerguntasID, mUsuariosID, this, PerguntaActivity.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo")) {
            String titulo = getIntent().getStringExtra("titulo");
            TextView textView = findViewById(R.id.overview_month_titulo);
            textView.setText(titulo);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
