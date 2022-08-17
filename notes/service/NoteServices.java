package com.example.notes.service;

import com.example.notes.Exception.UserNotFound;
import com.example.notes.dto.NotesDTO;
import com.example.notes.model.NotesModel;
import com.example.notes.repository.INotesRepository;
import com.example.notes.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class NoteServices implements INotesServices {
    @Autowired
    INotesRepository iNotesRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Override
    public List<NotesModel> getNotes() {
        List<NotesModel> notesModels =iNotesRepository.findAll();
        if (notesModels.size()>0){
            return  notesModels;
        }
        throw  new UserNotFound(400,"NO Data Available !!");
    }

    @Override
    public NotesModel getNote(long id) {
//        Long id = tokenUtil.decodeToken(token);
        Optional<NotesModel> notesModel=iNotesRepository.findById(id);
        if (notesModel.isPresent()){
            return notesModel.get();
        }
        throw new UserNotFound(400,"Note Not Available");
    }

    @Override
    public NotesModel addNotes( NotesDTO notesDTO) {
        NotesModel notesModel =new NotesModel();
        notesModel.setNote(notesDTO.getNote());
        notesModel.setDescription(notesDTO.getDescription());
        notesModel.setLabels(notesDTO.getLabels());
        notesModel.setCreateTime(LocalDateTime.now());
        iNotesRepository.save(notesModel);
        return notesModel;
    }

    @Override
    public NotesModel updateNotes(long id, NotesDTO notesDTO) {
        NotesModel notesModel=this.getNote(id);
        notesModel.setNote(notesDTO.getNote());
        notesModel.setDescription(notesDTO.getDescription());
        notesModel.setLabels(notesDTO.getLabels());
        notesModel.setUpdateTime(LocalDateTime.now());
        iNotesRepository.save(notesModel);

        return notesModel;
        }

    @Override
    public NotesModel deleteNotes(long id) {
        NotesModel notesModel=this.getNote(id);
        iNotesRepository.delete(notesModel);
        return notesModel;
    }
}
