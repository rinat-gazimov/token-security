package ru.springboot.app.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.springboot.app.dto.TokenDTO;
import ru.springboot.app.dto.UserDTO;
import ru.springboot.app.model.User;
import ru.springboot.app.service.user.UserService;

import java.util.UUID;

@Controller
//@RequestMapping("/app/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody  UserDTO userDTO) {
        return ResponseEntity.ok(userService.login(userDTO));
    }

    @PostMapping("/register")
    public ResponseEntity<UUID> register(@RequestBody  UserDTO userDTO) {
        return ResponseEntity.ok(userService.register(userDTO));
    }



//    @GetMapping("/users")
//    public List<UserDto> getUsers() {
//        return from(usersService.findAll());
//    }
//
//    @GetMapping("/users/{user-id}")
//    public User getUser(@PathVariable("user-id") Long userId) {
//        return usersService.findOne(userId);
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
//        usersService.signUp(userForm);
//        return ResponseEntity.ok().build();
//    }





}
