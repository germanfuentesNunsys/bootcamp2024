package com.kreitek.editor;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    List<Memento> mementos = new ArrayList<>();

    public void push(Memento memento){
        mementos.add(memento);
        //Quitar
    }

    public Memento pop(){
        if(!mementos.isEmpty()){
            mementos.remove(mementos.size() - 1);
            //Quitar este print
            if(!mementos.isEmpty()){
                return mementos.get(mementos.size() - 1);
            }
        }
        return null;
    }
}
