package main.java.com.kreitek.editor.commands;

import main.java.com.kreitek.editor.Command;

import java.util.ArrayList;
import java.util.Stack;

public class DeleteCommand implements Command {
    private final int lineNumber;

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines, Stack<Memento> stack) {
        documentLines.remove(lineNumber);
    }


}
