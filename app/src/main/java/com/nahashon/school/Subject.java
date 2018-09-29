package com.nahashon.school;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class Subject extends AppCompatActivity {
    TabLayout subjectTablaout;
    ViewPager subjectViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        subjectTablaout = findViewById(R.id.subjectTab);
        subjectViewPager = findViewById(R.id.subjectViewPager);

        subjectTablaout.setupWithViewPager(subjectViewPager);

        FragmentManager manager = getSupportFragmentManager();

        ViewPagerHolder subject = new ViewPagerHolder(this,manager);

        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");
        subject.addProperties(new SubjectFragment(),"Maths");



        subjectViewPager.setAdapter(subject);


    }





}
