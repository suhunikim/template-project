package com.example.project_backend.common.dto;

import com.example.project_backend.common.code.ErrorCode;
import lombok.Getter;

@Getter
public class ResponseDto<T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final ErrorResponse error;

    // private 생성자: 팩토리 메시지 메서드를 통해서만 생성 가능
    private ResponseDto(boolean sucess, String message, T data, ErrorResponse error) {
        this.success = sucess;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    // 성공 응답 생성 팩토리 메서드
    public static <T> ResponseDto<T> success(String message, T data) {
        return new ResponseDto<>(true, message, data, null);
    }

    // 실패 응답 생성 팩토리 메서드 (ErrorCode 사용)
    public static <T> ResponseDto<T> fail(ErrorCode errorCode) {
        return new ResponseDto<>(false, errorCode.getMessage(), null, ErrorResponse.of(errorCode));
    }

    // 실패 응답 생성 팩토리 메서드 (ErrorResponse)
    public static <T> ResponseDto<T> fail(ErrorResponse errorResponse) {
        return new ResponseDto<>(false, null, null, errorResponse);
    }
}
