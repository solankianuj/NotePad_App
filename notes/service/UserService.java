package com.example.notes.service;

import com.example.notes.Exception.UserNotFound;
import com.example.notes.dto.NotesDTO;
import com.example.notes.model.NotesModel;
import com.example.notes.model.UserModel;
import com.example.notes.repository.INotesRepository;
import com.example.notes.repository.IUserRepository;
import com.example.notes.dto.UserDTO;
import com.example.notes.util.Response;
import com.example.notes.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    INotesRepository iNotesRepository;
    @Autowired
    TokenUtil tokenUtil;

    @Override
    public List<UserModel> getUSer() {
        List<UserModel> userModels =iUserRepository.findAll();
        if (userModels.size()>0){
            return userModels;
        }
        throw  new UserNotFound(400,"NO Data Available !!");
    }

    @Override
    public UserModel addUser(UserDTO userDTO, Long notesId) {
        Optional<NotesModel> notesModel =iNotesRepository.findById(notesId);
        UserModel  userModel=new UserModel(userDTO);

        if (notesModel.isPresent()){
            userModel.setNotes(notesModel.get());
        }
        userModel.setCreatedDate(LocalDateTime.now());
        iUserRepository.save(userModel);
        return userModel;
    }

    @Override
    public UserModel updateUser(String token, UserDTO userDTO) {
        UserModel userModel=this.getUserData(token);
        userModel.setFname(userDTO.getFname());
        userModel.setLname(userDTO.getLname());
        userModel.setEmailID(userDTO.getEmailID());
        userModel.setPassword(userDTO.getPassword());
        userModel.setUpdatedDate(LocalDateTime.now());
            iUserRepository.save(userModel);
            return userModel;

    }

    @Override
    public UserModel deleteUser(String token) {
        UserModel userModel=this.getUserData(token);
            iUserRepository.delete(userModel);
            return userModel;

        }

    @Override
    public UserModel getUserData(String token) {
        Long id= tokenUtil.decodeToken(token);
        Optional<UserModel> userModel =iUserRepository.findById(id);
            if (userModel.isPresent()){
                return userModel.get();
            }
      throw new UserNotFound(400,"User Not Found !");
    }

    @Override
    public Response login(String emil, String password) {
       Optional<UserModel> userModel=iUserRepository.findByEmailID(emil);
       if (userModel.isPresent()){
           if (userModel.get().getPassword().equals(password)){
               String token=tokenUtil.createToken(userModel.get().getUserId());
               return new Response("Login Success Full",200,token);
           }
           throw new UserNotFound(400,"Invalid Cedentials");
       }
       throw new UserNotFound(400,"User Not Found !");
    }
}
