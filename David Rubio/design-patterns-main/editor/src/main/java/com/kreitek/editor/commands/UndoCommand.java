package com.kreitek.editor.commands;

import com.kreitek.editor.exceptions.NullEditMementoException;
import com.kreitek.editor.memento.EditorCareTaker;
import com.kreitek.editor.memento.EditorMemento;


import java.util.ArrayList;

public class UndoCommand implements Command {
    private final EditorCareTaker editorCareTaker;

    public UndoCommand(EditorCareTaker editorCareTaker) {
        this.editorCareTaker = editorCareTaker;
    }
    @Override
    public void execute(ArrayList<String> documentLines) throws NullEditMementoException {
        EditorMemento memento = editorCareTaker.undo();

        if (memento != null){
            if(documentLines.size() == 0){
                throw new NullEditMementoException();
            }
            documentLines.clear();
            documentLines.addAll(memento.getState());

        }
        else {
            throw new NullEditMementoException();
        }




    }


}
