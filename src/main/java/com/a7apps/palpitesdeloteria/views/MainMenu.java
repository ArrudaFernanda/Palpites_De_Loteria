package com.a7apps.palpitesdeloteria.views;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.a7apps.palpitesdeloteria.R;
import com.a7apps.palpitesdeloteria.network.PushNotification;

public class MainMenu extends AppCompatActivity {
    Button btnLotofacil, btnQuina, btnDupSena, btnLotomania, btnMegSena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        Intent intentBackgroundService = new Intent(this, PushNotification.class);
        startService(intentBackgroundService);

        btnLotofacil = findViewById(R.id.btnLotofacil);
        btnQuina = findViewById(R.id.btnQuina);
        btnDupSena = findViewById(R.id.btnDupSena);
        btnLotomania = findViewById(R.id.btnLotomania);
        btnMegSena = findViewById(R.id.btnMegSena);

        btnDupSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DuplaSena.class));
            }
        });
        btnLotofacil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Lotofacil.class));
            }
        });
        btnQuina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Quina.class));
            }
        });
        btnLotomania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Lotomania.class));
            }
        });

        btnMegSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MegaSena.class));
            }
        });
    }
}