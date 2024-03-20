package com.kreitek.editor;

import java.util.ArrayList;

public interface UndoableCommand extends Command {
    void undo(ArrayList<String> documentLines);
}
