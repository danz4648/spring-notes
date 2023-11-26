package com.danz.springnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danz.springnotes.dto.NoteDto;
import com.danz.springnotes.service.NoteService;

@Controller
public class NoteController {

    @Autowired
    private NoteService<NoteDto> noteService;

    // Mapping for frontend
    @GetMapping("/")
    public ModelAndView indexPage(ModelMap model, @AuthenticationPrincipal User user) {
        model.put("notes", noteService.getNotes(user.getUsername()));
        return new ModelAndView("index.html", model);
    }

    @GetMapping("/add")
    public ModelAndView addPage() {
        return new ModelAndView("add_note.html");
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity addData(@RequestBody NoteDto form, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(noteService.saveNote(form, user.getUsername()));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteNote(@PathVariable(value = "id") String noteid) {
        noteService.deleteNote(noteid);
        return new ModelAndView("redirect:/");
    }

}
