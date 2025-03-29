package com.example.project_backend.api.user.dto;

import com.example.project_backend.common.code.UserRole;
import com.example.project_backend.common.code.UserStatus;
import com.example.project_backend.domain.user.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String password;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private UserStatus status;
    private String statusDescription;
    private UserRole role;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime lastLogin;

    private String department;
    private String position;
    private String jobTitle;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hireDate;

    private Long managerId;

    public static UserResponseDto fromEntity(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.userId = user.getUserId();
        dto.password = user.getPassword();
        dto.userName = user.getUserName();
        dto.userEmail = user.getUserEmail();
        dto.phoneNumber = user.getPhoneNumber();
        dto.status = user.getStatus();
        dto.role = user.getRole();
        dto.lastLogin = user.getLastLogin();
        dto.department = user.getDepartment();
        dto.position = user.getPosition();
        dto.jobTitle = user.getJobTitle();
        dto.hireDate = user.getHireDate();
        dto.managerId = user.getManagerId();
        return dto;
    }
}
