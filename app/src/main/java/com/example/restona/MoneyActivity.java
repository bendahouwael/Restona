package com.example.restona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.storage.StorageTask;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.valueOf;

public class MoneyActivity extends AppCompatActivity implements View.OnClickListener {
    Button scan;
    String mysecretcode;
    private TextView solde;
    static int v;
    private String UserId= FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        v=getIntent().getExtras().getInt("val");
        scan=findViewById(R.id.scaan);
        solde=findViewById(R.id.solde);
        solde.setText(""+v);
        scan.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        scaningcode();
    }
    private void scaningcode()
    {   DatabaseReference refcode= FirebaseDatabase.getInstance().getReference("secret code");
        refcode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mysecretcode= snapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        IntentIntegrator integrator =new IntentIntegrator(this);
        integrator.setCaptureActivity(captureme.class);
        integrator.setOrientationLocked(false);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        integrator.setPrompt("Scanning the code ..");
        integrator.initiateScan();

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if(result.getContents()!=null){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final String s=result.getContents();

                //final String secret=mysecretcode;
                //Log.d("testing qr my se",mysecretcode);
                //Log.d("testing qr se",secret);
                if(s.equals(mysecretcode))
                { builder.setMessage("+10 Restona coins earned !");
                    DatabaseReference refuser= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                    refuser.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                             v= snapshot.getValue(Integer.class);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(MoneyActivity.this,"Erreur",Toast.LENGTH_SHORT).show();

                        }
                    });






                  }
                else
                { builder.setMessage("Wrong QR code try again");}
                builder.setPositiveButton("Scan again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        scaningcode();
                    }
                }).setNegativeButton("finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DatabaseReference refuser= FirebaseDatabase.getInstance().getReference("Users").child(UserId).child("solde");
                        refuser.setValue(v+10);
                        finish();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
            else {
                Toast.makeText(this, "No result", Toast.LENGTH_LONG).show();
            }

            }
        else {
            super.onActivityResult(requestCode,resultCode,data);
        }
        }
    }

