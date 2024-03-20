package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.Command;
import com.kreitek.editor.ExitException;

import java.util.ArrayList;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    private final ArrayList<Command> executedCommands = new ArrayList<>();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        Command command = null;

        switch (args[0]) {
            case "a":
                command = createAppendCommand(args[1]);
                break;
            case "u":
                command = createUpdateCommand(args[1], args[2]);
                break;
            case "d":
                command = createDeleteCommand(args[1]);
                break;
            case "undo":
                command = createUndoCommand();
                break;
            default:
                throw new ExitException();
        }

        if (command != null && !(command instanceof UndoCommand)) {
            executedCommands.add(command);
        }

        return command;
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);
    }

    private Command createUndoCommand() {
        // Implementar la lógica de deshacer aquí
        if (!executedCommands.isEmpty()) {
            Command lastCommand = executedCommands.remove(executedCommands.size() - 1);
            return new UndoCommand(lastCommand);
        } else {
            System.out.println("Nothing to undo");
            return null;
        }
    }
}
