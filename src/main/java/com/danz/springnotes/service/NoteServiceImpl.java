package com.danz.springnotes.service;

import java.util.Date;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danz.springnotes.dao.NoteDao;
import com.danz.springnotes.dto.NoteDto;
import com.danz.springnotes.model.Note;

@Service(value = "noteService")
public class NoteServiceImpl implements NoteService<NoteDto> {

    @Autowired
    private NoteDao noteDao;

    @Override
    public List<NoteDto> getNotes(String userid) {
        return StreamSupport.stream(noteDao.findByUserid(userid).spliterator(), false)
                .map(data -> {
                    NoteDto dto = new NoteDto();
                    dto.setName(data.getName());
                    dto.setId(data.getUid());
                    dto.setDescription(data.getDescription());
                    dto.setCreatedDate(Date.from(data.getCreatedDate()));
                    dto.setLastModDate(Date.from(data.getModifiedDate()));
                    return dto;
                }).toList();
    }

    @Override
    public boolean saveNote(NoteDto note, String userid) {

        Note model = new Note();
        model.setUserid(userid);
        model.setName(note.getName());
        model.setDescription(note.getDescription());

        return noteDao.save(model) != null;
    }

}
