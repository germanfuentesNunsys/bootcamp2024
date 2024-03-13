package main.java.com.kreitek.editor;

import main.java.com.kreitek.editor.commands.Memento;

import java.util.ArrayList;
import java.util.Stack;

public interface Command {
    void execute(ArrayList<String> documentLines, Stack<Memento> stack);

}
