package com.example.zyn.criminalintent;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;

/**
 * Created by zyn on 2014/12/18.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes=CrimeLab.get(getActivity()).getCrimes();
    }
}
