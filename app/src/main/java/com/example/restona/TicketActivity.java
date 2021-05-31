package com.example.restona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TicketActivity extends AppCompatActivity {
    Button button11;
    Button button12;
    Button button13;
    Button button14;
    Button button15;
    Button button16;
    private static int val;
    private String UserId= FirebaseAuth.getInstance().getCurrentUser().getUid();
    private TextView solde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        readval();
        button11=findViewById(R.id.button11);
        button12=findViewById(R.id.button12);
        button13=findViewById(R.id.button13);
        button14=findViewById(R.id.button14);
        button15=findViewById(R.id.button15);
        button16=findViewById(R.id.button16);
        button11.setOnClickListener(new View.OnClickListener() {
            Drawable background11=button11.getBackground();
            @Override
            public void onClick(View v) {
                if(button11.getText().equals("Monday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button11.setText("Monday reserved !");
                    button11.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Monday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }

            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            Drawable background12=button12.getBackground();
            @Override
            public void onClick(View v) {
                if(button12.getText().equals("Tuesday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button12.setText("Tuesday reserved !");
                    button12.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Tuesday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }

            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            Drawable background13=button13.getBackground();
            @Override
            public void onClick(View v) {
                if(button13.getText().equals("Wednesday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button13.setText("Wednesday reserved !");
                    button13.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Wednesday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }

            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            Drawable background14=button14.getBackground();
            @Override
            public void onClick(View v) {
                if(button14.getText().equals("Thursday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button14.setText("Thursday reserved !");
                    button14.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Thursday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            Drawable background15=button15.getBackground();
            @Override
            public void onClick(View v) {
                if(button15.getText().equals("Friday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button15.setText("Friday reserved !");
                    button15.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Friday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            Drawable background16=button16.getBackground();
            @Override
            public void onClick(View v) {
                if(button16.getText().equals("Saturday") && val>=2 )
                {   DatabaseReference refreserve= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refreserve.setValue(val-2);
                    button16.setText("Saturday reserved !");
                    button16.setBackgroundResource(R.color.teal_700);
                    Toast.makeText(TicketActivity.this,"You have reserved for Saturday -2 coins !",Toast.LENGTH_SHORT).show();
                }
                else if(val<=1)
                {
                    Toast.makeText(TicketActivity.this,"Cant reserve you need 2 restona coins !",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TicketActivity.this,"You have already reserved !",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void readval()
    {
        DatabaseReference refuser= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");

        refuser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                val= snapshot.getValue(Integer.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });
    }
}