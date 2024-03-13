package main.java.com.kreitek.editor;



import main.java.com.kreitek.editor.commands.CommandFactory;
import main.java.com.kreitek.editor.commands.Memento;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleEditor implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private final CommandFactory commandFactory = new CommandFactory();
    private ArrayList<String> documentLines = new ArrayList<String>();

    private Stack<Memento> stack = new Stack<>();

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                if (!commandLine.equals("undo")) {
                    saveUndoState();
                }
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines, stack);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                throw new RuntimeException(e);
            }
            showDocumentLines(documentLines);
            showHelp();
        }
    }

    private void saveUndoState() {
        stack.push(new Memento(documentLines));
    }

    private void undo() {
        if (!stack.isEmpty()) {
            documentLines = stack.pop().getDocumentLines();
        } else {
            printErrorToConsole("Nothing to undo");
        }
    }

    private void showDocumentLines(ArrayList<String> textLines) {
        if (textLines.size() > 0){
            setTextColor(TEXT_YELLOW);
            printLnToConsole("START DOCUMENT ==>");
            for (int index = 0; index < textLines.size(); index++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(index);
                stringBuilder.append("] ");
                stringBuilder.append(textLines.get(index));
                printLnToConsole(stringBuilder.toString());
            }
            printLnToConsole("<== END DOCUMENT");
            setTextColor(TEXT_RESET);
        }
    }

    private String waitForNewCommand() {
        printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        printLnToConsole("To add new line -> a \"your text\"");
        printLnToConsole("To update line  -> u [line number] \"your text\"");
        printLnToConsole("To delete line  -> d [line number]");
        printLnToConsole("To undo -> undo");
    }

    private void printErrorToConsole(String message) {
        setTextColor(TEXT_RED);
        printToConsole(message);
        setTextColor(TEXT_RESET);
    }

    private void setTextColor(String color) {
        System.out.println(color);
    }

    private void printLnToConsole(String message) {
        System.out.println(message);
    }

    private void printToConsole(String message) {
        System.out.print(message);
    }

}
