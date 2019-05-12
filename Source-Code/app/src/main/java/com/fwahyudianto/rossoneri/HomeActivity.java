package com.fwahyudianto.rossoneri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.fwahyudianto.rossoneri.controllers.PlayerGridAdapter;
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

        /*
        setActionBarTitle("Hall of Fame");
        alData.addAll(PlayerData.List());
        RecyclerList(); */

        alData = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Hall of Fame - List View");
            alData.addAll(PlayerData.List());
            RecyclerList();
            iMode = R.id.menu_list;
        } else {
            String strTitle = savedInstanceState.getString(m_strStateTitle);
            ArrayList<Player> oPlayer = savedInstanceState.getParcelableArrayList(m_strStateList);
            int iStateMode = savedInstanceState.getInt(m_strStateMode);

            setActionBarTitle(strTitle);
            alData.addAll(oPlayer);
            setMode(iStateMode);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle oBundle) {
        super.onSaveInstanceState(oBundle);
        oBundle.putString(m_strStateTitle, getSupportActionBar().getTitle().toString());
        oBundle.putParcelableArrayList(m_strStateList, alData);
        oBundle.putInt(m_strStateMode, iMode);
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

    @Override
    public boolean onCreateOptionsMenu(Menu p_oMenu) {
        getMenuInflater().inflate(R.menu.menu_home, p_oMenu);

        return super.onCreateOptionsMenu(p_oMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem p_oMenuItem) {
        setMode(p_oMenuItem.getItemId());

        return super.onOptionsItemSelected(p_oMenuItem);
    }

    //  Method
    private void RecyclerList(){
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PlayerListAdapter oPlayerListAdapter = new PlayerListAdapter(this);
        oPlayerListAdapter.setPlayer(alData);

        oRecyclerView.setAdapter(oPlayerListAdapter);
    }

    private void RecyclerGrid(){
        oRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        PlayerGridAdapter oPlayerGridAdapter = new PlayerGridAdapter(this);
        oPlayerGridAdapter.setPlayer(alData);

        oRecyclerView.setAdapter(oPlayerGridAdapter);
    }

    private void setActionBarTitle(String p_strTitle) {
        getSupportActionBar().setTitle(p_strTitle);
    }

    private void setMode(int p_iMode) {
        String strTitle = null;
        switch (p_iMode) {
            case R.id.menu_list:
                strTitle = "Hall of Fame - List View";
                RecyclerList();
                break;
            case R.id.menu_grid:
                strTitle = "Hall of Fame - Grid View";
                RecyclerGrid();
                break;
        }

        iMode = p_iMode;
        setActionBarTitle(strTitle);
    }
}