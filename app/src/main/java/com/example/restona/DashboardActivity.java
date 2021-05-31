package com.example.restona;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DashboardActivity extends Activity implements View.OnClickListener {
    private Button logout;
    private CardView Money,Stars,Ticket,Food;
    private EditText emaili;
    private TextView moniya;
    long maxin=0;
    private static int val;
    private String UserId= FirebaseAuth.getInstance().getCurrentUser().getUid();
    FirebaseDatabase databi=FirebaseDatabase.getInstance();
    DatabaseReference databrefi;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        initvalue();
        logout = findViewById(R.id.logout);
        emaili=findViewById(R.id.email1);
        moniya=findViewById(R.id.solde);
        Money = (CardView) findViewById(R.id.money);
        Stars = (CardView) findViewById(R.id.stars);
        Ticket = (CardView) findViewById(R.id.ticket);
        Food = (CardView) findViewById(R.id.food);
        Money.setOnClickListener(this);
        Stars.setOnClickListener(this);
        Ticket.setOnClickListener(this);
        Food.setOnClickListener(this);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        //moniying();
    }

    @Override
    public void onClick(View v) {
        //moniying();
        Intent inti;
        switch(v.getId()){
            case R.id.money : inti = new Intent(this,MoneyActivity.class).putExtra("val",val);startActivity(inti);break;
            case R.id.stars : inti = new Intent(this,StarsActivity.class);startActivity(inti);break;
            case R.id.ticket : inti = new Intent(this,TicketActivity.class);startActivity(inti);break;
            case R.id.food : inti = new Intent(this,FoodActivity.class);startActivity(inti);break;
            default:break;
        }
    }
    public void initvalue()
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