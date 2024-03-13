package com.kreitek.editor.memento;

import com.kreitek.editor.exceptions.NullEditMementoException;

public interface EditorCareTakerInterface {
    EditorMementoInterface undo() throws NullEditMementoException;
    void save(EditorMementoInterface memento);
}
