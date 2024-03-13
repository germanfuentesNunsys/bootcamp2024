package com.kreitek.editor.memento;

import com.kreitek.editor.exceptions.NullEditMementoException;

import java.util.ArrayList;

public class EditorCareTaker implements EditorCareTakerInterface{

    private ArrayList<EditorMementoInterface> mementos =  new ArrayList<>();

    public EditorCareTaker() {
        this.mementos.add(new EditorMemento(new ArrayList<>()));
    }

    @Override
    public EditorMementoInterface undo() throws NullEditMementoException {
        EditorMementoInterface memento = null;
        if (mementos.size() > 1){

            mementos.remove(mementos.size() - 1);
            memento = mementos.get(mementos.size() - 1);
            mementos.remove(mementos.size() - 1);

        }else {
            memento = mementos.get(0);

        }
        return memento;

    }
    @Override
    public void save(EditorMementoInterface memento) {
        mementos.add(memento);
    }
}
