package com.a7apps.palpitesdeloteria.data;

import android.content.Context;

public class Dados {
    private Context context;
    private final String[] numbersList = {
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
            "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
            "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
            "91", "92", "93", "94", "95", "96", "97", "98", "99", "00",
    };

    private final String[] mais7MegaSena = {
            "04", "05", "10", "23", "33", "42", "53"
    };

    private final String[] mais7DuplaSena = {
            "04", "14", "19", "33", "39", "45", "47"
    };

    private final String[] mais7Lotofacil = {
            "10", "11", "13", "14", "20", "24", "25"
    };

    private final String[] mais7Quina = {
            "04", "29", "31", "39", "49", "52", "53"
    };

    public Dados(Context context) {
        this.context = context;
    }

    public String[] getNumbersList() {
        return numbersList;
    }

    public String[] getMais7MegaSena() {
        return mais7MegaSena;
    }

    public String[] getMais7DuplaSena() {
        return mais7DuplaSena;
    }

    public String[] getMais7Lotofacil() {
        return mais7Lotofacil;
    }

    public String[] getMais7Quina() {
        return mais7Quina;
    }
}
