package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OverviewActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        TextView jan = findViewById(R.id.overview_jan);
        setClick(jan, "Janeiro");
        TextView fev = findViewById(R.id.overview_fev);
        setClick(fev, "Fevereiro");
        TextView mar = findViewById(R.id.overview_mar);
        setClick(mar, "Março");
        TextView abr = findViewById(R.id.overview_abr);
        setClick(abr, "Abril");
        TextView mai = findViewById(R.id.overview_mai);
        setClick(mai, "Maio");
        TextView jun = findViewById(R.id.overview_jun);
        setClick(jun, "Junho");
        TextView jul = findViewById(R.id.overview_jul);
        setClick(jul, "Julho");
        TextView ago = findViewById(R.id.overview_ago);
        setClick(ago, "Agosto");
        TextView set = findViewById(R.id.overview_set);
        setClick(set, "Setembro");
        TextView out = findViewById(R.id.overview_out);
        setClick(out, "Outubro");
        TextView nov = findViewById(R.id.overview_nov);
        setClick(nov, "Novembro");
        TextView dez = findViewById(R.id.overview_dez);
        setClick(dez, "Dezembro");
    }


    private void setClick(TextView textView, final String titulo){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverviewActivity.this, OverviewMonthActivity.class);
                intent.putExtra("titulo", titulo);
                OverviewActivity.this.startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
