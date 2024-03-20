package com.kreitek.editor.commands;

import java.util.Stack;

import com.kreitek.editor.*;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    private final EditorCaretaker editorCaretaker = new EditorCaretaker();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand() {
        return new UndoCommand(editorCaretaker);
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number, editorCaretaker);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number, editorCaretaker);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text, editorCaretaker);
    }

}
