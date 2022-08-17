package com.example.notes.controller;

import com.example.notes.model.UserModel;
import com.example.notes.dto.UserDTO;
import com.example.notes.service.IUserService;
import com.example.notes.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/getuserlist")
    public List<UserModel> getUser(){
        return iUserService.getUSer();
    }

    @GetMapping("/getuser")
    public  UserModel getuser(@RequestHeader String token){
        return iUserService.getUserData(token);
    }

    @PostMapping("/addUser")
    public UserModel addUser(@RequestParam(value = "notesId") Long notesId,@RequestBody UserDTO userDTO){
       return iUserService.addUser(userDTO,notesId);
    }

    @PutMapping("/updateuser")
    public UserModel updateUser(@RequestParam(value = "token" ) String token ,@RequestBody UserDTO userDTO){
        return iUserService.updateUser(token, userDTO);
    }

    @DeleteMapping("/deleteUser")
    public UserModel deleteUser(@RequestParam(value = "token" ) String token){
        return iUserService.deleteUser(token);
    }

    @PostMapping("login")
    public Response login (@RequestParam String email,@RequestParam String password){
        return iUserService.login(email, password);
    }

}
