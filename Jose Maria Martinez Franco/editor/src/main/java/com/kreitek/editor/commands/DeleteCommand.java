package com.kreitek.editor.commands;

import com.kreitek.editor.UndoableCommand;

import java.util.ArrayList;

public class DeleteCommand implements UndoableCommand {
    private final int lineNumber;
    private String deletedLine;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        deletedLine = documentLines.remove(lineNumber);
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
        documentLines.add(lineNumber, deletedLine);
    }
}
