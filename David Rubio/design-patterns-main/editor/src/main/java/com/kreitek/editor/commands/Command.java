package com.kreitek.editor.commands;

import com.kreitek.editor.exceptions.NullEditMementoException;

import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> documentLines) throws NullEditMementoException;
}
