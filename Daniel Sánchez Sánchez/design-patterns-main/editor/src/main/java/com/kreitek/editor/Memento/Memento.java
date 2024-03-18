package main.java.com.kreitek.editor.Memento;

import java.util.ArrayList;

public class Memento
{
    private ArrayList<String> state;
    public Memento(ArrayList<String> state)
    {
        this.state = state;
    }

    public ArrayList<String> getState()
    {
        return state;
    }
}
