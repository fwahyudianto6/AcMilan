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
        oHolder.tvNickName.setText(getPlayer().get(iIndex).getNickName());
        oHolder.tvNumber.setText(getPlayer().get(iIndex).getNumber());
        oHolder.tvPosition.setText(getPlayer().get(iIndex).getPosition());
        oHolder.tvBirthdate.setText(getPlayer().get(iIndex).getBirthdate());
        oHolder.tvBirthplace.setText(getPlayer().get(iIndex).getBirthplace());

        Glide.with(oContext)
                .load(getPlayer().get(iIndex).getPhoto())
                .apply(new RequestOptions().override(75, 75))
                .into(oHolder.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return getPlayer().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;
        TextView tvFullName;
        TextView tvNickName;
        TextView tvBirthdate;
        TextView tvBirthplace;
        TextView tvPosition;
        ImageView ivPhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumber = itemView.findViewById(R.id.tv_number);
            tvFullName = itemView.findViewById(R.id.tv_full_name);
            tvNickName = itemView.findViewById(R.id.tv_nick_name);
            tvBirthdate = itemView.findViewById(R.id.tv_birthdate);
            tvBirthplace = itemView.findViewById(R.id.tv_birthplace);
            tvPosition = itemView.findViewById(R.id.tv_position);
            ivPhoto = itemView.findViewById(R.id.civ_picture);
        }
    }
}