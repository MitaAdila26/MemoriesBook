package com.example.memoriesbook;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaHolder>  {
    private List<Siswa> siswanya;
    private Activity activity;

    public SiswaAdapter(List<Siswa> siswa, Activity activity){
        this.siswanya=siswa;
        this.activity=activity;
    }
    @NonNull
    @Override
    public SiswaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_item,parent,false);
        return new SiswaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SiswaHolder holder, final int i) {
        holder.nama.setText(siswanya.get(i).getNama());
        Picasso.with(activity).load(siswanya.get(i).getFoto1()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Siswa siswaa= siswanya.get(i);
                Intent intent=new Intent(activity,DetailActivity.class);
                intent.putExtra(DetailActivity.KEY_ACTIVITY, siswaa);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return siswanya.size();
    }

    static class SiswaHolder extends RecyclerView.ViewHolder{
        TextView nama;
        ImageView image;

        public SiswaHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.nama_profil);
            image = (ImageView)itemView.findViewById(R.id.img_profil);
        }
    }
}
