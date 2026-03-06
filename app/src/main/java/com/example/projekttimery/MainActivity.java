package com.example.projekttimery;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textViewCzas;
    Button buttonstart, buttonstop, buttonreset, buttonzapisz;
    int ileSekund = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textViewCzas = findViewById(R.id.textView);
        buttonstart = findViewById(R.id.button);
        buttonstop = findViewById(R.id.button2);
        buttonreset = findViewById(R.id.button3);
        buttonzapisz = findViewById(R.id.button4);

        Handler handler = new Handler();
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        ileSekund++;
                        textViewCzas.setText(""+ileSekund);
                        handler.postDelayed(this, 1000);
                    }
                }
        );

    }
}