package com.example.zyn.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zyn on 2014/12/18.
 */
public class CrimeListFragment extends ListFragment {
    private static final String TAG="CrimeListFragment";
    private ArrayList<Crime> mCrimes;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes=CrimeLab.get(getActivity()).getCrimes();

//        ArrayAdapter<Crime> adapter =
//                new ArrayAdapter<Crime>(getActivity(),
//                        android.R.layout.simple_list_item_1,
//                        mCrimes);
        CrimeAdapter adapter=new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id){
        Crime c=((CrimeAdapter)getListAdapter()).getItem(position);
//        Log.d(TAG, c.getTitle() + "was clicked");
        Intent i = new Intent(getActivity(),CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID,c.getDate());
        startActivity(i);
    }


    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(),0,crimes);
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            if(convertView==null){
                convertView=getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime,null);
            }
            //configure the view for this Crime
            Crime c =getItem(position);

            TextView titleTextView=
                    (TextView)convertView.findViewById(R.id.crime_list_item_titleTextview);
            titleTextView.setText(c.getTitle());

            TextView dateTextView=
                    (TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getDate().toString());

            CheckBox solvedCheckBox=
                    (CheckBox)convertView.findViewById(R.id.crime_list_item_solvedCheckbox);
            solvedCheckBox.setChecked(c.isSolved());

            return convertView;
        }
    }
}
