package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.Memento.CaretakerEdit;
import com.kreitek.editor.Memento.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private CaretakerEdit caretaker;

    public AppendCommand(String text,CaretakerEdit caretaker) {
        this.text = text;
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        Memento memento = new Memento(new ArrayList<>(documentLines));
        caretaker.push(memento);
    }
}
