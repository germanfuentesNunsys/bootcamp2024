package main.java.com.kreitek.editor.Memento;

import java.util.ArrayList;
import java.util.List;
public class EditorCaretaker
{
    private List<Memento> mementoList = new ArrayList<>();
    public void push(Memento memento)
    {
        mementoList.add(memento);
    }

    public Memento getIndex(int index)
    {
        if (index < 0 || index >= mementoList.size())
            return null;

        return mementoList.get(index);
    }

    public int size()
    {
        return mementoList.size();
    }
}