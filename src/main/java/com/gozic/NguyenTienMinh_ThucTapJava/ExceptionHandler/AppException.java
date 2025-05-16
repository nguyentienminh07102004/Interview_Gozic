package com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AppException extends RuntimeException {
    private final ExceptionVariable exceptionVariable;
}
