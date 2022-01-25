package com.yes.notdefteri.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yes.notdefteri.R;

import java.util.List;

public class NotAdapter extends RecyclerView.Adapter<NotAdapter.ViewHolder> {

    List<String> basliklar;
    List<String> icerik;

    public NotAdapter(List<String> basliklar,List<String> icerik){
        this.basliklar = basliklar;
        this.icerik = icerik;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.noteTitle.setText(basliklar.get(position));
        holder.noteContent.setText(icerik.get(position));



    }

    @Override
    public int getItemCount() {
        return basliklar.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView noteTitle,noteContent;
        View view;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.titles);
            noteContent = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.noteCard);
            view = itemView;
        }
    }
}
