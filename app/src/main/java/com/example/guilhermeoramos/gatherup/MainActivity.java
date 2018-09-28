package com.example.guilhermeoramos.gatherup;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mTitulos = new ArrayList<>();
    private ArrayList<String> mDescricoes = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();
    private boolean isFABOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initInfo();
        initDate();
//        setNotification();
//        openFAB();
        goNewQuestion();
        goNextPage();
    }

    private void goNextPage() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, CadastroStep1Activity.class);
//                MainActivity.this.startActivity(intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                if (isFABOpen) {
                    closeFAB();
                } else {
                    openFAB();
                }
            }
        });
    }

    private void initInfo() {
        Log.d(TAG, "initTitulos: prepating infos");

        mTitulos.add("Qual foi a maior guerra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Quantos metros tem 1 km?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Qual foi a maior guerra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Qual foi a maior guerra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Quantos metro tem 1 km?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Estudar programação");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Qual foi a maior guerra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Qual foi a maior gu'erra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Quantos metro tem 1 km?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Qual foi a maior guerra que já existiu?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        mTitulos.add("Quantos metro tem 1 km?");
        mDescricoes.add("Lorem ipsum dolor sit amet, suas nominati quo no, nec consul audire ad. Tollit soleat virtute et quo, quo ea dicunt utamur, ei mel simul dicam");
        mDatas.add("Por Guilherme Ramos, 5 minutos atrás");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitulos, mDescricoes, mDatas, this, PerguntaActivity.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDate() {
//        TextView mes = findViewById(R.id.textViewMes);
        CollapsingToolbarLayout mCollapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);

        ArrayList<String> date = setDate();

//        mes.setText(date.get(2));

        String dia = "";

        if (Integer.parseInt(date.get(0)) < 10)
            dia = "0" + date.get(0);
        else
            dia = date.get(0);

//        mCollapsingToolbarLayout.setTitle(date.get(1) + ", " + dia);
        mCollapsingToolbarLayout.setTitle("Mais vistas");
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedToolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedToolbar);

    }

    private ArrayList<String> setDate() {
        Calendar calendar = Calendar.getInstance();
        ArrayList<String> date = new ArrayList<>();
        date.add(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                date.add("Domingo");
                break;
            case 2:
                date.add("Segunda-feira");
                break;
            case 3:
                date.add("Terça-feira");
                break;
            case 4:
                date.add("Quarta-feira");
                break;
            case 5:
                date.add("Quinta-feira");
                break;
            case 6:
                date.add("Sexta-feira");
                break;
            case 7:
                date.add("Sábado");
                break;
        }

        switch (calendar.get(Calendar.MONTH)) {
            case 0:
                date.add("Janeiro");
                break;
            case 1:
                date.add("Fevereiro");
                break;
            case 2:
                date.add("Março");
                break;
            case 3:
                date.add("Abril");
                break;
            case 4:
                date.add("Maio");
                break;
            case 5:
                date.add("Junho");
                break;
            case 6:
                date.add("Julho");
                break;
            case 7:
                date.add("Agosto");
                break;
            case 8:
                date.add("Setembro");
                break;
            case 9:
                date.add("Outubro");
                break;
            case 10:
                date.add("Novembro");
                break;
            case 11:
                date.add("Dezembro");
                break;
        }

        return date;
    }


    private void openFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
        fab.startAnimation(anim);

        fab1.animate().translationY(-200);
        fab2.animate().translationY(-400);
        isFABOpen = true;
    }

    private void closeFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point_back);
        fab.startAnimation(anim);

        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        isFABOpen = false;
    }

    private void goNewQuestion() {
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastroStep1Activity.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
