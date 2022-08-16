package com.example.notes.userservices;

import com.example.notes.Exception.UserNotFound;
import com.example.notes.userModel.UserModel;
import com.example.notes.userRepository.IUserRepository;
import com.example.notes.userdto.UserDTO;
import com.example.notes.util.Response;
import com.example.notes.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements  IUserService{

    @Autowired
    IUserRepository iUserRepository;
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
    public UserModel addUser(UserDTO userDTO) {
        UserModel  userModel=new UserModel(userDTO);
        userModel.setCreatedDate(LocalDateTime.now());
        iUserRepository.save(userModel);
        return userModel;
    }

    @Override
    public UserModel updateUser(long id, UserDTO userDTO) {
        Optional<UserModel> userModel =iUserRepository.findById(id);
        if (userModel.isPresent()){
            userModel.get().setFname(userDTO.getFname());
            userModel.get().setLname(userDTO.getLname());
            userModel.get().setEmailID(userDTO.getEmailID());
            userModel.get().setPassword(userDTO.getPassword());
            userModel.get().setUpdatedDate(LocalDateTime.now());
            iUserRepository.save(userModel.get());
            return userModel.get();
        }
         throw new UserNotFound(400,"User Not Found !");
    }

        @Override
        public UserModel deleteUser(long id) {
        Optional<UserModel> userModel =iUserRepository.findById(id);
        if (userModel.isPresent()){
            iUserRepository.delete(userModel.get());
            return userModel.get();
        }
            throw new UserNotFound(400,"User Not Found !");
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
