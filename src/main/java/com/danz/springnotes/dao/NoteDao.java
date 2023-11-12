package com.danz.springnotes.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danz.springnotes.model.Note;

@Repository
public interface NoteDao extends CrudRepository<Note, String> {

    List<Note> findByUserid(String userid);
}
