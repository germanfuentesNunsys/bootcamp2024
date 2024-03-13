package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.EditorCaretaker;
import com.kreitek.editor.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private EditorCaretaker caretaker;

    public UpdateCommand(String text, int lineNumber, EditorCaretaker caretaker) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
        ArrayList<String> documentLinesCopy = new ArrayList<>(documentLines);
        Memento memento = new Memento(documentLinesCopy);
        caretaker.push(memento);
    }
}
