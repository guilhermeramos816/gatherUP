package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;

public class CadastroActivity extends Activity {
    Button btnCadastrar;
    EditText nome;
    EditText email;
    EditText senha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.cadastro_nome);
        email = findViewById(R.id.cadastro_email);
        senha = findViewById(R.id.cadastro_senha);
        btnCadastrar = findViewById(R.id.cadastro_cadastrar);

        cadastrar();
    }

    private void goMain() {
        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
        CadastroActivity.this.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void cadastrar() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeTexto = nome.getText().toString();
                String emailTexto = email.getText().toString();
                String senhaTexto = senha.getText().toString();
                if (!(nomeTexto.isEmpty()
                        || emailTexto.isEmpty()
                        || senhaTexto.isEmpty())) {
                    try {
                        Firebase firebase = new Firebase();
                        firebase.enviarCadastro(nomeTexto.trim(), emailTexto.trim(), senhaTexto.trim());
                        Toast toast = Toast.makeText(CadastroActivity.this, "Cadastro realizado", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 40);
                        toast.show();
                        goMain();
                    } catch (Exception ex) {
                        Toast.makeText(CadastroActivity.this, ex.toString(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast toast = Toast.makeText(CadastroActivity.this, "Preencha o formulário", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 40);
                    toast.show();
                }
            }
        });
    }

}
