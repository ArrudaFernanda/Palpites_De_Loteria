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

public class MegaSena extends AppCompatActivity {
    private TextView view1, view2, view3, view4, view5, view6;
    private Button btnGerar, btnCopMega;
    private SwitchCompat aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mega_sena);

        view1 = findViewById(R.id.view1_m);
        view2 = findViewById(R.id.view2_m);
        view3 = findViewById(R.id.view3_m);
        view4 = findViewById(R.id.view4_m);
        view5 = findViewById(R.id.view5_m);
        view6 = findViewById(R.id.view6_m);
        btnGerar = findViewById(R.id.btnMegGerar);
        btnCopMega = findViewById(R.id.btnCopMega);
        aSwitch = findViewById(R.id.switchMegaSena);

        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sorteios sorteios = new Sorteios(getApplicationContext());

                TextView[] viewList = {view1, view2, view3, view4, view5, view6};
                TextView[] viewList2 = {view3, view4, view5, view6};

                sorteios.sorteioMega(viewList, viewList2, aSwitch, view1, view2);

                btnCopMega.setVisibility(View.VISIBLE);
            }
        });

        btnCopMega.setOnClickListener(new View.OnClickListener() {
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