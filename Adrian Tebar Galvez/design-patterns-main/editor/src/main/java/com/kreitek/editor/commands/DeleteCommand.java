package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.Memento.CaretakerEdit;
import com.kreitek.editor.Memento.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    //
    private CaretakerEdit caretaker;

    public DeleteCommand(int lineNumber,  CaretakerEdit caretaker) {
        this.lineNumber = lineNumber;
        ///
        this.caretaker = caretaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
        //
        Memento memento = new Memento(new ArrayList<>(documentLines));
        caretaker.push(memento);
    }
}
