package com.nahashon.school;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHolder extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList=new ArrayList<>();
    List<String> subjectList = new ArrayList<>();
    List<String> level = new ArrayList<>();



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








    public void addProperties(Fragment fragment,String heading,String level){
        fragmentList.add(fragment);
        subjectList.add(heading);
        this.level.add(level);



    }


    @Override
    public Fragment getItem(int i) {

        Bundle bundle = new Bundle();
        bundle.putString("Subject",subjectList.get(i));
        bundle.putString("Level",level.get(i));

        Fragment fragment = fragmentList.get(i);

        fragment.setArguments(bundle);

     return fragment;
    }
}
