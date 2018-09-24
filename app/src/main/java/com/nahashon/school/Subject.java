package com.nahashon.school;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Subject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
    }


    public  class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
        private Context mContext;

        public  SimpleFragmentPagerAdapter(Context context, FragmentManager fragmentManager){
            super(fragmentManager);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position){
            if (position == 0){

            }
        }
    }
}
