package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterGrupos extends RecyclerView.Adapter<RecyclerViewAdapterGrupos.ViewHolder> {

    private ArrayList<String> mTitulos;
    private ArrayList<String> mDescricoes;
    private ArrayList<String> mCriadores;
    private ArrayList<String> mDatas;
    private ArrayList<String> mParticipantes;
    private Context mContext;

    public RecyclerViewAdapterGrupos(ArrayList<String> titulos, ArrayList<String> descricoes, ArrayList<String> datas, ArrayList<String> criadores, ArrayList<String> participantes, Context context) {
        mTitulos = titulos;
        mDescricoes = descricoes;
        mDatas = datas;
        mCriadores = criadores;
        mParticipantes = participantes;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grupositens, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.titulo.setText(mTitulos.get(position));
        holder.descricao.setText(mDescricoes.get(position));
        holder.data.setText(mDatas.get(position));
        holder.criador.setText(mCriadores.get(position));
        holder.participantes.setText(mParticipantes.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GruposGrupoActivity.class);
                intent.putExtra("titulo", mTitulos.get(position));
                mContext.startActivity(intent);
                ((Activity)mContext).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTitulos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView descricao;
        TextView criador;
        TextView data;
        TextView participantes;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.grupositens_titulo);
            descricao = itemView.findViewById(R.id.grupositens_descricao);
            data = itemView.findViewById(R.id.grupositens_data);
            criador = itemView.findViewById(R.id.grupositens_criador);
            participantes = itemView.findViewById(R.id.grupositens_participantes);
            parentLayout = itemView.findViewById(R.id.gruposItens_layout);
        }
    }
}
