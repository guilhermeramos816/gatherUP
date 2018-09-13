package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class PerguntaActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pergunta);
        getIncomingIntent();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_change, R.anim.slide_out_down);
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("titulo") && getIntent().hasExtra("titulo")){
            String titulo = getIntent().getStringExtra("titulo");
            TextView textView = findViewById(R.id.pergunta_titulo);
            textView.setText(titulo);
        }
    }

}
