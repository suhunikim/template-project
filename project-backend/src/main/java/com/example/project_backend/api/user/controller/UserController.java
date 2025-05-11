package com.example.project_backend.api.user.controller;

import com.example.project_backend.api.user.dto.LoginResponseDto;
import com.example.project_backend.api.user.dto.UserLoginRequestDto;
import com.example.project_backend.api.user.dto.UserResponseDto;
import com.example.project_backend.api.user.dto.UserSignUpRequestDto;
import com.example.project_backend.api.user.service.UserService;
import com.example.project_backend.common.dto.ResponseDto;
import com.example.project_backend.configuration.security.CustomUserDetails;
import com.example.project_backend.domain.user.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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

    // 아이디 + 비밀번회 등 민감한 정보는 HTTP Body에 담아야 안전하게 전달하므로 PostMapping 사용
    @PostMapping("/login")
    public ResponseEntity<ResponseDto<LoginResponseDto>> login (@Valid @RequestBody UserLoginRequestDto userLoginRequestDto) {
        LoginResponseDto loggedInUser = userService.login(userLoginRequestDto);
        return ResponseEntity.ok(ResponseDto.success("로그인 성공", loggedInUser));
    }

    @GetMapping("/me")
    public ResponseEntity<ResponseDto<UserResponseDto>> getCurrentUser(@AuthenticationPrincipal CustomUserDetails userDetails) {
        User user = userDetails.getUser();
        UserResponseDto userResponseDto = UserResponseDto.fromEntity(user);
        return ResponseEntity.ok(ResponseDto.success("사용자 정보 조회 성공", userResponseDto));
    }
}
