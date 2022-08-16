package com.example.notes.userModel;

import com.example.notes.notesDTO.NotesDTO;
import com.example.notes.notesModel.NotesModel;
import com.example.notes.userdto.UserDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "userdata")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String fname;
    private String lname;
    private String emailID;
    private String password;
    @OneToOne
    private NotesModel notes;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public UserModel(UserDTO userDTO) {
        this.fname= userDTO.getFname();
        this.lname= userDTO.getLname();
        this.emailID= userDTO.getEmailID();
        this.password= userDTO.getPassword();
        NotesModel notesModel1=mapNotes(userDTO.getNotes());
        this.notes=notesModel1;

    }

    private NotesModel mapNotes(NotesDTO notesDTO) {
        NotesModel model=new NotesModel();
        model.setNote(notesDTO.getNote());
        model.setDescription(notesDTO.getDescription());
        model.setLabels(notesDTO.getLabels());
        return model;
    }

    public UserModel() {

    }
}
