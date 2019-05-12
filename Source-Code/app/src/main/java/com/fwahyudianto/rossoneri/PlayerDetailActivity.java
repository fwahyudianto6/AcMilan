package com.fwahyudianto.rossoneri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fwahyudianto.rossoneri.models.Player;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class PlayerDetailActivity extends AppCompatActivity {
    public static final String m_strStateList = "state_list";

    TextView tvNickName;
    TextView tvFullName;
    TextView tvNumber;
    ImageView ivPhoto;
    ImageView ivBadgeNumber;
    TextView tvNumberTshirtProfile;
    TextView tvNumberTshirt;
    TextView tvBirthdateProfile;
    TextView tvBirthplaceProfile;
    TextView tvBirthdate;
    TextView tvBirthplace;

    ImageView ivBadgeTotalMatches;
    TextView tvTotalMatchesStats;
    TextView tvTotalMatches;
    ImageView ivBadgeTotalGoals;
    TextView tvTotalGoalsStats;
    TextView tvTotalGoals;
    ImageView ivBadgeLeagueMatches;
    TextView tvLeagueMatchesStats;
    TextView tvLeagueMatches;
    ImageView ivBadgeLeagueGoals;
    TextView tvLeagueGoalsStats;
    TextView tvLeagueGoals;

    TextView tvFullnameDescription;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        tvNickName = findViewById(R.id.tv_nick_name);
        tvNumber = findViewById(R.id.tv_number);
        tvFullName = findViewById(R.id.tv_full_name);
        ivPhoto = findViewById(R.id.img_photo);

        ivBadgeNumber = findViewById(R.id.img_badge_number);
        tvNumberTshirtProfile = findViewById(R.id.tv_number_tshirt_profile);
        tvNumberTshirt = findViewById(R.id.tv_number_tshirt);
        tvBirthdateProfile = findViewById(R.id.tv_birthdate_profile);
        tvBirthplaceProfile = findViewById(R.id.tv_birthplace_profile);
        tvBirthdate = findViewById(R.id.tv_birthdate);
        tvBirthplace = findViewById(R.id.tv_birthplace);

        ivBadgeTotalMatches = findViewById(R.id.img_badge_total_matches);
        tvTotalMatchesStats = findViewById(R.id.tv_totalmatches_stats);
        tvTotalMatches = findViewById(R.id.tv_totalmatches);
        ivBadgeTotalGoals = findViewById(R.id.img_badge_total_goals);
        tvTotalGoalsStats = findViewById(R.id.tv_totalgoals_stats);
        tvTotalGoals = findViewById(R.id.tv_totalgoals);

        ivBadgeLeagueMatches = findViewById(R.id.img_badge_league_matches);
        tvLeagueMatchesStats = findViewById(R.id.tv_leaguematches_stats);
        tvLeagueMatches = findViewById(R.id.tv_leaguematches);
        ivBadgeLeagueGoals = findViewById(R.id.img_badge_league_goals);
        tvLeagueGoalsStats = findViewById(R.id.tv_leaguegoals_stats);
        tvLeagueGoals = findViewById(R.id.tv_leaguegoals);

        tvFullnameDescription = findViewById(R.id.tv_full_name_description);
        tvDescription = findViewById(R.id.tv_description);

        Player oPlayerDetail = getIntent().getParcelableExtra(m_strStateList);

        if (oPlayerDetail != null) {
            setActionBarTitle(oPlayerDetail.getFullName() + "'s Profile");

            tvNickName.setText(oPlayerDetail.getNickName());
            tvNumber.setText(oPlayerDetail.getNumber());
            tvFullName.setText(oPlayerDetail.getFullName());
            Glide.with(PlayerDetailActivity.this)
                    .load(oPlayerDetail.getPhoto())
                    .into(ivPhoto);

            ivBadgeNumber.setImageResource(R.drawable.badge_tshirt);
            tvNumberTshirt.setText(oPlayerDetail.getNumber());
            tvBirthdate.setText(oPlayerDetail.getBirthdate());
            tvBirthplace.setText(oPlayerDetail.getBirthplace());

            ivBadgeTotalMatches.setImageResource(R.drawable.badge_matches);
            tvTotalMatches.setText(oPlayerDetail.getTotalMatches());
            ivBadgeTotalGoals.setImageResource(R.drawable.badge_goals);
            tvTotalGoals.setText(oPlayerDetail.getTotalGoals());
            ivBadgeLeagueMatches.setImageResource(R.drawable.badge_league_matches);
            tvLeagueMatches.setText(oPlayerDetail.getLeagueMathes());
            ivBadgeLeagueGoals.setImageResource(R.drawable.badge_league_goals);
            tvLeagueGoals.setText(oPlayerDetail.getLeagueGoals());

            tvFullnameDescription.setText(oPlayerDetail.getFullName());
            tvDescription.setText(oPlayerDetail.getDescriptions());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent oIntentPrevious = new Intent(PlayerDetailActivity.this, HomeActivity.class);

        oIntentPrevious.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(oIntentPrevious);
        finish();
    }

    //  Method
    private void setActionBarTitle(String p_strTitle) {
        getSupportActionBar().setTitle(p_strTitle);
    }
}