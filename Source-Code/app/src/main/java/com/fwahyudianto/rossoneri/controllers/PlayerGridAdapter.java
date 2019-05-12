package com.fwahyudianto.rossoneri.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fwahyudianto.rossoneri.R;
import com.fwahyudianto.rossoneri.models.Player;

import java.util.ArrayList;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class PlayerGridAdapter extends RecyclerView.Adapter<PlayerGridAdapter.GridViewHolder> {
    //  Variable
    private Context oContext;
    private ArrayList<Player> alPlayer;

    //  Constructor
    public PlayerGridAdapter(Context p_oContext) {
        this.oContext = p_oContext;
    }

    //  Getter
    public ArrayList<Player> getPlayer() {
        return alPlayer;
    }

    //  Setter
    public void setPlayer(ArrayList<Player> p_alPlayer) {
        this.alPlayer = p_alPlayer;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup oViewGroup, int iType) {
        View oView = LayoutInflater.from(oViewGroup.getContext()).inflate(
                R.layout.item_hall_of_fame_grid, (ViewGroup) oViewGroup, false);

        return new GridViewHolder(oView);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder oHolder, int iIndex) {
        oHolder.tvNumber.setText(getPlayer().get(iIndex).getNumber());
        oHolder.tvFulName.setText(getPlayer().get(iIndex).getFullName());

        Glide.with(oContext)
                .load(getPlayer().get(iIndex).getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(oHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return getPlayer().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;
        TextView tvFulName;
        ImageView ivPhoto;

        public GridViewHolder(@NonNull View oView) {
            super(oView);

            tvNumber = oView.findViewById(R.id.tv_number);
            tvFulName = oView.findViewById(R.id.tv_full_name);
            ivPhoto = oView.findViewById(R.id.img_photo);
        }
    }
}