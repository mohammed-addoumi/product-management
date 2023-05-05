package org.example.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.product.ApiStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T body;
    private String message;
    private int code;

    private ApiResponse(T body) {
        this.body = body;
    }

    public static <T> ApiResponse<T> ok(T body) {
        return new ApiResponse<>(body);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>(null, message, ApiStatusCode.BAD_REQUEST.getCode());
    }

    public static <T> ApiResponse<T> created(T data, String message) {
        return new ApiResponse<>(data, message, ApiStatusCode.CREATED.getCode());
    }
}
