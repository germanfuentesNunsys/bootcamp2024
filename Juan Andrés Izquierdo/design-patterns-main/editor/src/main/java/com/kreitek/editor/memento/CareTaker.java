package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementos = new ArrayList<>();

    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento getByIndex(int index) {
        if (index < 0 || index >= mementos.size())
            return null;

        return mementos.get(index);
    }

    public int size() {
        return mementos.size();
    }
}
