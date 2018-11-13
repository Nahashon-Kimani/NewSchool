package com.nahashon.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ObjectivesActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectives);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Level").child(getIntent()
                .getStringExtra("Level")).child(getIntent().
                getStringExtra("Subject")).child(getIntent().getStringExtra("Topic"));

        Log.e("Whaaat",getIntent().getStringExtra("Level") );
        Log.e("Whaaat",getIntent().getStringExtra("Subject") );
        Log.e("Whaaat",getIntent().getStringExtra("Topic") );
        description = findViewById(R.id.objectives);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    if(dataSnapshot1.getKey().equals("topic_desc")){
                        Toast.makeText(getApplicationContext(),dataSnapshot1.getValue().toString(), Toast.LENGTH_LONG).show();
                        description.setText(dataSnapshot1.getValue().toString());
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });






    }
}
