package com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegister {
    private String username;
    @Size(min = 8)
    private String password;
    @Size(min = 8)
    private String confirmPassword;
    @Email
    private String email;
}
