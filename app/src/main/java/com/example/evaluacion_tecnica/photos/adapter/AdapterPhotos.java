package com.example.evaluacion_tecnica.photos.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.photos.model.PhotosModel;
import com.example.evaluacion_tecnica.utils.Global;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolderAdapterPhotos> {

    private List<PhotosModel> photos;
    private Context ctx;


    public AdapterPhotos(List<PhotosModel> photos, Context context) {
        this.photos = photos;
        this.ctx = context;
    }

    @NonNull
    @Override
    public AdapterPhotos.ViewHolderAdapterPhotos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photos, null);
        return new AdapterPhotos.ViewHolderAdapterPhotos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPhotos.ViewHolderAdapterPhotos holder, int position) {

        /*Picasso.with(ctx)
                .load(photos.get(position).getThumbnailUrl())
                .resize(60, 60)
                .centerCrop()
                .into(holder.imagen);*/

        Glide.with(ctx)
                .asBitmap()
                .load(photos.get(position).getThumbnailUrl())
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class ViewHolderAdapterPhotos extends RecyclerView.ViewHolder {
        ImageView imagen;

        public ViewHolderAdapterPhotos(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.photo);
        }
    }
}
