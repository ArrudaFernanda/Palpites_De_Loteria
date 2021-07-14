package com.a7apps.palpitesdeloteria.control;

import android.content.Context;
import java.util.ArrayList;

public class RemoveAdd {
    private Context context;

    public RemoveAdd(Context context) {
        this.context = context;
    }

    public void remover(ArrayList<String> arrayList, String a, String b, String c, String d, String e, String f, String g){
        arrayList.remove(a);
        arrayList.remove(b);
        arrayList.remove(c);
        arrayList.remove(d);
        arrayList.remove(e);
        arrayList.remove(f);
        arrayList.remove(g);
    }
    public void adicionar(ArrayList<String> arrayList, String a, String b, String c, String d, String e, String f, String g){
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        arrayList.add(e);
        arrayList.add(f);
        arrayList.add(g);
    }
}
