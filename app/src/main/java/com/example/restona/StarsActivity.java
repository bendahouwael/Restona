package com.example.restona;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.params.RecommendedStreamConfigurationMap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StarsActivity extends AppCompatActivity {
    EditText Comments;
    Button Sends;
    String sta="0 star : Very Dissatisfied ";
    FirebaseDatabase datab=FirebaseDatabase.getInstance();
    DatabaseReference databref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView Feedback;
        RatingBar Stars;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);
        Feedback = findViewById(R.id.Feedback);

        Stars = findViewById(R.id.Stars);
        Comments=findViewById(R.id.Comment);
        Sends=findViewById(R.id.Send);
        databref =datab.getReference("Feedbacks");
        Sends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendingdata();
            }
        });
        Stars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating==0 || rating==0.5)
                {
                    Feedback.setText("Very Dissatisfied");
                    if(rating==0.5) {
                        sta="0,5 star : Very Dissatisfied ";
                    }

                }
                else if(rating==1 || rating==1.5 )
                {
                    Feedback.setText("Dissatisfied");
                    if(rating==1.5) {
                        sta="1,5 star : Dissatisfied ";
                    }
                    else
                    {
                        sta="1 star : Dissatisfied ";
                    }
                }
                else if(rating==2 || rating==2.5)
                {
                    Feedback.setText("OK");
                    if(rating==2) {
                        sta="2 stars : OK ";
                    }
                    else
                    {
                        sta="2.5 stars : OK ";
                    }
                }
                else if(rating==3 || rating==3.5)
                {
                    Feedback.setText("Good");
                    if(rating==3) {
                        sta="3 stars : Good ";
                    }
                    else
                    {
                        sta="3.5 stars : Good ";
                    }
                }
                else if(rating==4 || rating==4.5 )
                {
                    Feedback.setText("Satisfied");
                    if(rating==4) {
                        sta="4 stars : Satisfied ";
                    }
                    else
                    {
                        sta="4.5 stars : Satisfied ";
                    }
                }
                else
                {
                    Feedback.setText("Very Satisfied");
                    sta="5 stars : Very Satisfied ";
                }

            }
        });

    }
    public void sendingdata()
    {
        String CommentsText = Comments.getText().toString();
        String id =databref.push().getKey();
        if(!TextUtils.isEmpty(CommentsText)){
            dati hey = new dati(CommentsText,sta);
           databref.child(id).setValue(hey);
           Toast.makeText(this,"Feedback is send to Chef , thanks",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Please write your feedback !",Toast.LENGTH_SHORT).show();
        }
    }

}