package com.kreitek.editor.commands;

import com.kreitek.editor.UndoableCommand;

import java.util.ArrayList;

public class AppendCommand implements UndoableCommand {
    private final String text;
    private int index;
    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        index = documentLines.size();
        documentLines.add(text);
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        documentLines.remove(index);
    }
}
