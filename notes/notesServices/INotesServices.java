package com.example.notes.notesServices;

import com.example.notes.notesDTO.NotesDTO;
import com.example.notes.notesModel.NotesModel;

import java.util.List;

public interface INotesServices {
//    List<NotesModel> getNotes();
    NotesModel addNotes(NotesDTO notesDTO);
//    NotesModel updateNotes(long id , NotesDTO notesDTO);
//    NotesModel deleteNotes(long id);
}
