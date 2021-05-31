package com.example.restona;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpactivity extends AppCompatActivity {
    FirebaseDatabase databi=FirebaseDatabase.getInstance();
    DatabaseReference databrefi;
    private EditText emailEt,passwordEt1,passwordEt2;
    private Button SignUpButtom;
    private TextView SignInTv;
    //private FirebaseUser user;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private String UserId= FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        firebaseAuth= FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.email1);
        passwordEt1=findViewById(R.id.password1);
        passwordEt2=findViewById(R.id.password2);
        SignUpButtom=findViewById(R.id.register);
        progressDialog=new ProgressDialog(this);
        SignInTv=findViewById(R.id.signInTv);
        SignUpButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Register();
            }
        });
        SignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void Register(){
        String email=emailEt.getText().toString();
        String password1=passwordEt1.getText().toString();
        String password2=passwordEt2.getText().toString();
        if(TextUtils.isEmpty(email))
        {
            emailEt.setError("Enter your email");
            return;
        }
        else if(TextUtils.isEmpty(password1))
        {
            passwordEt1.setError("Enter your password");
            return;
        }
        else if(TextUtils.isEmpty(password2))
        {
            passwordEt2.setError("Confirm your password");
            return;
        }
        else if(!password1.equals(password2))
        {
            passwordEt2.setError("Different passwords");
            return;
        }
        else if(password1.length()<4)
        {
            passwordEt1.setError("Length should be >= 4");
            return;
        }
        else if(!isVallidEmail(email)) {
            emailEt.setError("Invalid Email");
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(SignUpactivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                    CreatUser();
                    Intent intent=new Intent(SignUpactivity.this,DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUpactivity.this, "Sign Up fail !", Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }
    private Boolean isVallidEmail(CharSequence target){
         return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    public void CreatUser()
    {
       FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String UserID=user.getUid();
        String mail=user.getEmail();
        databrefi= databi.getReference("Users");
        users layi = new users(UserID,mail,0);
        databrefi.child(UserID).setValue(layi);
    }

}
