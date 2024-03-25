package com.kreitek.editor.commands;

import com.kreitek.editor.UndoableCommand;

import java.util.ArrayList;

public class UpdateCommand implements UndoableCommand {
    private final String newText;
    private final int lineNumber;
    private String oldText;

    public UpdateCommand(String newText, int lineNumber) {
        this.newText = newText;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        oldText = documentLines.set(lineNumber, newText);
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        documentLines.set(lineNumber, oldText);
    }
}
