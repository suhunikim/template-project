package com.example.project_backend.api.user.controller;

import com.example.project_backend.api.user.dto.LoginResponseDto;
import com.example.project_backend.api.user.dto.UserLoginRequestDto;
import com.example.project_backend.api.user.dto.UserResponseDto;
import com.example.project_backend.api.user.dto.UserSignUpRequestDto;
import com.example.project_backend.api.user.service.UserService;
import com.example.project_backend.common.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto<UserResponseDto>> signUp (@Valid @RequestBody UserSignUpRequestDto userSignUpRequestDto) {
        UserResponseDto registerUser = userService.registerUser(userSignUpRequestDto);
        return ResponseEntity.ok(ResponseDto.success("사용자 등록 성공", registerUser));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginResponseDto>> login (@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        LoginResponseDto loggedInUser = userService.login(userLoginRequestDto);
        return ResponseEntity.ok(ResponseDto.success("로그인 성공", loggedInUser));
    }

}
