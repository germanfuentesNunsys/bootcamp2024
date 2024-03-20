package com.kreitek.editor;

import java.util.ArrayList;
import java.util.List;

public class EditorCaretaker {
    private List<EditorMemento> mementos = new ArrayList<>();

    public void push(EditorMemento memento){
        mementos.add(memento);
    }

    public EditorMemento undo(){
        if (!mementos.isEmpty()) {
            mementos.remove(mementos.size() - 1);
            if (!mementos.isEmpty()) {
                return mementos.get(mementos.size() - 1);
            }
        }
        return null;
    }
}