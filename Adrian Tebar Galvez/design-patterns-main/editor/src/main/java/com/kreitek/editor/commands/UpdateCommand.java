package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.Memento.CaretakerEdit;
import com.kreitek.editor.Memento.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private CaretakerEdit caretaker;

    public UpdateCommand(String text, int lineNumber, CaretakerEdit caretaker) {
        this.text = text;
        this.lineNumber = lineNumber;
     //
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
            //
            Memento memento = new Memento(new ArrayList<>(documentLines));
            caretaker.push(memento);
    }
}
