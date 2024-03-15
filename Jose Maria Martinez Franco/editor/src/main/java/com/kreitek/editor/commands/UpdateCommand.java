package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String newText;
    private String oldText;
    private final int lineNumber;

    public UpdateCommand(String newText, int lineNumber) {
        this.newText = newText;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (lineNumber < documentLines.size()) {
            oldText = documentLines.set(lineNumber, newText);
        }
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        if (oldText != null) {
            documentLines.set(lineNumber, oldText);
        }
    }
}
