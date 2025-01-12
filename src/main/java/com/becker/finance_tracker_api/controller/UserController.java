package com.becker.finance_tracker_api.controller;

import com.becker.finance_tracker_api.domain.dto.UserRequestDTO;
import com.becker.finance_tracker_api.domain.dto.UserResponseDTO;
import com.becker.finance_tracker_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}
