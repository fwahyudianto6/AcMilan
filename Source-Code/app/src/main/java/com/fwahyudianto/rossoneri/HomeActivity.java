package com.fwahyudianto.rossoneri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.fwahyudianto.rossoneri.controllers.PlayerListAdapter;
import com.fwahyudianto.rossoneri.models.Player;
import com.fwahyudianto.rossoneri.models.PlayerData;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    final String m_strStateTitle = "state_title";
    final String m_strStateList = "state_list";
    final String m_strStateMode = "state_mode";
    int iMode;
    private long m_lngBackPressed;
    private Toast m_oToast;
    private RecyclerView oRecyclerView;
    private ArrayList<Player> alData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        oRecyclerView = findViewById(R.id.rv_main);
        oRecyclerView.setHasFixedSize(true);

        setActionBarTitle("Hall of Fame");
        alData.addAll(PlayerData.List());
        RecyclerList();
    }

    @Override
    public void onBackPressed() {
        if (m_lngBackPressed + 2000 > System.currentTimeMillis()) {
            m_oToast.cancel();
            super.onBackPressed();
            return;
        } else {
            m_oToast = Toast.makeText(getBaseContext(), "Press back again to Exit!", Toast.LENGTH_SHORT);
            m_oToast.show();
        }

        m_lngBackPressed = System.currentTimeMillis();
    }

    //  Method
    private void RecyclerList(){
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PlayerListAdapter oPlayerListAdapter = new PlayerListAdapter(this);
        oPlayerListAdapter.setPlayer(alData);

        oRecyclerView.setAdapter(oPlayerListAdapter);
    }

    private void setActionBarTitle(String p_strTitle) {
        getSupportActionBar().setTitle(p_strTitle);
    }
}