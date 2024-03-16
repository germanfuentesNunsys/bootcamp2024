package com.kreitek.editor.commands;

import java.util.ArrayList;

public class Memento {
    private final ArrayList<String> state;
    public Memento(ArrayList<String> state) {
        this.state = state;
    }

    public ArrayList<String> getState() {
        return state;
    }


}
