//package com.example.flix.service;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.flix.model.Login;
//import com.example.flix.repository.LoginRepository;
//
//@Service
//public class LoginService {
//    @Autowired
//    private LoginRepository userRepo;
//
//    public boolean postUser(Login user){
//        
//        userRepo.save(user);
//        return true;
//
//    }
//
//    public boolean verifyUser(Login user){
//       Login u =   userRepo.verifyUser(user.getEmail(), user.getPassword());
//
//       if(u!=null)
//       return true;
//
//       return false;
//    }
//}
