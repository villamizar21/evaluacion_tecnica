package com.example.evaluacion_tecnica.adapterUser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.model.Users;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolderAdapterUser>{
    private List<Users> users;

    public AdapterUser(List<Users> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolderAdapterUser onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users, null);

        return new ViewHolderAdapterUser(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapterUser holder, int position) {
        holder.title.setText(users.get(position).getTitle());
        holder.body.setText(users.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolderAdapterUser extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;
        public ViewHolderAdapterUser(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
