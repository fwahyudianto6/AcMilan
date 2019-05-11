package com.fwahyudianto.rossoneri.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *  This software, all associated documentation, and all copies are CONFIDENTIAL INFORMATION of Kalpawreska Teknologi Indonesia
 *  http://www.fwahyudianto.id
 *  ® Wahyudianto, Fajar
 *  Email 	: fwahyudi06@gmail.com
 */

public class Player implements Parcelable {
    protected String m_strNumberTshirt = "";
    protected String m_strFullName = "";
    protected String m_strNickName = "";
    protected String m_strPhoto = "";
    protected String m_strDescriptions = "";

    //  Constructor
    public Player() {

    }

    //  Implement Parcelable
    protected Player(Parcel in) {
        m_strNumberTshirt = in.readString();
        m_strFullName = in.readString();
        m_strNickName = in.readString();
        m_strPhoto = in.readString();
        m_strDescriptions = in.readString();
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
    public String getNumberTshirt() {
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

    public String getDescriptions() {
        return m_strDescriptions;
    }

    //  Setter
    public void setNumberTshirt(String p_strNumberTshirt) {
        this.m_strNumberTshirt = p_strNumberTshirt;
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

    public void setDescriptions(String p_strDescriptions) {
        this.m_strDescriptions = p_strDescriptions;
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
        dest.writeString(m_strDescriptions);
    }
}
