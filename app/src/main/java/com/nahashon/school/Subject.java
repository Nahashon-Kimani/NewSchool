package com.nahashon.school;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

public class Subject extends AppCompatActivity {
    TabLayout subjectTablaout;
    ViewPager subjectViewPager;
    ViewPagerHolder subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        subjectTablaout = findViewById(R.id.subjectTab);
        subjectViewPager = findViewById(R.id.subjectViewPager);

        subjectTablaout.setupWithViewPager(subjectViewPager);

        FragmentManager manager = getSupportFragmentManager();

        subject = new ViewPagerHolder(this,manager);

        int level = getIntent().getIntExtra("position",0);
     String[] levelArray = getResources().getStringArray(R.array.level);




        switch (level){

                case 0:

                    setFragment(getResources().getStringArray(R.array.hiv_drug_awareness),"Hiv/DrugAbuse");
                    subjectTablaout.getTabAt(0).setIcon(R.drawable.aids);
                    subjectTablaout.getTabAt(1).setIcon(R.drawable.drug);



                break;
                case 1:

                    setFragment(getResources().getStringArray(R.array.literacy_level),"Literacy");
                    subjectTablaout.getTabAt(0).setIcon(R.drawable.english);
                    subjectTablaout.getTabAt(1).setIcon(R.drawable.kiswahili);
                    subjectTablaout.getTabAt(2).setIcon(R.drawable.math);

                break ;

                case 2:
                    setFragment(getResources().getStringArray(R.array.primary_level),"Primary");
                    subjectTablaout.getTabAt(0).setIcon(R.drawable.english);
                    subjectTablaout.getTabAt(1).setIcon(R.drawable.kiswahili);
                    subjectTablaout.getTabAt(2).setIcon(R.drawable.math);
                    subjectTablaout.getTabAt(3).setIcon(R.drawable.pc_maintainace);
                    subjectTablaout.getTabAt(4).setIcon(R.drawable.geography);
                    subjectTablaout.getTabAt(5).setIcon(R.drawable.religion);

                break;

                case 3:
                    setFragment(getResources().getStringArray(R.array.secondary_level),"Secondary");
                    subjectTablaout.getTabAt(0).setIcon(R.drawable.english);
                    subjectTablaout.getTabAt(1).setIcon(R.drawable.kiswahili);
                    subjectTablaout.getTabAt(2).setIcon(R.drawable.math);
                    subjectTablaout.getTabAt(3).setIcon(R.drawable.biology);
                    subjectTablaout.getTabAt(4).setIcon(R.drawable.physics);
                    subjectTablaout.getTabAt(5).setIcon(R.drawable.physics);
                    subjectTablaout.getTabAt(6).setIcon(R.drawable.history);
                    subjectTablaout.getTabAt(7).setIcon(R.drawable.geography);
                    subjectTablaout.getTabAt(8).setIcon(R.drawable.religion);
                    subjectTablaout.getTabAt(9).setIcon(R.drawable.bussines);
                    subjectTablaout.getTabAt(10).setIcon(R.drawable.word);

                break;
                case 4:
                    setFragment(getResources().getStringArray(R.array.computer_studies),"Computer");
                    subjectTablaout.getTabAt(0).setIcon(R.drawable.introduction_to_computing);
                    subjectTablaout.getTabAt(1).setIcon(R.drawable.introduction_to_computing);
                    subjectTablaout.getTabAt(2).setIcon(R.drawable.word);
                    subjectTablaout.getTabAt(3).setIcon(R.drawable.excel);
                    subjectTablaout.getTabAt(4).setIcon(R.drawable.access);
                    subjectTablaout.getTabAt(5).setIcon(R.drawable.access);
                    subjectTablaout.getTabAt(6).setIcon(R.drawable.publisher);
                    subjectTablaout.getTabAt(7).setIcon(R.drawable.internet);
                    subjectTablaout.getTabAt(8).setIcon(R.drawable.pc_maintainace);

                break;
                case 5:
                    setFragment(getResources().getStringArray(R.array.computer_studies),"Computer");

                break;

                default:
                    setFragment(getResources().getStringArray(R.array.hiv_drug_awareness),"Hiv/Drugs");

                break;




        }







//
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");
//        subject.addProperties(new SubjectFragment(),"Maths");






    }

    public void setFragment(String[] array,String level){
        Bundle bundle;

        for(int i=0;i<=(array.length-1);i++){


            SubjectFragment fragment = new SubjectFragment();
            subject.addProperties(fragment,array[i],level);




        }

        subjectViewPager.setAdapter(subject);


    }





}
