package com.example.notes.service;

import com.example.notes.dto.NotesDTO;
import com.example.notes.model.NotesModel;

import java.util.List;

public interface INotesServices {
    List<NotesModel> getNotes();
    NotesModel getNote(long id);
    NotesModel addNotes(NotesDTO notesDTO);
    NotesModel updateNotes(long id , NotesDTO notesDTO);
    NotesModel deleteNotes(long id);
}
