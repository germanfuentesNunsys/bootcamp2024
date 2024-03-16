package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final EditorCareTaker editorCareTaker;

    public UndoCommand(EditorCareTaker editorCareTaker) {
        this.editorCareTaker = editorCareTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        editorCareTaker.restore(documentLines);
    }
}
