package com.example.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;

@Service
public class UserService {
   @Autowired
   private UserRepo userRepo;
   
   @SuppressWarnings("null")
public boolean postUser(User user)
   {
        try{
            userRepo.save(user);
            return true;
        }
        catch(Exception e){
            return false;
        }   
   }

   public User getById(int userId)
   {
        return userRepo.findByUserId(userId);
   }

   public User getByUserName(String userName)
   {
        return userRepo.findByUserName(userName);
   }
}
