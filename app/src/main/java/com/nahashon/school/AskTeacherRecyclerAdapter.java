package com.nahashon.school;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

public class AskTeacherRecyclerAdapter extends RecyclerView.Adapter<AskTeacherRecyclerAdapter.MyHolder> {

    Context context;
    public AskTeacherRecyclerAdapter(Context context){
        this.context = context;


    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ask_a_teacher_strip,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
         myHolder.l.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 myHolder.el.toggle(true);
             }
         });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class MyHolder extends RecyclerView.ViewHolder{
         ExpandableLayout el;
         LinearLayout l;
        public MyHolder(View view){
            super(view);
            el = view.findViewById(R.id.expandableListView);
            l = view.findViewById(R.id.expandable_strip);


        }

    }
}
