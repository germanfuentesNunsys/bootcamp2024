package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.EditorCaretaker;
import com.kreitek.editor.EditorMemento;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final EditorCaretaker caretaker;

    public UndoCommand(EditorCaretaker caretaker) {
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        EditorMemento memento = caretaker.undo();
        if (documentLines != null) {
            documentLines.clear();
            if(memento != null)
            documentLines.addAll(memento.getState());
        }
    }
}
