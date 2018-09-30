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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mTitulos = new ArrayList<>();
    private ArrayList<String> mDescricoes = new ArrayList<>();
    private ArrayList<String> mDatas = new ArrayList<>();
    private ArrayList<String> mAutores = new ArrayList<>();
    private ArrayList<String> mLikes = new ArrayList<>();
    private ArrayList<String> mComentarios = new ArrayList<>();
    private ArrayList<String> mPerguntasID = new ArrayList<>();

    private boolean isFABOpen = false;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference refPerguntas = database.getReference("perguntas");

    private String user_id = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        readData(new MyCallback() {
            @Override
            public void onCallback() {
                initRecyclerView();
            }
        });
        initToolbar();
        goNewQuestion();
        goNextPage();
    }

    public interface MyCallback {
        void onCallback();
    }

    public void readData(final MyCallback myCallback) {
        refPerguntas
                .orderByChild("usuario_id")
                .startAt(user_id)
                .endAt(user_id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Pergunta pergunta = ds.getValue(Pergunta.class);
                    mTitulos.add(pergunta.titulo);
                    mDescricoes.add(pergunta.descricao);
                    mDatas.add(pergunta.data);
                    mAutores.add("Por Guilherme Ramos, em ");
                    mLikes.add(pergunta.likes);
                    mComentarios.add(pergunta.comentarios);
                    mPerguntasID.add(pergunta.pergunta_id);
                }
                myCallback.onCallback();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void goNextPage() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFABOpen) {
                    closeFAB();
                } else {
                    openFAB();
                }
            }
        });
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.main_recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mTitulos, mDescricoes, mDatas, mAutores, mLikes, mComentarios, mPerguntasID, this, PerguntaActivity.class);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initToolbar() {
        CollapsingToolbarLayout mCollapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        mCollapsingToolbarLayout.setTitle("Mais vistas");
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedToolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedToolbar);
    }

    private void openFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        FloatingActionButton fab3 = findViewById(R.id.fab3);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point);
        fab.startAnimation(anim);

        fab1.animate().translationY(-200);
        fab2.animate().translationY(-400);
        fab3.animate().translationY(-600);
        isFABOpen = true;
    }

    private void closeFAB() {
        FloatingActionButton fab = findViewById(R.id.fab);
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        FloatingActionButton fab3 = findViewById(R.id.fab3);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate_around_center_point_back);
        fab.startAnimation(anim);

        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
        isFABOpen = false;
    }

    private void goNewQuestion() {
        FloatingActionButton fab1 = findViewById(R.id.fab1);
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        FloatingActionButton fab3 = findViewById(R.id.fab3);
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
                Intent intent = new Intent(MainActivity.this, GruposActivity.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                MainActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}