package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoGrupoStep1 extends Activity {
    FloatingActionButton btnContinuar;

    EditText editTextPergunta;
    EditText editTextDescricao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_grupo_step1);

        btnContinuar = findViewById(R.id.btncontinuar);

        goStep2();
    }

    private void  novoGrupo(){
        editTextPergunta = findViewById(R.id.novo_grupo_titulo);
        String titulo = editTextPergunta.getText().toString().trim();

        editTextDescricao = findViewById(R.id.novo_grupo_descricao);
        String descricao = editTextDescricao.getText().toString().trim();

        Firebase firebase = new Firebase();
        firebase.enviarGrupo("1", titulo, descricao);
    }

    private void goStep2() {
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoGrupo();
                Intent intent = new Intent(NovoGrupoStep1.this, NovoGrupoStep2.class);
                NovoGrupoStep1.this.startActivity(intent);
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
