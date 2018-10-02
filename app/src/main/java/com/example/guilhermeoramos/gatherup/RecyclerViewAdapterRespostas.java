package com.example.guilhermeoramos.gatherup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.respostaID.setText(mRespostasID.get(position));
        holder.resposta.setText(mRespostas.get(position));
        holder.autor.setText(mAutores.get(position));
        holder.data.setText(mDatas.get(position));
        holder.likes.setText(mLikes.get(position));
        holder.comentarios.setText(mComentarios.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RespostaActivity.class);
                intent.putExtra("resposta", mRespostas.get(position));
                intent.putExtra("autor", mAutores.get(position));
                intent.putExtra("data", mDatas.get(position));
                intent.putExtra("repostaid", mRespostasID.get(position));
                mContext.startActivity(intent);
                ((Activity)mContext).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        holder.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer likes =  Integer.parseInt(holder.likes.getText().toString().trim());
                likes++;
                holder.likes.setText(likes.toString());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    holder.btnUp.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_circle_blue));
                    holder.btnDown.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_circle_info_light));

                }
                holder.btnUp.setEnabled(false);
                holder.btnDown.setEnabled(true);

            }
        });

        holder.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer likes =  Integer.parseInt(holder.likes.getText().toString().trim());
                likes--;
                holder.likes.setText(likes.toString());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    holder.btnDown.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_circle_blue));
                    holder.btnUp.setBackground(ContextCompat.getDrawable(mContext, R.drawable.shape_circle_info_light));
                }
                holder.btnDown.setEnabled(false);
                holder.btnUp.setEnabled(true);
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
        LinearLayout btnUp;
        LinearLayout btnDown;

        public ViewHolder(View itemView) {
            super(itemView);
            respostaID = itemView.findViewById(R.id.respostasItens_repostaid);
            resposta = itemView.findViewById(R.id.respostasItens_reposta);
            autor = itemView.findViewById(R.id.respostasItens_autor);
            data = itemView.findViewById(R.id.respostasItens_data);
            likes = itemView.findViewById(R.id.respostasItens_likes);
            comentarios = itemView.findViewById(R.id.respostasItens_comentarios);
            parentLayout = itemView.findViewById(R.id.perguntasItens_layout);
            btnUp = itemView.findViewById(R.id.respostasItens_up);
            btnDown = itemView.findViewById(R.id.respostasItens_down);
        }
    }
}
