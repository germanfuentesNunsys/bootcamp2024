package com.kreitek.editor.commands;

import java.util.ArrayList;

import com.kreitek.editor.Command;
import com.kreitek.editor.EditorCaretaker;
import com.kreitek.editor.Memento;

public class UndoCommand implements Command{
    private EditorCaretaker caretaker;

    public UndoCommand(EditorCaretaker caretaker){
        this.caretaker = caretaker;
    }
    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = caretaker.pop();
        if(documentLines != null){
            documentLines.clear();
            if(memento != null){
                documentLines.addAll(memento.getState());
            }
        }
    }
}
