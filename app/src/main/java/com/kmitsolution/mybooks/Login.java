package com.kmitsolution.mybooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

public class Login extends AppCompatActivity {
    EditText inputemail,inputpassword;
    TextView login,textView2,haveanaccount;
    Button btnLogin;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        inputemail=findViewById(R.id.email_field);
        textView2=findViewById(R.id.textView2);
        haveanaccount=findViewById(R.id.have_an_account);
        login=findViewById(R.id.textView);
        inputpassword=findViewById(R.id.password_field);
        btnLogin=findViewById(R.id.buttonLogin);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        progressDialog=new ProgressDialog(this);
        Animation alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation alpha1= AnimationUtils.loadAnimation(this,R.anim.alpha1);
        Animation alpha3= AnimationUtils.loadAnimation(this,R.anim.alpha3);
        Animation alpha4= AnimationUtils.loadAnimation(this,R.anim.alpha4);
        Animation alpha5= AnimationUtils.loadAnimation(this,R.anim.alpha5);
        login.startAnimation(alpha1);
        inputemail.startAnimation(alpha);
        inputpassword.startAnimation(alpha3);
        btnLogin.startAnimation(alpha4);
        textView2.startAnimation(alpha5);
        haveanaccount.startAnimation(alpha5);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });
    }

    private void performAuth(){
        String email=inputemail.getText().toString();
        String password=inputpassword.getText().toString();
        if(!email.matches(emailPattern)){
            inputemail.setError("Email Incorrect");
            inputemail.setFocusable(true);
        }else if(password.length()<6 && password.isEmpty()){
            inputpassword.setError("Password is short");
        }else{
            progressDialog.setMessage("please wait...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Login.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
    public void Register(View view) {
        Intent intent=new Intent(this,Register.class);
        startActivity(intent);
        finish();
    }

//    public void Login(View view) {
//        Intent intent = new Intent(this,DashBoard.class);
//        startActivity(intent);
//        finish();
//    }
}