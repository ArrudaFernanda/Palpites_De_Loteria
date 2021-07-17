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

public class Quina extends AppCompatActivity {
    private TextView view1, view2, view3, view4, view5;
    private Button btnQuinaGerar, btnCopQuina;
    private SwitchCompat aSwitch;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quina);

        adView = findViewById(R.id.adViewQuina);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        view1 = findViewById(R.id.view1_q);
        view2 = findViewById(R.id.view2_q);
        view3 = findViewById(R.id.view3_q);
        view4 = findViewById(R.id.view4_q);
        view5 = findViewById(R.id.view5_q);
        btnQuinaGerar = findViewById(R.id.btnQuinGerar);
        btnCopQuina = findViewById(R.id.btnCopQuina);
        aSwitch = findViewById(R.id.switchQuina);

        btnQuinaGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sorteios sorteios = new Sorteios(getApplicationContext());

                TextView[] viewList = {view1, view2, view3, view4, view5};
                TextView[] viewList2 = {view2, view3, view4, view5};

                sorteios.sorteioQuina(viewList, viewList2, aSwitch, view1);

                btnCopQuina.setVisibility(View.VISIBLE);
            }
        });

        btnCopQuina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = view1.getText().toString();
                String p2 = view2.getText().toString();
                String p3 = view3.getText().toString();
                String p4 = view4.getText().toString();
                String p5 = view5.getText().toString();

                String copy = p1+" "+p2+" "+p3+" "+p4+" "+p5;

                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Copiado!", copy);
                clipboardManager.setPrimaryClip(clipData);

                Toast.makeText(getApplicationContext(), "Copiado!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}