package com.kreitek.editor.Memento;
import java.util.ArrayList;
import java.util.List;

public class CaretakerEdit{
    private List<Memento> mementos;
    
    public CaretakerEdit() {
        mementos = new ArrayList<>();
    }

    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento pop() {
        if (!mementos.isEmpty()) {
            mementos.remove(mementos.size() - 1);
            if (!mementos.isEmpty()) {
                return mementos.get(mementos.size() - 1);
            }
        }
        return null;
    }
    public void restore(Memento memento, ArrayList<String> documentLines) {
        if (memento != null) {
            documentLines.clear();
            documentLines.addAll(memento.getState());
        }
}
}