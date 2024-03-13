package com.kreitek.editor.memento;

import java.util.ArrayList;

public class EditorMemento {
    private ArrayList<String> state;

    public EditorMemento(ArrayList<String> state) {

        this.state = new ArrayList<>(state);

    }

    public ArrayList<String> getState() {
        return state;
    }
}
