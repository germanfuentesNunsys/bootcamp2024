package com.kreitek.editor.commands;

import java.util.ArrayList;

import com.kreitek.editor.Command;
import com.kreitek.editor.Memento.CaretakerEdit;
import com.kreitek.editor.Memento.Memento;



public class Undo implements Command{
    private CaretakerEdit caretaker;

    public Undo(CaretakerEdit caretaker){
        this.caretaker = caretaker;
    }
    @Override
    public void execute(ArrayList<String> documentLines) {
        Memento memento = caretaker.pop();
        caretaker.restore(memento, documentLines);
    }
        }
    
