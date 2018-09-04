package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class OverviewMonthActivity extends Activity{
    private ArrayList<String> mTitulos = new ArrayList<>();
    private ArrayList<String> mDescricoes = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview_month);
        getIncomingIntent();
        initInfo();
    }

    private void initInfo() {
        mTitulos.add("Estudar matemática");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        mTitulos.add("Estudar português");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        mTitulos.add("Estudar geografia");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        mTitulos.add("Estudar geografia");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        mTitulos.add("Estudar geografia");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        mTitulos.add("Estudar geografia");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("01/01/2018");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.overview_month_recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitulos, mDescricoes, mDatas, this, MainActivity.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("titulo") && getIntent().hasExtra("titulo")){
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
