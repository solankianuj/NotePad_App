package com.example.notes.notesServices;

import com.example.notes.notesDTO.NotesDTO;
import com.example.notes.notesModel.NotesModel;
import com.example.notes.userRepository.INotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class NoteServices implements INotesServices {
    @Autowired
    INotesRepository iNotesRepository;

//    @Override
//    public List<NotesModel> getNotes() {
//        return null;
//    }

    @Override
    public NotesModel addNotes(NotesDTO notesDTO) {
        NotesModel notesModel =new NotesModel(notesDTO);
        notesModel.setNote(notesDTO.getNote());
        notesModel.setLabels(notesDTO.getLabels());
        notesModel.setDescription(notesDTO.getDescription());
        notesModel.setCreateTime(LocalDateTime.now());
        iNotesRepository.save(notesModel);
        return notesModel;
    }

//    @Override
//    public NotesModel updateNotes(long id, NotesDTO notesDTO) {
//        return null;
//    }
//
//    @Override
//    public NotesModel deleteNotes(long id) {
//        return null;
//    }
}
