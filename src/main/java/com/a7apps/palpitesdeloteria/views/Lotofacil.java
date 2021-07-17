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

import java.util.ArrayList;

public class Lotofacil extends AppCompatActivity {
    private TextView view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11,
            view12, view13, view14, view15;
    private Button btnGerar, btnCopLotof;
    private SwitchCompat switchComp;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotofacil);

        adView = findViewById(R.id.adViewLotofacil);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        view1 = findViewById(R.id.view1_l);
        view2 = findViewById(R.id.view2_l);
        view3 = findViewById(R.id.view3_l);
        view4 = findViewById(R.id.view4_l);
        view5 = findViewById(R.id.view5_l);
        view6 = findViewById(R.id.view6_l);
        view7 = findViewById(R.id.view7_l);
        view8 = findViewById(R.id.view8_l);
        view9 = findViewById(R.id.view9_l);
        view10 = findViewById(R.id.view10_l);
        view11 = findViewById(R.id.view11_l);
        view12 = findViewById(R.id.view12_l);
        view13 = findViewById(R.id.view13_l);
        view14 = findViewById(R.id.view14_l);
        view15 = findViewById(R.id.view15_l);
        btnGerar = findViewById(R.id.btnLotofGerar);
        btnCopLotof = findViewById(R.id.btnCopLotof);
        switchComp = findViewById(R.id.switchLotofacil);

        final TextView[] viewList = {view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,view11,view12,view13,view14,view15};

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sorteios sorteios = new Sorteios(getApplicationContext());

                TextView[] viewList2 = {view5,view6,view7,view8,view9,view10,view11,view12,view13,view14,view15};

                sorteios.sorteioLotofacil(viewList, viewList2, switchComp, view1, view2, view3, view4);

                btnCopLotof.setVisibility(View.VISIBLE);
            }
        });

        btnCopLotof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> numbersArray = new ArrayList<>();

                for(int i = 0; i < 15; i++){
                    String numbers = viewList[i].getText().toString();
                    numbersArray.add(numbers);
                }

                String copy = numbersArray.toString().replace("[", "").replace(",", "");

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copiado!", copy.replace("]", ""));
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(getApplicationContext(), "Copiado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}