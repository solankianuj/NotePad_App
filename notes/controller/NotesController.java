package com.example.notes.controller;

import com.example.notes.dto.NotesDTO;
import com.example.notes.model.NotesModel;
import com.example.notes.service.INotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    INotesServices iNotesServices;

    @PostMapping("/addnotes")
    public NotesModel addNotes( @RequestBody NotesDTO notesDTO){
        return iNotesServices.addNotes(notesDTO);
    }

    @GetMapping("/getnotelist")
    public List<NotesModel> getnotelist(){
        return iNotesServices.getNotes();
    }

    @GetMapping("/getnotes/{id}")
    public NotesModel getNote(@PathVariable long id){
        return iNotesServices.getNote(id);
    }

    @PutMapping("/updatenote/{id}")
    public NotesModel updateNote(@PathVariable long id,@RequestBody NotesDTO notesDTO){
        return iNotesServices.updateNotes(id, notesDTO);
    }

    @DeleteMapping("/deletenote/{id}")
    public NotesModel deleteNote(@PathVariable long id){
        return iNotesServices.deleteNotes(id);
    }
}
