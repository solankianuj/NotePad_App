package com.example.notes.usercontroller;

import com.example.notes.userModel.UserModel;
import com.example.notes.userdto.UserDTO;
import com.example.notes.userservices.IUserService;
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
    public UserModel addUser(@RequestBody UserDTO userDTO){
       return iUserService.addUser(userDTO);
    }

    @PutMapping("/updateuser/{id}")
    public UserModel updateUser(@PathVariable long id ,@RequestBody UserDTO userDTO){
        return iUserService.updateUser(id, userDTO);
    }

    @DeleteMapping("/deleteUser/{id}")
    public UserModel deleteUser(@PathVariable long id){
        return iUserService.deleteUser(id);
    }

    @PostMapping("login")
    public Response login (@RequestParam String email,@RequestParam String password){
        return iUserService.login(email, password);
    }

}
