package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import  android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<Menu> menus;

    public MenuAdapter(Context mcontext, ArrayList<Menu> menuvape) {
        context = mcontext;
        menus = menuvape;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu, parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        final Menu menubaru = menus.get(position);
        String gambarbaru = menubaru.getGambar();
        String harga = menubaru.getHarga();
        String nama = menubaru.getNama();
        String produkid = menubaru.getProdukid();

        holder.tvnamadata.setText(nama);
        holder.tvhargadata.setText(harga);

        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);

        holder.btn_pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), detail.class);
                intent.putExtra("produkid", menubaru.getProdukid());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView imdata;
        public TextView tvhargadata;
        public TextView tvnamadata;
        public Button btn_pesan;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            imdata = itemView.findViewById(R.id.img_menu);
            tvhargadata = itemView.findViewById(R.id.tv_harga);
            tvnamadata = itemView.findViewById(R.id.tv_nama);
            btn_pesan = itemView.findViewById(R.id.btn_pesan);
        }

    }

}
