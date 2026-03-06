package com.example.projekttimery;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
    boolean czyZlicza = false;

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
                        if (czyZlicza) {
                            ileSekund++;
                            textViewCzas.setText("" + ileSekund);
                        }
                        handler.postDelayed(this, 1000);
                        //Argumentem jest ta funkcja, a drugi ile milisekund.
                        //ta funkcja liczy sekundy od zalaczenia aplikacji
                        // jest niezależna od przyciskow(dziala sama
                    }
                }
        );

        buttonstart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        czyZlicza = true;
                        textViewCzas.setText(zrobLadnyCzas(ileSekund));
                        //ta funkcja zmienna wartosc czy zlicza na true
                        // i dziala tak, zeby jak uzytkownik nacisnie start
                        //to czas zaczyna sie odliczac
                    }
                }
        );

        buttonstop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        czyZlicza = false;

                    }
                }
        );
        buttonreset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ileSekund = 0;
                        textViewCzas.setText(zrobLadnyCzas(ileSekund));
                    }
                }
        );


    }
    private String zrobLadnyCzas(int ileSekund) {
        int sekundy = ileSekund%60;
        int minuty = (ileSekund/60)%60;
        int godziny = ileSekund/3600;
        //return godziny +":"+minuty+":"+ sekundy;
        return String.format("%02d:%02d:%02d", godziny, minuty, sekundy);

    }

}