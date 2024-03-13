package main.java.com.kreitek.editor.commands;

import main.java.com.kreitek.editor.Command;
import java.util.ArrayList;
import java.util.Stack;

public class UndoCommand implements Command {

    @Override
    public void execute(ArrayList<String> documentLines, Stack<Memento> stack) {
        if (!stack.isEmpty()) {
            documentLines.clear();
            documentLines.addAll(stack.pop().getDocumentLines());
        } else {
            System.out.println("Nothing to undo");
        }
    }

}
