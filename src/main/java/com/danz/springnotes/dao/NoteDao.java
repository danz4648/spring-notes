package com.danz.springnotes.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danz.springnotes.model.Note;

@Repository
public interface NoteDao extends CrudRepository<Note, String> {

}
