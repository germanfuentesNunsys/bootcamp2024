package main.java.com.kreitek.editor.commands;


import main.java.com.kreitek.editor.Command;

import java.util.ArrayList;
import java.util.Stack;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }
    @Override
    public void execute(ArrayList<String> documentLines, Stack<Memento> stack) {
        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }

}
