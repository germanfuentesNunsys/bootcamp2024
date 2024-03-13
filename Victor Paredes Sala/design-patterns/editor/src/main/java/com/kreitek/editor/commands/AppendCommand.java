package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.EditorCaretaker;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private EditorCaretaker caretaker;

    public AppendCommand(String text, EditorCaretaker caretaker) {
        this.text = text;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        ArrayList<String> documentLinesCopy = new ArrayList<>(documentLines);
        Memento memento = new Memento(documentLinesCopy);
        caretaker.push(memento);
    }
}
