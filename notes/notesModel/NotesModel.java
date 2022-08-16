package com.example.notes.notesModel;

import com.example.notes.notesDTO.NotesDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notesdata")
@Data
public class NotesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String note;
    private String description;
    private String labels;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public NotesModel(NotesDTO notesDTO) {
        this.note = notesDTO.getNote();
        this.description = notesDTO.getDescription();
        this.labels = notesDTO.getLabels();
    }

    public NotesModel() {

    }
}
