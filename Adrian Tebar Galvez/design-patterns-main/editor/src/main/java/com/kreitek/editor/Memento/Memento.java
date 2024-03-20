package com.kreitek.editor.Memento;

import java.util.ArrayList;


public class Memento {
    private final ArrayList<String> state;

    public Memento(ArrayList<String> state) {
        this.state = new ArrayList<>(state);
    }

    public ArrayList<String> getState() {
        return new ArrayList<>(state); 
    }
}
