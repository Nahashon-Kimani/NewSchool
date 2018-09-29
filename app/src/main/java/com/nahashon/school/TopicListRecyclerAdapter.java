package com.nahashon.school;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class TopicListRecyclerAdapter extends RecyclerView.Adapter<TopicListRecyclerAdapter.MyHolder>{

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
        myHolder.topicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,NoteViewer.class));
            }
        });
        final PopupMenu popupMenu = new PopupMenu(context,myHolder.menuOpener);

        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.objectives:
                        Toast.makeText(context, "Objectives", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });

        myHolder.menuOpener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();

            }
        });







    }

    @Override
    public int getItemCount() {
        return 20;
    }


    class MyHolder extends RecyclerView.ViewHolder{
            TextView textView;
            LinearLayout topicView;
            ImageView menuOpener;
        public MyHolder(View view){
            super(view);
            textView = view.findViewById(R.id.topicTextView);
            topicView= view.findViewById(R.id.topicView);
            menuOpener=view.findViewById(R.id.menu_opener);


        }
    }
}
