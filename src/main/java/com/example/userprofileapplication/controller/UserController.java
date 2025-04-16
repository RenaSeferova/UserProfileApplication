//package com.example.userprofileapplication.controller;
//import com.example.userprofileapplication.service.UserService;
////import org.apache.catalina.User;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
////import com.example.userprofileapplication.entity.User;
//import com.example.userprofileapplication.entity.User;
//
//
//import java.util.List;
//@RestController
//@RequestMapping("/users")
//public class UserController {
//    private final UserService userService; //DI
//
//    public UserController(UserService userService) { //
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<com.example.userprofileapplication.entity.User>> getAllUsers() {
//        return (ResponseEntity<List<com.example.userprofileapplication.entity.User>>) (ResponseEntity<List<com.example.userprofileapplication.entity.User>>) ResponseEntity.ok();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        return ResponseEntity.ok((User) userService.getUserById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
//        User updatedUser = userService.updateUser(id, userDetails);
//        return ResponseEntity.ok(updatedUser);
//    }
//}
package com.example.userprofileapplication.controller;

import com.example.userprofileapplication.entity.User;
import com.example.userprofileapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
