package com.example.notes.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull
    private String fname;
    private String lname;
    private String emailID;
    private String password;
    private NotesDTO notes;
}
