package com.example.restona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText emailEt,passwordEt;
    int a=Integer.parseInt("10");
    private Button SignInButtom;
    private TextView SignUpTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth= FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.email1);
        passwordEt=findViewById(R.id.password);
        SignInButtom=findViewById(R.id.login);
        progressDialog=new ProgressDialog(this);
        SignUpTv=findViewById(R.id.signUpTv);
        SignInButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpactivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void Login()
    {
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            emailEt.setError("Enter your email");
            return;
        }
        else if(TextUtils.isEmpty(password))
        {
            passwordEt.setError("Enter your password");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {


                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(MainActivity.this, "Sign In fail !", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

}
