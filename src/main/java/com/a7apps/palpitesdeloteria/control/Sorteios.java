package com.a7apps.palpitesdeloteria.control;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.a7apps.palpitesdeloteria.R;
import com.a7apps.palpitesdeloteria.data.Dados;

import java.util.ArrayList;
import java.util.Collections;

public class Sorteios {
    private Context context;
    private Dados dados;

    public Sorteios(Context context) {
        this.context = context;
        dados = new Dados(context);
    }

    public void preencheCartelas(int nBolasTotal, ArrayList<String> cartelaArray, ArrayList<String> mais7Array, String[] seteMais){
        for (int i = 0; i < nBolasTotal; i++){
            cartelaArray.add(dados.getNumbersList()[i]);
            if (i < 7){
                mais7Array.add(seteMais[i]);
            }
        }
    }

    public void sorteioDuplaSena(TextView[] txtViewList, TextView[] txtViewList2, SwitchCompat aswitch, TextView txt1, TextView txt2){
        ArrayList<String> cartelaDuplaSena = new ArrayList<>();
        ArrayList<String> mais7Array = new ArrayList<>();

        preencheCartelas(50, cartelaDuplaSena, mais7Array, dados.getMais7DuplaSena());

        Collections.shuffle(cartelaDuplaSena);
        Collections.shuffle(mais7Array);

        if (aswitch.isChecked()){

            txt1.setBackgroundResource(R.drawable.boladuplasena);
            txt2.setBackgroundResource(R.drawable.boladuplasena);
            txt1.setText(mais7Array.get(0));
            txt2.setText(mais7Array.get(1));
            //////////////////////aqui estou //////////
            RemoveAdd removeAdd = new RemoveAdd(context);
            removeAdd.remover(cartelaDuplaSena, "04", "14", "19", "33", "39",
                    "45", "47");

            for (int i = 0; i < 4; i++) {
                txtViewList2[i].setText(cartelaDuplaSena.get(i));
            }

            removeAdd.adicionar(cartelaDuplaSena,"04", "14", "19", "33", "39",
                    "45", "47");

        }else {
            txt1.setBackgroundResource(R.drawable.bola_a);
            txt2.setBackgroundResource(R.drawable.bola_b);
            for (int i = 0; i < 6; i++){
                txtViewList[i].setText(cartelaDuplaSena.get(i));
            }
        }
    }

    public void sorteioLotofacil(TextView[] txtViewList, TextView[] txtViewList2, SwitchCompat aswitch,
                                 TextView txt1, TextView txt2, TextView txt3, TextView txt4){
        ArrayList<String> cartelaLotofacil = new ArrayList<>();
        ArrayList<String> mais7Array = new ArrayList<>();

        preencheCartelas(25, cartelaLotofacil, mais7Array, dados.getMais7Lotofacil());

        Collections.shuffle(cartelaLotofacil);
        Collections.shuffle(mais7Array);

        if (aswitch.isChecked()){
            txt1.setBackgroundResource(R.drawable.bolalotofacil);
            txt2.setBackgroundResource(R.drawable.bolalotofacil);
            txt3.setBackgroundResource(R.drawable.bolalotofacil);
            txt4.setBackgroundResource(R.drawable.bolalotofacil);
            txt1.setText(mais7Array.get(0));
            txt2.setText(mais7Array.get(1));
            txt3.setText(mais7Array.get(2));
            txt4.setText(mais7Array.get(3));

            RemoveAdd removeAdd = new RemoveAdd(context);
            removeAdd.remover(cartelaLotofacil, "10", "11", "13", "14", "20", "24", "25");

            for (int i = 0; i < 11; i++){
                txtViewList2[i].setText(cartelaLotofacil.get(i));
            }

            removeAdd.adicionar(cartelaLotofacil,"10", "11", "13", "14", "20", "24", "25");

        }else {
            txt1.setBackgroundResource(R.drawable.bola_a);
            txt2.setBackgroundResource(R.drawable.bola_b);
            txt3.setBackgroundResource(R.drawable.bola_c);
            txt4.setBackgroundResource(R.drawable.bola_d);
            for (int i = 0; i < 15; i++){
                txtViewList[i].setText(cartelaLotofacil.get(i));
            }
        }
    }

    public void sorteioLotomania(TextView[] txtViewList){
        ArrayList<String> cartelaArray = new ArrayList<>();

        for (int i = 0; i < 100; i++){
            cartelaArray.add(dados.getNumbersList()[i]);
        }

        Collections.shuffle(cartelaArray);

        for (int i = 0; i < 50; i++){
            txtViewList[i].setText(cartelaArray.get(i));
        }
    }

    public void sorteioMega(TextView[] txtViewList, TextView[] txtViewList2, SwitchCompat aswitch, TextView txt1, TextView txt2){
        ArrayList<String> cartelaArray60 = new ArrayList<>();
        ArrayList<String> mais7Array = new ArrayList<>();

        preencheCartelas(60, cartelaArray60, mais7Array, dados.getMais7MegaSena());

        Collections.shuffle(cartelaArray60);
        Collections.shuffle(mais7Array);

        if (aswitch.isChecked()){
            txt1.setBackgroundResource(R.drawable.bolamegasena);
            txt2.setBackgroundResource(R.drawable.bolamegasena);
            txt1.setText(mais7Array.get(0));
            txt2.setText(mais7Array.get(1));

            RemoveAdd removeAdd = new RemoveAdd(context);
            removeAdd.remover(cartelaArray60, "04", "05", "10", "23", "33", "42", "53");

            for (int i = 0; i < 4; i++) {
                txtViewList2[i].setText(cartelaArray60.get(i));
            }

            removeAdd.adicionar(cartelaArray60, "04", "05", "10", "23", "33", "42", "53");

        }else {
            txt1.setBackgroundResource(R.drawable.bola_a);
            txt2.setBackgroundResource(R.drawable.bola_b);
            for (int i = 0; i < 6; i++){
                txtViewList[i].setText(cartelaArray60.get(i));
            }
        }
    }

    public void sorteioQuina(TextView[] txtViewList, TextView[] txtViewList2, SwitchCompat aswitch, TextView txt1){
        ArrayList<String> cartelaArray80 = new ArrayList<>();
        ArrayList<String> mais7Array = new ArrayList<>();

        preencheCartelas(80, cartelaArray80, mais7Array, dados.getMais7Quina());

        Collections.shuffle(cartelaArray80);
        Collections.shuffle(mais7Array);

        if (aswitch.isChecked()){
            txt1.setBackgroundResource(R.drawable.bolaquina);
            txt1.setText(mais7Array.get(0));

            RemoveAdd removeAdd = new RemoveAdd(context);
            removeAdd.remover(cartelaArray80, "04", "29", "31", "39", "49", "52", "53");

            for (int i = 0; i < 4; i++){
                txtViewList2[i].setText(cartelaArray80.get(i));
            }

            removeAdd.adicionar(cartelaArray80, "04", "29", "31", "39", "49", "52", "53");

        }else {
            txt1.setBackgroundResource(R.drawable.bola_c);
            for (int i = 0; i < 5; i++){
                txtViewList[i].setText(cartelaArray80.get(i));
            }
        }
    }
}
