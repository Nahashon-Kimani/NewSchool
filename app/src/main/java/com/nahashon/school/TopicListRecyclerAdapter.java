package com.nahashon.school;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class TopicListRecyclerAdapter extends RecyclerView.Adapter<TopicListRecyclerAdapter.MyHolder> {

Context context;
    public TopicListRecyclerAdapter(Context context){
        this.context = context;


    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.topic_list,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.textView.setText(Integer.toString(i+1));


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyHolder extends RecyclerView.ViewHolder{
            TextView textView;
        public MyHolder(View view){
            super(view);
            textView = view.findViewById(R.id.topicTextView);
        }
    }
}
