package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GruposActivity extends Activity {
    ArrayList<String> mTitulos = new ArrayList<>();
    ArrayList<String> mDescricoes = new ArrayList<>();
    ArrayList<String> mCriadores = new ArrayList<>();
    ArrayList<String> mDatas = new ArrayList<>();
    ArrayList<String> mParticipantes = new ArrayList<>();
    Button btnNovoGrupo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        initInfo();

        btnNovoGrupo = findViewById(R.id.grupos_novo_grupo);
        goStep1();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void initInfo() {
        for (int i = 0; i < 20; i++) {
            mTitulos.add("Grupo de matemática");
            mDescricoes.add("Lorem ipsum dolor sit amet, ei mel simul dicam");
            mCriadores.add("Por Guilherme Ramos,");
            mDatas.add("em 30/09/2018");
            mParticipantes.add("10");
        }
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.grupos_recyclerView);
        RecyclerViewAdapterGrupos adapter = new RecyclerViewAdapterGrupos(mTitulos, mDescricoes, mDatas, mCriadores, mParticipantes, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void goStep1(){
        btnNovoGrupo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GruposActivity.this, NovoGrupoStep1.class);
                GruposActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
