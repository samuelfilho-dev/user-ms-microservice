package com.ms.user.controllers;

import com.ms.user.controllers.dto.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto data) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(data, userModel);
        var dbUser = service.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(dbUser);
    }
}
