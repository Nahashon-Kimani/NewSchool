package com.nahashon.school;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyHolder> {


    Context context;
    public HomeRecyclerAdapter(Context context){
        this.context = context;


    }


    public int getItemCount(){

        return 20;

    }

    public MyHolder onCreateViewHolder(ViewGroup parent,int type){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.home_recycler_strip,parent,false);
        return new  MyHolder(view);



    }
    public void onBindViewHolder(MyHolder viewHolder,int positon) {



    }



    class MyHolder extends RecyclerView.ViewHolder{

        public MyHolder(View view){
            super(view);



        }


    }
}
