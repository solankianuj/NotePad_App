package com.example.notes.model;
import com.example.notes.dto.NotesDTO;
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

}
