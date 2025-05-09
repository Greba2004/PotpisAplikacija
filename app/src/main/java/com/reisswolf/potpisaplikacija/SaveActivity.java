package com.reisswolf.potpisaplikacija;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        // Pronađi ImageView u layout-u
        ImageView signatureImageView = findViewById(R.id.signatureImageView);

        // Preuzmi Bitmap iz Intent-a
        Bitmap signatureBitmap = getIntent().getParcelableExtra("signatureBitmap");

        // Ako je Bitmap postoji, postavi ga na ImageView
        if (signatureBitmap != null) {
            signatureImageView.setImageBitmap(signatureBitmap);
        }
    }
}
