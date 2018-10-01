package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class RespostaActivity extends Activity {
    String resposta;
    String autor;
    String data;
    String respostaID;

    TextView txtResposta;
    TextView txtAutor;
    TextView txtData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("resposta") && getIntent().hasExtra("autor")) {
            resposta = getIntent().getStringExtra("resposta");
            autor = getIntent().getStringExtra("autor");
            data = getIntent().getStringExtra("data");
            respostaID = getIntent().getStringExtra("respostaid");

            txtResposta = findViewById(R.id.resposta_resposta);
            txtAutor = findViewById(R.id.resposta_autor);
            txtData = findViewById(R.id.resposta_data);

            txtResposta.setText(resposta);
            txtAutor.setText(autor);
            txtData.setText(data);
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
