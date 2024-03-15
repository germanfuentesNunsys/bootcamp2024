package com.kreitek.editor.commands;

import com.kreitek.editor.Command;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private final Command previousCommand;

    public UndoCommand(Command previousCommand) {
        this.previousCommand = previousCommand;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        previousCommand.undo(documentLines);
    }

    @Override
    public void undo(ArrayList<String> documentLines) {

    }
}
