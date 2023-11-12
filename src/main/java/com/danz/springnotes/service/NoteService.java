package com.danz.springnotes.service;

import java.util.List;

public interface NoteService<T> {
    public List<T> getNotes(String userid);

    public boolean saveNote(T note, String userid);

    public boolean deleteNote(String noteid);
}
