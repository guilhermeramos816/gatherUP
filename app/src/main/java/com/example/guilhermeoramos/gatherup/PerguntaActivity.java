package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class PerguntaActivity extends Activity {
    private ArrayList<String> mRespostas = new ArrayList<>();
    private ArrayList<String> mAutores = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();
    private ArrayList<String> mLikes = new ArrayList<>();
    private ArrayList<String> mComentarios = new ArrayList<>();
    private ArrayList<String> mPontos = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        getIncomingIntent();
        initInfo();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_change, R.anim.slide_out_down);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo") && getIntent().hasExtra("titulo")) {
            String titulo = getIntent().getStringExtra("titulo");
            TextView textView = findViewById(R.id.pergunta_titulo);
            textView.setText(titulo);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.pergunta_recyclerView);
        RecyclerViewAdapterRespostas adapter = new RecyclerViewAdapterRespostas(mRespostas, mAutores, mDatas, mLikes, mComentarios, mPontos, this);
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
            mPontos.add("1500");
        }
        initRecyclerView();
    }

}
