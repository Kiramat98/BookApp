package com.kmitsolution.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book2 extends AppCompatActivity {

    PDFView book2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);
        book2=findViewById(R.id.book2);
        book2.fromAsset("Computer_Science.pdf").load();
    }
}