package com.reisswolf.potpisaplikacija;

import android.content.Intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SignatureView signatureView;
    private Button clearButton, saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Povezivanje sa layout elementima
        signatureView = findViewById(R.id.signatureView);
        clearButton = findViewById(R.id.clearButton);
        saveButton = findViewById(R.id.saveButton);

        // Clear button - briše potpis
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clear();  // Metoda koju treba dodati u SignatureView
            }
        });

        // Save button - sačuvaj potpis
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap signatureBitmap = signatureView.getSignature();
                if (signatureBitmap != null) {
                    // Ovdje možete sačuvati potpis, poslati ga putem email-a ili nešto drugo
                    // Na primer, šaljemo ga u novi Intent kao sliku:
                    Intent intent = new Intent(MainActivity.this, SaveActivity.class);
                    intent.putExtra("signatureBitmap", signatureBitmap);
                    startActivity(intent);
                }
            }
        });
    }
}
