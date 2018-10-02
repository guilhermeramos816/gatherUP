package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CadastroStep2Activity extends Activity {
    String titulo;
    String descricao;
    String grupoID = "0";
    String tag;

    ListView lista;
    EditText termo;
    FloatingActionButton pesquisar;

    ArrayList<String> resultados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_step2);
        goNextPage();
        getIncomingIntent();

        termo = findViewById(R.id.cadastro_step2_tags);
        pesquisar = findViewById(R.id.cadastro_step2_pesquisar);
        lista = findViewById(R.id.cadastro_step2_lista);

        testar();
        buscar();
        setTag();
    }

    private void testar() {
        resultados.add("Estruturas de dados");
        resultados.add("História da computação");
        resultados.add("Business");
        resultados.add("Marketing digital");
        resultados.add("Banco de dados");
        resultados.add("Português");
        resultados.add("História");
        resultados.add("Matemática");
        resultados.add("Geografia");
        resultados.add("Programação");
        resultados.add("Biologia");
        resultados.add("Física");
        resultados.add("Mecânica dos fluídos");
        resultados.add("Engenharia de software");
        resultados.add("Eletrônica");
        resultados.add("Design de circuitos");
        resultados.add("Redes");
        resultados.add("Estruturas de dados");
        resultados.add("História da computação");
        resultados.add("Business");
        resultados.add("Marketing digital");
        resultados.add("Banco de dados");
    }

    private void setTag() {
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String saved = termo.getText().toString().trim();
                if (termo.getText().toString().isEmpty())
                    termo.setText(lista.getItemAtPosition(i).toString());
                else
                    termo.setText(saved + "; " + lista.getItemAtPosition(i).toString());
            }
        });
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("titulo") && getIntent().hasExtra("descricao")) {
            titulo = getIntent().getStringExtra("titulo");
            descricao = getIntent().getStringExtra("descricao");
        }
        if(getIntent().hasExtra("grupoid")){
            grupoID = getIntent().getStringExtra("grupoid");
        }
    }

    private void buscar() {
        pesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popular();
            }
        });
    }

    private ArrayList<String> filtrar(ArrayList<String> ar) {
        ArrayList<String> filtrado = new ArrayList<>();
        for (String el : ar) {
            if (el.toLowerCase().trim().contains(getText().toLowerCase())) {
                filtrado.add(el);
            }
        }
        return filtrado;
    }

    public String getText() {
        return termo.getText().toString().trim();
    }

    private void popular() {
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filtrar(resultados));
        lista.setAdapter(adapter);
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
            textView.startAnimation(AnimationUtils.loadAnimation(CadastroStep2Activity.this, R.anim.slide_left_center));
        }
    }

    private void goNextPage() {
        FloatingActionButton btn = findViewById(R.id.btncontinuar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novaPergunta();
                Intent intent = new Intent(CadastroStep2Activity.this, CadastroStep3Activity.class);
                intent.putExtra("grupoid", grupoID);
                CadastroStep2Activity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void novaPergunta() {
        EditText editTextTag = findViewById(R.id.cadastro_step2_tags);
        tag = editTextTag.getText().toString().trim();
        Firebase firebase = new Firebase();
        firebase.enviarPergunta(titulo, descricao, tag, grupoID);
    }

}
