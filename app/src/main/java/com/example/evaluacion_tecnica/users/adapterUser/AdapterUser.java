package com.example.evaluacion_tecnica.users.adapterUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.comments.view.CommentsFragment;
import com.example.evaluacion_tecnica.photos.view.PhotosFragment;
import com.example.evaluacion_tecnica.users.model.Users;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolderAdapterUser> {

    private List<Users> users;
    FragmentActivity com;

    public AdapterUser(List<Users> users, FragmentActivity activity) {
        this.users = users;
        this.com = activity;
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

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle datos = new Bundle();
                datos.putInt("id", users.get(position).getId());
                datos.putInt("userId", users.get(position).getUserId());
                Fragment fragment = new CommentsFragment();
                fragment.setArguments(datos);
                com.getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).addToBackStack(null).commit();
            }
        });

        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle datos = new Bundle();
                datos.putInt("id", users.get(position).getId());
                datos.putInt("userId", users.get(position).getUserId());
                Fragment fragment = new PhotosFragment();
                fragment.setArguments(datos);
                com.getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolderAdapterUser extends RecyclerView.ViewHolder {
        TextView title;
        TextView body;
        ImageView photo;
        ImageView comment;

        public ViewHolderAdapterUser(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
            photo = itemView.findViewById(R.id.photos);
            comment = itemView.findViewById(R.id.comments);
        }
    }
    public void filtar(List<Users> users){
        this.users = users;
        notifyDataSetChanged();
    }
}
