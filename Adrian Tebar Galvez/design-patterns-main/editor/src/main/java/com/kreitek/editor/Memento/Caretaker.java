package com.kreitek.editor.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker{
    List<Memento> mementos = new ArrayList<>();
    public void  push(Memento memento){
        mementos.add(memento);
    }
}