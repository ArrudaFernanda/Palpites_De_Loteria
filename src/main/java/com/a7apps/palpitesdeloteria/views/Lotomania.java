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
import com.a7apps.palpitesdeloteria.R;
import com.a7apps.palpitesdeloteria.control.Sorteios;

import java.util.ArrayList;

public class Lotomania extends AppCompatActivity {
    private TextView view1, view2, view3, view4, view5, view6, view7, view8, view9, view10, view11, view12, view13, view14, view15,
            view16, view17, view18, view19, view20, view21, view22, view23, view24, view25, view26, view27, view28, view29, view30,
            view31, view32, view33, view34, view35, view36, view37, view38, view39, view40, view41, view42, view43, view44,
            view45, view46, view47, view48, view49, view50;
    private Button btnGerar, btnCopLotom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotomania);

        view1 = findViewById(R.id.view1_lm);
        view2 = findViewById(R.id.view2_lm);
        view3 = findViewById(R.id.view3_lm);
        view4 = findViewById(R.id.view4_lm);
        view5 = findViewById(R.id.view5_lm);
        view6 = findViewById(R.id.view6_lm);
        view7 = findViewById(R.id.view7_lm);
        view8 = findViewById(R.id.view8_lm);
        view9 = findViewById(R.id.view9_lm);
        view10 = findViewById(R.id.view10_lm);
        view11 = findViewById(R.id.view11_lm);
        view12 = findViewById(R.id.view12_lm);
        view13 = findViewById(R.id.view13_lm);
        view14 = findViewById(R.id.view14_lm);
        view15 = findViewById(R.id.view15_lm);
        view16 = findViewById(R.id.view16_lm);
        view17 = findViewById(R.id.view17_lm);
        view18 = findViewById(R.id.view18_lm);
        view19 = findViewById(R.id.view19_lm);
        view20 = findViewById(R.id.view20_lm);
        view21 = findViewById(R.id.view21_lm);
        view22 = findViewById(R.id.view22_lm);
        view23 = findViewById(R.id.view23_lm);
        view24 = findViewById(R.id.view24_lm);
        view25 = findViewById(R.id.view25_lm);
        view26 = findViewById(R.id.view26_lm);
        view27 = findViewById(R.id.view27_lm);
        view28 = findViewById(R.id.view28_lm);
        view29 = findViewById(R.id.view29_lm);
        view30 = findViewById(R.id.view30_lm);
        view31 = findViewById(R.id.view31_lm);
        view32 = findViewById(R.id.view32_lm);
        view33 = findViewById(R.id.view33_lm);
        view34 = findViewById(R.id.view34_lm);
        view35 = findViewById(R.id.view35_lm);
        view36 = findViewById(R.id.view36_lm);
        view37 = findViewById(R.id.view37_lm);
        view38 = findViewById(R.id.view38_lm);
        view39 = findViewById(R.id.view39_lm);
        view40 = findViewById(R.id.view40_lm);
        view41 = findViewById(R.id.view41_lm);
        view42 = findViewById(R.id.view42_lm);
        view43 = findViewById(R.id.view43_lm);
        view44 = findViewById(R.id.view44_lm);
        view45 = findViewById(R.id.view45_lm);
        view46 = findViewById(R.id.view46_lm);
        view47 = findViewById(R.id.view47_lm);
        view48 = findViewById(R.id.view48_lm);
        view49 = findViewById(R.id.view49_lm);
        view50 = findViewById(R.id.view50_lm);
        btnGerar = findViewById(R.id.btnLMGerar);
        btnCopLotom = findViewById(R.id.btnCopLotom);

        final TextView[] viewList = {
                view1, view2, view3, view4, view5, view6,
                view7, view8, view9, view10, view11, view12,
                view13, view14, view15, view16, view17, view18,
                view19, view20, view21, view22, view23, view24,
                view25, view26, view27, view28, view29, view30,
                view31, view32, view33, view34, view35, view36,
                view37, view38, view39, view40, view41, view42,
                view43, view44, view45, view46, view47, view48,
                view49, view50
        };

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sorteios sorteios = new Sorteios(getApplicationContext());

                sorteios.sorteioLotomania(viewList);

                btnCopLotom.setVisibility(View.VISIBLE);
            }
        });

        btnCopLotom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> numbersArray = new ArrayList<>();

                for (int i = 0; i < 50; i++){
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