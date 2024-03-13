package com.kreitek.editor.memento;

import com.kreitek.editor.exceptions.NullEditMementoException;

import java.util.ArrayList;

public class EditorCareTaker {

    private ArrayList<EditorMemento> mementos = new ArrayList<>();

    public EditorCareTaker() {
        this.mementos.add(new EditorMemento(new ArrayList<>()));
    }


    public EditorMemento undo() throws NullEditMementoException {
        EditorMemento memento = null;
        if (mementos.size() > 1){

            mementos.remove(mementos.size() - 1);
            memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);

        }else {
            memento = mementos.get(0);

        }
        return memento;

    }

    public void save(EditorMemento memento) {
        mementos.add(memento);
    }
}
