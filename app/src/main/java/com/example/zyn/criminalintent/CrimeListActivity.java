package com.example.zyn.criminalintent;

import android.support.v4.app.Fragment;
/**
 * Created by zyn on 2014/12/18.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
