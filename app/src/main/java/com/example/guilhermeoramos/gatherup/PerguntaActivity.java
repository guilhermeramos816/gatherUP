package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        getIncomingIntent();
//        initInfo();
        readData(new MyCallback() {
            @Override
            public void onCallback() {
                Log.d("MyApp: Pergunta ID", perguntaID);
                initRecyclerView();
            }
        });
    }

    public interface MyCallback {
        void onCallback();
    }

    public void readData(final MyCallback myCallback) {
        refRespostas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Resposta resposta = ds.getValue(Resposta.class);

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
        overridePendingTransition(R.anim.no_change, R.anim.slide_out_down);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo") && getIntent().hasExtra("titulo")) {
            String titulo = getIntent().getStringExtra("titulo");
            perguntaID = getIntent().getStringExtra("perguntaid");
            TextView textView = findViewById(R.id.pergunta_titulo);
            textView.setText(titulo);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.pergunta_recyclerView);
        RecyclerViewAdapterRespostas adapter = new RecyclerViewAdapterRespostas(mRespostasID, mRespostas, mAutores, mDatas, mLikes, mComentarios, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initInfo() {
        for (int i = 0; i < 10; i++) {
            mRespostas.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
            mAutores.add("Por Julia Souza, ");
            mDatas.add("em 29/09/2018");
            mLikes.add("10");
            mComentarios.add("5");
        }
        initRecyclerView();
    }


}
