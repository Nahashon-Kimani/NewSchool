package com.nahashon.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AskTeacher extends AppCompatActivity {
     RecyclerView recyclerView;
     ImageView sendQuiz;
     EditText questionEditText;
     String question;
     Date date;
     FirebaseDatabase database;
     DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_teacher);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("Questions");

        recyclerView = findViewById(R.id.askTeacher);
        sendQuiz = findViewById(R.id.send_quiz);
        questionEditText = findViewById(R.id.question_edit_text);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new AskTeacherRecyclerAdapter(this));

//        question = questionEditText.getText().toString().trim();
//        date = Calendar.getInstance().getTime();

        sendQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });
    }

    public void send(){
        question = questionEditText.getText().toString().trim();
        if(!question.isEmpty()&&!question.equals("")) {
            date = Calendar.getInstance().getTime();
            SendQuestion sendQuestion = new SendQuestion(question, date.toString());
            String key = reference.push().getKey();

            reference.child(key).setValue(sendQuestion);
            questionEditText.setText("");
        }else{
            Toast.makeText(this,"Please input your Question",Toast.LENGTH_LONG).show();
        }




    }
}
