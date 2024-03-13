package com.kreitek.editor.commands;

import com.kreitek.editor.exceptions.NullEditMementoException;
import com.kreitek.editor.memento.EditorCareTaker;
import com.kreitek.editor.memento.EditorCareTakerInterface;
import com.kreitek.editor.memento.EditorMemento;
import com.kreitek.editor.memento.EditorMementoInterface;


import java.util.ArrayList;

public class UndoCommand implements Command {
    private final EditorCareTakerInterface editorCareTaker;

    public UndoCommand(EditorCareTakerInterface editorCareTaker) {
        this.editorCareTaker = editorCareTaker;
    }
    @Override
    public void execute(ArrayList<String> documentLines) throws NullEditMementoException {
        EditorMementoInterface memento = editorCareTaker.undo();

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
