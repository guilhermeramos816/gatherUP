package com.example.guilhermeoramos.gatherup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterRespostas extends RecyclerView.Adapter<RecyclerViewAdapterRespostas.ViewHolder> {

    private ArrayList<String> mRespostasID;
    private ArrayList<String> mRespostas;
    private ArrayList<String> mAutores;
    private ArrayList<String> mDatas;
    private ArrayList<String> mLikes;
    private ArrayList<String> mComentarios;
    private Context mContext;

    public RecyclerViewAdapterRespostas(ArrayList<String> respostasID, ArrayList<String> respostas, ArrayList<String> autores, ArrayList<String> datas, ArrayList<String> likes, ArrayList<String> comentarios, Context context) {
        mRespostasID = respostasID;
        mRespostas = respostas;
        mAutores = autores;
        mDatas = datas;
        mLikes = likes;
        mComentarios = comentarios;
        mContext = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_respostasitens, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.respostaID.setText(mRespostasID.get(position));
        holder.resposta.setText(mRespostas.get(position));
        holder.autor.setText(mAutores.get(position));
        holder.data.setText(mDatas.get(position));
        holder.likes.setText(mLikes.get(position));
        holder.comentarios.setText(mComentarios.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui é onde vamos chamar a nova intent, aquela que vai conter a opção de reposta
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRespostas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView respostaID;
        TextView resposta;
        TextView autor;
        TextView data;
        TextView likes;
        TextView comentarios;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            respostaID = itemView.findViewById(R.id.respostasItens_repostaid);
            resposta = itemView.findViewById(R.id.respostasItens_reposta);
            autor = itemView.findViewById(R.id.respostasItens_autor);
            data = itemView.findViewById(R.id.respostasItens_data);
            likes = itemView.findViewById(R.id.respostasItens_likes);
            comentarios = itemView.findViewById(R.id.respostasItens_comentarios);
            parentLayout = itemView.findViewById(R.id.perguntasItens_layout);
        }
    }
}
