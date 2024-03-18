package main.java.com.kreitek.editor.commands;

import main.java.com.kreitek.editor.Command;
import main.java.com.kreitek.editor.ConsoleEditor;

import java.util.ArrayList;

public class UndoCommand implements Command
{
    private final ConsoleEditor consoleEditor;
    public UndoCommand(ConsoleEditor editor) {
        this.consoleEditor = editor;
    }

    @Override
    public void execute(ArrayList<String> documentLines)
    {
        if (consoleEditor.statesSize() > 0) {
            consoleEditor.setState(consoleEditor.latestState());
        }
    }

}
