package com.example.zyn.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.UUID;

/**
 * Created by zyn on 2014/12/17.
 */
public class CrimeFragment extends Fragment{
    public static final String EXTRA_CRIME_ID =
            "com.bignerdranch.android.criminalintent.crime.id";
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
//        mCrime=new Crime();
        UUID crimeId=(UUID)getActivity().getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);

        mCrime=CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup parent,Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_crime,parent,false);
        //接受数据


        mTitleField=(EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(
                    CharSequence c,int start,int before,int count){
                mCrime.setTitle(c.toString());
            }
            @Override
            public void beforeTextChanged(
                    CharSequence c,int start,int count,int after){
                //This space intentionally left blank
            }
            @Override
            public void afterTextChanged(Editable c){
                //this one too
            }
        });

        mDateButton=(Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox=(CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                //Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
}
