package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PesquisaActivity extends Activity {
    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);

//        ListView lv = (ListView) findViewById(R.id.my_list);
//        List<String> initialList = new ArrayList<String>(); //load these
//        mAdapter = new ArrayAdapter(this, R.layout.layout_perguntasitens, initialList);
//        lv.setadapter(mAdapter);
    }


}
