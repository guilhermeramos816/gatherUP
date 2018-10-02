package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CadastroStep3Activity extends Activity {
    String grupoID = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_step3);

        getIncomingIntent();

        goNextPage();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void goNextPage() {
        FloatingActionButton btn = findViewById(R.id.btncontinuar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("teste", "onClick: GRUOUP ID " + grupoID);
                if(grupoID.equals("0")){
                    Intent intent = new Intent(CadastroStep3Activity.this, MainActivity.class);
                    CadastroStep3Activity.this.startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }else {
                    Intent intent = new Intent(CadastroStep3Activity.this, GruposGrupoActivity.class);
                    CadastroStep3Activity.this.startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("grupoid")) {
            grupoID = getIntent().getStringExtra("grupoid");
        }
    }
}
