package com.example.notes.noteController;

import com.example.notes.notesDTO.NotesDTO;
import com.example.notes.notesModel.NotesModel;
import com.example.notes.notesServices.INotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    INotesServices iNotesServices;

    @PostMapping("/addnotes")
    public NotesModel addNotes(@RequestBody NotesDTO notesDTO){
        return iNotesServices.addNotes(notesDTO);
    }
}
