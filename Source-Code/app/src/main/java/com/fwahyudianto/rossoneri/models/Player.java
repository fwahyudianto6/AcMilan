package com.fwahyudianto.rossoneri.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 * http://www.fwahyudianto.id
 * ® Wahyudianto, Fajar
 * Email 	: fwahyudi06@gmail.com
 */

public class Player implements Parcelable {
    //  Profile
    protected String m_strNumberTshirt = "";
    protected String m_strFullName = "";
    protected String m_strNickName = "";
    protected String m_strPhoto = "";
    protected String m_strBirthdate = "";
    protected String m_strBirthplace = "";
    protected String m_strPosition = "";
    protected String m_strDescriptions = "";

    // Statistic
    protected String m_strTotalMatches = "";
    protected String m_strTotalGoals = "";
    protected String m_strLeagueMatches = "";
    protected String m_strLeagueGoals = "";

    //  Constructor
    public Player() {

    }

    //  Implement Parcelable
    protected Player(Parcel in) {
        m_strNumberTshirt = in.readString();
        m_strFullName = in.readString();
        m_strNickName = in.readString();
        m_strPhoto = in.readString();
        m_strBirthdate = in.readString();
        m_strBirthplace = in.readString();
        m_strPosition = in.readString();
        m_strDescriptions = in.readString();

        m_strTotalMatches = in.readString();
        m_strTotalGoals = in.readString();
        m_strLeagueMatches = in.readString();
        m_strLeagueGoals = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    //  Gettter
    public String getNumber() {
        return m_strNumberTshirt;
    }
    public String getFullName() {
        return m_strFullName;
    }
    public String getNickName() {
        return m_strNickName;
    }
    public String getPhoto() {
        return m_strPhoto;
    }
    public String getBirthdate() {
        return m_strBirthdate;
    }
    public String getBirthplace() {
        return m_strBirthplace;
    }
    public String getPosition() {
        return m_strPosition;
    }
    public String getDescriptions() {
        return m_strDescriptions;
    }
    public String getTotalMatches() {
        return m_strTotalMatches;
    }
    public String getTotalGoals() {
        return m_strTotalGoals;
    }
    public String getLeagueMathes() {
        return m_strLeagueMatches;
    }
    public String getLeagueGoals() {
        return m_strLeagueGoals;
    }

    //  Setter
    public void setNumber(String p_strNumber) {
        this.m_strNumberTshirt = p_strNumber;
    }
    public void setFullName(String p_strFullName) {
        this.m_strFullName = p_strFullName;
    }
    public void setNickName(String p_strNickName) {
        this.m_strNickName = p_strNickName;
    }
    public void setPhoto(String p_strPhoto) {
        this.m_strPhoto = p_strPhoto;
    }
    public void setBirthdate (String p_strBirthdate) {
        this.m_strBirthdate = p_strBirthdate;
    }
    public void setBirthplace(String p_strBirthplace) {
        this.m_strBirthplace = p_strBirthplace;
    }
    public void setPosition(String p_strPosition) {
        this.m_strPosition = p_strPosition;
    }
    public void setDescriptions(String p_strDescriptions) {
        this.m_strDescriptions = p_strDescriptions;
    }
    public void setTotalMatches(String p_strTotalMatches) {
        this.m_strTotalMatches = p_strTotalMatches;
    }
    public void setTotalGoals(String p_strTotalGoals) {
        this.m_strTotalGoals = p_strTotalGoals;
    }
    public void setLeagueMatches(String p_strLeagueMatches) {
        this.m_strLeagueMatches = p_strLeagueMatches;
    }
    public void setLeagueGoals(String p_strLeagueGoals) {
        this.m_strLeagueGoals = p_strLeagueGoals;
    }

    //  Method - Implement Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_strNumberTshirt);
        dest.writeString(m_strFullName);
        dest.writeString(m_strNickName);
        dest.writeString(m_strPhoto);
        dest.writeString(m_strBirthdate);
        dest.writeString(m_strBirthplace);
        dest.writeString(m_strPosition);
        dest.writeString(m_strDescriptions);
        dest.writeString(m_strTotalMatches);
        dest.writeString(m_strTotalGoals);
        dest.writeString(m_strLeagueMatches);
        dest.writeString(m_strLeagueGoals);
    }
}