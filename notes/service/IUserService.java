package com.example.notes.service;

import com.example.notes.model.UserModel;
import com.example.notes.dto.UserDTO;
import com.example.notes.util.Response;

import java.util.List;

public interface IUserService {
    List<UserModel> getUSer();
     UserModel addUser(UserDTO userDTO,Long notesId);
    UserModel updateUser(String token,UserDTO userDTO);
    UserModel deleteUser(String token);

    UserModel getUserData(String token);

    Response login(String emil,String password);
}
