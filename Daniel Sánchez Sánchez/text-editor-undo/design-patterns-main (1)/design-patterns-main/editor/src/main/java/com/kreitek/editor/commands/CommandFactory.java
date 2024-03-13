package main.java.com.kreitek.editor.commands;


import main.java.com.kreitek.editor.BadCommandException;
import main.java.com.kreitek.editor.Command;
import main.java.com.kreitek.editor.ExitException;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();

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

    private Command createUndoCommand() throws BadCommandException {
        return (Command) new UndoCommand();
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return (Command) new DeleteCommand(number);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return (Command) new UpdateCommand(text, number);
    }

    private Command createAppendCommand(String text) {
        return (Command) new AppendCommand(text);
    }

}
