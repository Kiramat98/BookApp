package com.kmitsolution.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Book8 extends AppCompatActivity {
PDFView book8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book8);
        book8=findViewById(R.id.book8);
        book8.fromAsset("english_gramar.pdf").load();
    }
}