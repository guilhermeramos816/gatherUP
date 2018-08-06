package com.example.guilhermeoramos.gatherup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    ArrayList<String> mTitulos = new ArrayList<>();
    ArrayList<String> mDescricoes = new ArrayList<>();
    Context mContext;

    public RecyclerViewAdapter(ArrayList<String> titulos, ArrayList<String> descricoes, Context context){
        mTitulos = titulos;
        mDescricoes = descricoes;
        mContext = context;
    }

    @NonNull
    @Override
    //Responsable for inflating the view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tarefasitens, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.titulo.setText(mTitulos.get(position));
        holder.descricao.setText(mDescricoes.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on." + mTitulos.get(position));

                Toast.makeText(mContext, mTitulos.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitulos.size();
    }

    //This method holds every item in cache and then recycle them all
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView descricao;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tarefasItens_titulo);
            descricao = itemView.findViewById(R.id.tarefasItens_descricao);
            parentLayout = itemView.findViewById(R.id.tarefasItens_layout);
        }
    }
}
