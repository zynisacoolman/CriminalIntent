package com.example.zyn.criminalintent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.UUID;

/**
 * Created by zyn on 2014/12/17.
 */
public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate=new Date();
    private boolean mSolved;

    public UUID getID() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Date getDate() {
        return mDate;
    }
    @Override
    public String toString(){
        return mTitle;
    }
}
