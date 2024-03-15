package com.kreitek.editor;

import java.util.ArrayList;

public class Memento {
    private final ArrayList<String> documentLines;

    public Memento(ArrayList<String> documentLines) {
        this.documentLines = new ArrayList<>(documentLines);
    }

    public ArrayList<String> getDocumentLines() {
        return documentLines;
    }
}
