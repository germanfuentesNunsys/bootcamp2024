package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private String deletedLine;
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (lineNumber < documentLines.size()) {
            deletedLine = documentLines.remove(lineNumber);
        }
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        if (deletedLine != null) {
            documentLines.add(lineNumber, deletedLine);
        }
    }
}
