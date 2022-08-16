package com.example.notes.userdto;

import com.example.notes.notesDTO.NotesDTO;
import lombok.Data;

@Data
public class UserDTO {
    private String fname;
    private String lname;
    private String emailID;
    private String password;
    private NotesDTO notes;
}
