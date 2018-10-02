package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

public class CadastroStep1Activity extends Activity {
    String grupoID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_step1);

        getIncomingIntent();

        goNextPage();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("grupoid")){
            grupoID = getIntent().getStringExtra("grupoid");
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
            FloatingActionButton textView = findViewById(R.id.btncontinuar);
            textView.startAnimation(AnimationUtils.loadAnimation(CadastroStep1Activity.this, R.anim.slide_left_center));
        }
    }

    private void goNextPage() {
        FloatingActionButton btn = findViewById(R.id.btncontinuar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastroStep1Activity.this, CadastroStep2Activity.class);

                EditText editTextPergunta = findViewById(R.id.cadastro_step1_titulo);
                String titulo = editTextPergunta.getText().toString().trim();

                EditText editTextDescricao = findViewById(R.id.cadastro_step1_descricao);
                String descricao = editTextDescricao.getText().toString().trim();

                intent.putExtra("titulo", titulo);
                intent.putExtra("descricao", descricao);
                intent.putExtra("grupoid", grupoID);
                CadastroStep1Activity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
