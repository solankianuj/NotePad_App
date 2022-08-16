package com.example.notes.userservices;

import com.example.notes.userModel.UserModel;
import com.example.notes.userdto.UserDTO;
import com.example.notes.util.Response;

import java.util.List;

public interface IUserService {
    List<UserModel> getUSer();
     UserModel addUser(UserDTO userDTO);
    UserModel updateUser(long id,UserDTO userDTO);
    UserModel deleteUser(long id);

    UserModel getUserData(String token);

    Response login(String emil,String password);
}
