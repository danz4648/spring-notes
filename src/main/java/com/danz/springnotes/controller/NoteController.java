package com.danz.springnotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danz.springnotes.dto.NoteDto;
import com.danz.springnotes.request.NoteForm;
import com.danz.springnotes.service.NoteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
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
    public ModelAndView addPage(@ModelAttribute(name = "note_form") NoteForm form, ModelMap model,
            @AuthenticationPrincipal User user) {
        NoteDto dto = new NoteDto();
        dto.setName(form.getName());
        dto.setDescription(form.getDescription());
        if (noteService.saveNote(dto, user.getUsername())) {
            log.info(form.toString());
            model.put("status", "Success add data");
            return new ModelAndView("redirect:/");
        } else {
            model.put("error", "Failed to save Note");
            return new ModelAndView("index.html", model);
        }
    }

}
