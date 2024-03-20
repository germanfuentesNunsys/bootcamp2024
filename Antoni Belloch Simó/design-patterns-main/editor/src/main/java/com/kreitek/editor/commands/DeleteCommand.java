package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.EditorCaretaker;
import com.kreitek.editor.EditorMemento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private final EditorCaretaker caretaker;


    public DeleteCommand(int lineNumber, EditorCaretaker caretaker) {
        this.lineNumber = lineNumber;
        this.caretaker = caretaker;

    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
        ArrayList<String> documentLinesCopy = new ArrayList<>(documentLines);
        EditorMemento save = new EditorMemento(documentLinesCopy);
        caretaker.push(save);
    }
}
