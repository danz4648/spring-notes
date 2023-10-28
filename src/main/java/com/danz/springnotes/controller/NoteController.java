package com.danz.springnotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    // Mapping for frontend
    @GetMapping("/")
    public ModelAndView indexPage(ModelMap model) {
        model.put("test", "Hello World");
        return new ModelAndView("index.html", model);
    }
}
