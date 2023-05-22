package com.example.nutri.controllers;

import com.example.nutri.domain.user.User;
import com.example.nutri.domain.user.UserRepository;
import com.example.nutri.dto.UserDto;
import com.example.nutri.dto.exception.ResourceNotFoundException;
import com.example.nutri.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist : " + id));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user/save")
    public void saveUser(@RequestBody UserDto dto) {
        userService.saveUser(dto);
    }

    @PutMapping("/user/update{id}")
    public void updateUser(@RequestBody UserDto dto){
        userService.updateUser(dto);
    }

    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist : " + id));
        userRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
