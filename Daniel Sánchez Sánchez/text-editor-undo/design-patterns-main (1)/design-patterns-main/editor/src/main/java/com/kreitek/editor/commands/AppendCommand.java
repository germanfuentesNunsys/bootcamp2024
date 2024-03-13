package main.java.com.kreitek.editor.commands;



import main.java.com.kreitek.editor.Command;
import main.java.com.kreitek.editor.commands.Memento;

import java.util.ArrayList;
import java.util.Stack;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines, Stack<Memento> stack) {
        documentLines.add(text);
    }


}
