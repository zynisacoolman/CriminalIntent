package com.example.zyn.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by zyn on 2014/12/18.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{
    protected abstract Fragment createFragment();
    @Override
    public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm =getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_fragment);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.activity_fragment,fragment)
                    .commit();
        }
    }
}
