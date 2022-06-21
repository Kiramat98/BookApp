package com.kmitsolution.mybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    EditText inputemail,inputpassword,inputcpassword;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    TextView txtR,txt2,haveanaccount;
    FirebaseUser mUser;
    ProgressDialog progressDialog;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        inputemail=findViewById(R.id.email_field);
        txtR=findViewById(R.id.textView);
        txt2=findViewById(R.id.textView2);
        haveanaccount=findViewById(R.id.have_an_account);
        inputpassword=findViewById(R.id.password_field);
        inputcpassword=findViewById(R.id.C_password_field);
        progressDialog = new ProgressDialog(this);
        btnRegister=findViewById(R.id.buttonRegister);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        Animation alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation alpha1= AnimationUtils.loadAnimation(this,R.anim.alpha1);
        Animation alpha3= AnimationUtils.loadAnimation(this,R.anim.alpha3);
        Animation alpha4= AnimationUtils.loadAnimation(this,R.anim.alpha4);
        Animation alpha5= AnimationUtils.loadAnimation(this,R.anim.alpha5);
        Animation alpha6= AnimationUtils.loadAnimation(this,R.anim.alpha6);
        txtR.startAnimation(alpha);
        inputemail.startAnimation(alpha1);
        inputpassword.startAnimation(alpha3);
        inputcpassword.startAnimation(alpha4);
        btnRegister.startAnimation(alpha5);
        txt2.startAnimation(alpha6);
        haveanaccount.startAnimation(alpha6);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });
    }

    private  void performAuth(){
        String email=inputemail.getText().toString();
        String password=inputpassword.getText().toString();
        String cpassword=inputcpassword.getText().toString();
        if(!email.matches(emailPattern)){
            inputemail.setError("Email Incorrect");
            inputemail.setFocusable(true);
        }else if(password.length()<6 && password.isEmpty()){
            inputpassword.setError("Password is short");
        }else if(!password.equals(cpassword)){
            inputcpassword.setError("Password not match");
        }else{
            progressDialog.setMessage("please wait...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Register.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }
    private void sendUserToNextActivity(){
        Intent intent = new Intent(this,DashBoard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
//    public void Register(View view) {
//        Intent intent = new Intent(this,DashBoard.class);
//        startActivity(intent);
//        finish();
//    }
//
    public void Login(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }
}