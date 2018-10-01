package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTitulos;
    private ArrayList<String> mDescricoes;
    private ArrayList<String> mDatas;
    private ArrayList<String> mAutores;
    private ArrayList<String> mLikes;
    private ArrayList<String> mComentarios;
    private ArrayList<String> mPerguntasID;
    private Class mDestino;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> titulos, ArrayList<String> descricoes, ArrayList<String> datas, ArrayList<String> autores, ArrayList<String> likes, ArrayList<String> comentarios, ArrayList<String> perguntasID, Context context, Class destino){
        mTitulos = titulos;
        mDescricoes = descricoes;
        mDatas = datas;
        mAutores = autores;
        mLikes = likes;
        mComentarios = comentarios;
        mContext = context;
        mDestino = destino;
        mPerguntasID = perguntasID;
    }

    @NonNull
    @Override
    //Responsible for inflating the view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_perguntasitens, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.titulo.setText(mTitulos.get(position));
        holder.descricao.setText(mDescricoes.get(position));
        holder.data.setText(mDatas.get(position));
        holder.autor.setText(mAutores.get(position));
        holder.likes.setText(mLikes.get(position));
        holder.comentarios.setText(mComentarios.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on." + mTitulos.get(position));

                Intent intent = new Intent(mContext, mDestino);
                intent.putExtra("titulo", mTitulos.get(position));
                intent.putExtra("descricao", mDescricoes.get(position));
                intent.putExtra("data", mDatas.get(position));
                intent.putExtra("perguntaid", mPerguntasID.get(position));
                mContext.startActivity(intent);
                ((Activity)mContext).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
        TextView data;
        TextView autor;
        TextView likes;
        TextView comentarios;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tarefasItens_titulo);
            descricao = itemView.findViewById(R.id.tarefasItens_descricao);
            data = itemView.findViewById(R.id.tarefasItens_data_);
            autor = itemView.findViewById(R.id.tarefasItens_autor);
            likes = itemView.findViewById(R.id.tarefasItens_likes);
            comentarios = itemView.findViewById(R.id.tarefasItens_comentarios);
            parentLayout = itemView.findViewById(R.id.perguntasItens_layout);
        }
    }
}
