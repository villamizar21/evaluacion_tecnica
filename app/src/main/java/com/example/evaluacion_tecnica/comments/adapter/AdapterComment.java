package com.example.evaluacion_tecnica.comments.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.comments.model.Comments;

import java.util.List;

public class AdapterComment extends RecyclerView.Adapter<AdapterComment.ViewHolderAdapterComment> {
    
    private List<Comments> comments;

    public AdapterComment(List<Comments> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolderAdapterComment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comments, null);
        return new AdapterComment.ViewHolderAdapterComment(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterComment holder, int position) {
        holder.body.setText(comments.get(position).getBody());
        holder.email.setText(comments.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolderAdapterComment extends RecyclerView.ViewHolder {
        TextView body;
        TextView email;
        public ViewHolderAdapterComment(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.email);
            body = itemView.findViewById(R.id.body);

        }
    }
}
