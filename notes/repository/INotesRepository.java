package com.example.notes.repository;

import com.example.notes.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotesRepository extends JpaRepository<NotesModel, Long> {
}
