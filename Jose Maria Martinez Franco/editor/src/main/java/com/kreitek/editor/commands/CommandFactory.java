package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.Command;
import com.kreitek.editor.ExitException;

import java.util.ArrayList;

public class CommandFactory {
    private static Command previousCommand;
    private final CommandParser commandParser = new CommandParser();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        Command command = switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
        previousCommand = command;
        return command;
    }

    private Command createUndoCommand() {
        return new UndoCommand(previousCommand);
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text);
    }
}
