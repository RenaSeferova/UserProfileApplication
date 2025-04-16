package com.example.userprofileapplication.service;

import com.example.userprofileapplication.entity.Post;
import com.example.userprofileapplication.entity.User;
import com.example.userprofileapplication.exception.ResourceNotFoundException;
import com.example.userprofileapplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> getAllUsers() {  //get
        return userRepository.findAll();
    }

    public User getUserById(Long id) {  //getById
        return (User) userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User createUser(User user) {  //create
        if (user.getPosts() != null) {
            Post posts = user.getPosts();
            posts.setUser(user);
        }
   return userRepository.save(user);

    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);  //Anar user
        user.setName(userDetails.getName()); //setName = Aqil
        user.setProfile(userDetails.getProfile()); //

        return userRepository.save(user);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

