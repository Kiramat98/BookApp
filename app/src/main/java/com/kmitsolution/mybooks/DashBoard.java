package com.kmitsolution.mybooks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity {

    CardView cv1,cv2,cv3,cv4,cv5,cv6,cv7,cv8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        cv1=findViewById(R.id.cardView1);
        cv2=findViewById(R.id.cardView2);
        cv3=findViewById(R.id.cardView3);
        cv4=findViewById(R.id.cardView4);
        cv5=findViewById(R.id.cardView5);
        cv6=findViewById(R.id.cardView6);
        cv7=findViewById(R.id.cardView7);
        cv8=findViewById(R.id.cardView8);
        Animation alpha= AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation alpha1= AnimationUtils.loadAnimation(this,R.anim.alpha1);
        Animation alpha3= AnimationUtils.loadAnimation(this,R.anim.alpha3);
        Animation alpha4= AnimationUtils.loadAnimation(this,R.anim.alpha4);
        Animation alpha5= AnimationUtils.loadAnimation(this,R.anim.alpha5);
        Animation alpha6= AnimationUtils.loadAnimation(this,R.anim.alpha6);
        Animation alpha7= AnimationUtils.loadAnimation(this,R.anim.alpha7);
        Animation alpha8= AnimationUtils.loadAnimation(this,R.anim.alpha7);
        cv1.startAnimation(alpha);
        cv2.startAnimation(alpha1);
        cv3.startAnimation(alpha3);
        cv4.startAnimation(alpha4);
        cv5.startAnimation(alpha5);
        cv6.startAnimation(alpha6);
        cv7.startAnimation(alpha7);
        cv8.startAnimation(alpha8);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PDF.class);
                startActivity(intent);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book2.class);
                startActivity(intent);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book3.class);
                startActivity(intent);
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book4.class);
                startActivity(intent);
            }
        });
        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book5.class);
                startActivity(intent);
            }
        });
        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book6.class);
                startActivity(intent);
            }
        });
        cv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book7.class);
                startActivity(intent);
            }
        });
        cv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Book8.class);
                startActivity(intent);
            }
        });
    }
}