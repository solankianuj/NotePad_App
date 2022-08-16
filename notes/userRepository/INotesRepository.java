package com.example.notes.userRepository;

import com.example.notes.notesModel.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotesRepository extends JpaRepository<NotesModel, Long> {
}
