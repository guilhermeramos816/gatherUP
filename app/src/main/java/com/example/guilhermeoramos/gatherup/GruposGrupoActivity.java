package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class GruposGrupoActivity extends Activity {
    private ArrayList<String> mTitulos = new ArrayList<>();
    private ArrayList<String> mDescricoes = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos_grupo);
        getIncomingIntent();
        initInfo();
    }

    private void initInfo() {
        for (int i = 0; i < 10; i++) {
            mTitulos.add("Qual foi a maior guerra que já existiu?");
            mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
            mDatas.add("Por Guilherme Ramos, 5 minutos atrás");
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.grupos_grupo_recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitulos, mDescricoes, mDatas, this, PerguntaActivity.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo")) {
            String titulo = getIntent().getStringExtra("titulo");
            TextView textView = findViewById(R.id.grupos_grupo_titulo);
            textView.setText(titulo);
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
