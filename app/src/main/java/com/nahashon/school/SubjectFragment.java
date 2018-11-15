package com.nahashon.school;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SubjectFragment extends Fragment {
RecyclerView recyclerView;
List<Topic> list = new ArrayList<>();
DatabaseReference databaseReference;

    public SubjectFragment() {

    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject, container, false);

        final Bundle bundle = getArguments();



        recyclerView = view.findViewById(R.id.topicRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        databaseReference= FirebaseDatabase.getInstance().getReference("Level").child(bundle.getString("Level")).child(bundle.getString("Subject"));


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                   Topic topic = snapshot.getValue(Topic.class);
                   list.add(topic);




                }
               TopicListRecyclerAdapter adapter = new TopicListRecyclerAdapter(getContext(),
                       list,bundle.getString("Level"),bundle.getString("Subject"));

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
















        return view;
    }

}
