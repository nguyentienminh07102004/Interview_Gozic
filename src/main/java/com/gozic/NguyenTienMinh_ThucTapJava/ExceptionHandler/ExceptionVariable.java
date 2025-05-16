package com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionVariable {
    EMAIL_HAS_EXISTS(400, "Email has exists", HttpStatus.BAD_REQUEST),

    USERNAME_HAS_EXISTS(400, "Username has exists", HttpStatus.BAD_REQUEST),
    USERNAME_OR_EMAIL_NOT_FOUND(400, "Username or email not found", HttpStatus.BAD_REQUEST),

    PASSWORD_CONFIRM_PASSWORD_NOT_MATCH(400, "Password confirm password does not match", HttpStatus.BAD_REQUEST),
    OLD_PASSWORD_NEW_PASSWORD_MATCH(400, "Old password match new password", HttpStatus.BAD_REQUEST),

    CATEGORY_NOT_FOUND(400, "Category not found", HttpStatus.BAD_REQUEST),

    PRODUCT_NOT_FOUND(400, "Product not found", HttpStatus.BAD_REQUEST),

    USER_NOT_FOUND(400, "User not found", HttpStatus.BAD_REQUEST),
    ;
    private final Integer status;
    private final String message;
    private final HttpStatus httpStatus;
}
