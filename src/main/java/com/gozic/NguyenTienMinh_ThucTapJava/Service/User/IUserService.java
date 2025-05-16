package com.gozic.NguyenTienMinh_ThucTapJava.Service.User;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserForgotPassword;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserRegister;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.User.UserResponse;

public interface IUserService {
    UserResponse registerUser(UserRegister user);
    void forgotPassword(UserForgotPassword user);
}
