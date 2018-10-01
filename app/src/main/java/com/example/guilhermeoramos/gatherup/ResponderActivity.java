package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResponderActivity extends Activity {
    EditText resposta;
    Button btnResponder;
    Button btnFechar;

    String perguntaID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder);

        btnResponder = findViewById(R.id.modal_resposta_responder);
        btnFechar = findViewById(R.id.modal_resposta_fechar);
        resposta = findViewById(R.id.modal_resposta_resposta);

        getIncomingIntent();
        responder();
        fechar();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("perguntaid")) {
            perguntaID = getIntent().getStringExtra("perguntaid");
        }
    }

    private void responder() {
        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = resposta.getText().toString().trim();
                if (!text.isEmpty()) {
                    Firebase firebase = new Firebase();
                    firebase.enviarResposta(perguntaID, text);
                    goBack();
                }
            }
        });
    }

    private void fechar() {
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBack();
            }
        });
    }

    private void goBack() {
        finish();
    }

}
