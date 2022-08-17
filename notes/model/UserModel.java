package com.example.notes.model;

import com.example.notes.dto.NotesDTO;
import com.example.notes.dto.UserDTO;
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
    }

    public UserModel() {

    }
}
