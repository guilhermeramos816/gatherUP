package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroStep2Activity extends Activity {
    String titulo;
    String descricao;
    String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_step2);
        goNextPage();
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo") && getIntent().hasExtra("descricao")) {
            titulo = getIntent().getStringExtra("titulo");
            descricao = getIntent().getStringExtra("descricao");
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus) {
            TextView textView = findViewById(R.id.btncontinuar);
            textView.startAnimation(AnimationUtils.loadAnimation(CadastroStep2Activity.this, R.anim.slide_left_center));
        }
    }

    private void goNextPage() {
        Button btn = findViewById(R.id.btncontinuar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaPergunta();
                Intent intent = new Intent(CadastroStep2Activity.this, CadastroStep3Activity.class);
                CadastroStep2Activity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void novaPergunta() {
        EditText editTextTag = findViewById(R.id.cadastro_step2_tags);
        tag = editTextTag.getText().toString().trim();
        Firebase firebase = new Firebase();
        firebase.enviarPergunta(titulo, descricao, tag);
    }

}
