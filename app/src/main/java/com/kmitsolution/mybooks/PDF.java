package com.kmitsolution.mybooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDF extends AppCompatActivity {

    PDFView myPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        myPdf=findViewById(R.id.pdfView);
        myPdf.fromAsset("flutter_tutorial.pdf").load();
    }
}