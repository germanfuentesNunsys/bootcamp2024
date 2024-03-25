package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final Command commandToUndo;

    public UndoCommand(Command commandToUndo) {
        this.commandToUndo = commandToUndo;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (commandToUndo != null) {
            commandToUndo.undo(documentLines);
        }
    }

    @Override
    public void undo(ArrayList<String> documentLines) {
    }
}
