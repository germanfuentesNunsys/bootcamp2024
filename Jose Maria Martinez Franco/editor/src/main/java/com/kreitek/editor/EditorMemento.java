package com.kreitek.editor;

import java.util.ArrayList;

public class EditorMemento {
    private final ArrayList<String> documentLines;

    public EditorMemento(ArrayList<String> documentLines) {
        this.documentLines = new ArrayList<>(documentLines);
    }

    public ArrayList<String> getDocumentLines() {
        return documentLines;
    }
}
