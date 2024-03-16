package com.kreitek.editor.commands;

import java.util.ArrayList;
import java.util.List;
public class EditorCareTaker {
    List<Memento> ListMementos = new ArrayList<>();
    public void push(Memento memento){
        ListMementos.add(memento);
    }

    public Memento pop(){
        if (ListMementos.size() > 0) {
            Memento memento = ListMementos.get(ListMementos.size() - 1);
            ListMementos.remove(ListMementos.size() - 1);
            return memento;
        }
        return null;
    }

    public void restore(ArrayList<String> documentLines) {
       // if (!ListMementos.isEmpty()) {
            //Memento memento = ListMementos.get(ListMementos.size() - 1);
           // ArrayList<String> state = memento.getState();
            documentLines.clear();
            documentLines.addAll(documentLines);
       // }
    }
}
