package com.nahashon.school;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHolder extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList=new ArrayList<>();
    List<String> subjectList = new ArrayList<>();



    public ViewPagerHolder(Context context, FragmentManager manager){
        super(manager);


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return subjectList.get(position);
    }

    public int getCount(){
        return fragmentList.size();
    }








    public void addProperties(Fragment fragment,String heading){
        fragmentList.add(fragment);
        subjectList.add(heading);



    }


    @Override
    public Fragment getItem(int i) {
     return   fragmentList.get(i);
    }
}
