package com.a7apps.palpitesdeloteria.views;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.SwitchCompat;
import com.a7apps.palpitesdeloteria.R;
import com.a7apps.palpitesdeloteria.control.Sorteios;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DuplaSena extends AppCompatActivity {
    private TextView view1, view2, view3, view4, view5, view6;
    private Button btnGerar, btnCopDupSena;
    private SwitchCompat aSwitch;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dupla_sena);

        adView = findViewById(R.id.adViewDuplaSena);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        view1 = findViewById(R.id.view1_d);
        view2 = findViewById(R.id.view2_d);
        view3 = findViewById(R.id.view3_d);
        view4 = findViewById(R.id.view4_d);
        view5 = findViewById(R.id.view5_d);
        view6 = findViewById(R.id.view6_d);
        btnGerar = findViewById(R.id.btnDupGerar);
        btnCopDupSena = findViewById(R.id.btnCopDupSena);
        aSwitch = findViewById(R.id.switchDuplasena);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sorteios sorteios = new Sorteios(getApplicationContext());

                TextView[] viewList = {view1, view2, view3, view4, view5, view6};
                TextView[] viewList2 = {view3, view4, view5, view6};

                sorteios.sorteioDuplaSena(viewList, viewList2, aSwitch, view1, view2);

                btnCopDupSena.setVisibility(View.VISIBLE);
            }
        });

        btnCopDupSena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = view1.getText().toString();
                String p2 = view2.getText().toString();
                String p3 = view3.getText().toString();
                String p4 = view4.getText().toString();
                String p5 = view5.getText().toString();
                String p6 = view6.getText().toString();

                String copy = p1+" "+p2+" "+p3+" "+p4+" "+p5+" "+p6;

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copiado!", copy);
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(getApplicationContext(), "Copiado!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}