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

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.ListViewHolder> {
    //  Variable
    private Context oContext;
    private ArrayList<Player> alPlayer;

    //  Constructor
    public PlayerListAdapter(Context p_oContext) {
        this.oContext = p_oContext;
    }

    //  Getter
    public ArrayList<Player> getPlayer() {
        return alPlayer;
    }

    //  Setter
    public void setPlayer(ArrayList<Player> p_alPresident) {
        this.alPlayer = p_alPresident;
    }

    @NonNull
    @Override
    public PlayerListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup oViewGroup, int i) {
        View oView = LayoutInflater.from(oViewGroup.getContext()).inflate(
                R.layout.item_hall_of_fame_list, oViewGroup, false);

        return new ListViewHolder(oView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListAdapter.ListViewHolder oHolder, int iIndex) {
        oHolder.tvFullName.setText(getPlayer().get(iIndex).getFullName());
        oHolder.tvDescriptions.setText(getPlayer().get(iIndex).getDescriptions());

        Glide.with(oContext)
                .load(getPlayer().get(iIndex).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(oHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return getPlayer().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvDescriptions;
        ImageView ivPhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFullName = itemView.findViewById(R.id.tv_full_name);
            tvDescriptions = itemView.findViewById(R.id.tv_player_descriptions);
            ivPhoto = itemView.findViewById(R.id.civ_picture);
        }
    }
}