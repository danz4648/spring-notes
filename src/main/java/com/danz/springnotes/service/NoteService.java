package com.danz.springnotes.service;

import java.util.List;

public interface NoteService<T> {
    public List<T> getNotes();

    public boolean saveNote(T note);
}
