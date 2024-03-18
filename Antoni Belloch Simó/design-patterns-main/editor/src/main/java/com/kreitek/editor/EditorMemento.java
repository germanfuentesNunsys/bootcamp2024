package com.kreitek.editor;

import java.util.ArrayList;

public class EditorMemento {
    private ArrayList<String> state;

    public EditorMemento(ArrayList<String> documentLines){
        this.state = documentLines;
    }

    public ArrayList<String> getState(){
        return this.state;
    }
}
