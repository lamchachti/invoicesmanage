package org.eyupcompany.invoicesmanage.controllers;

import org.eyupcompany.invoicesmanage.dto.requests.UserRequest;
import org.eyupcompany.invoicesmanage.dto.responses.UserResponse;
import org.eyupcompany.invoicesmanage.exceptions.EntityNotFoundException;
import org.eyupcompany.invoicesmanage.models.UserEntity;
import org.eyupcompany.invoicesmanage.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest  userRequest){
        UserResponse user_logged=userService.login(userRequest);
        return ResponseEntity.ok(user_logged);

    }
}
