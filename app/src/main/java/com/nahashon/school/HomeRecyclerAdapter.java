package com.nahashon.school;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyHolder> {



    String[] levelArray;
    String[] levelDescription;


    Context context;
    public HomeRecyclerAdapter(Context context){
        this.context = context;
        levelArray = context.getResources().getStringArray(R.array.level);
        levelDescription = context.getResources().getStringArray(R.array.description);


    }


    public int getItemCount(){

        return levelArray.length;

    }

    public MyHolder onCreateViewHolder(ViewGroup parent,int type){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.home_recycler_strip,parent,false);
        return new  MyHolder(view);



    }
    public void onBindViewHolder(MyHolder viewHolder, final int positon) {
        viewHolder.levelDescription.setText(levelDescription[positon]);
        viewHolder.levelName.setText(levelArray[positon]);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Subject.class);
                intent.putExtra("position",positon);
                context.startActivity(intent);
            }
        });




    }



    class MyHolder extends RecyclerView.ViewHolder{
            CardView cardView;
            TextView levelName;
            TextView levelDescription;
            ImageView levelImageView;
        public MyHolder(View view){
            super(view);

            levelName = view.findViewById(R.id.levelName);
            levelDescription = view.findViewById(R.id.levelDescription);
            levelImageView=view.findViewById(R.id.levelImageView);

            cardView = view.findViewById(R.id.subjectStrip);




        }


    }
}
