package com.example.zyn.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by zyn on 2014/12/18.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected abstract Fragment createFragment();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.setContentView(R.layout.activity_fragment);
    }
}
