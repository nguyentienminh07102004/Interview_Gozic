package com.gozic.NguyenTienMinh_ThucTapJava.Service.User;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserForgotPassword;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserRegister;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.User.UserResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.AppException;
import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.ExceptionVariable;
import com.gozic.NguyenTienMinh_ThucTapJava.Mapper.UserMapper;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.UserEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponse registerUser(UserRegister user) {
        if (this.userRepository.existsByUsername(user.getUsername())) {
            throw new AppException(ExceptionVariable.USERNAME_HAS_EXISTS);
        }
        if (this.userRepository.existsByEmail(user.getEmail())) {
            throw new AppException(ExceptionVariable.EMAIL_HAS_EXISTS);
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new AppException(ExceptionVariable.PASSWORD_CONFIRM_PASSWORD_NOT_MATCH);
        }
        UserEntity userEntity = this.userMapper.toEntity(user);
        userEntity.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(userEntity);
        return this.userMapper.toResponse(userEntity);
    }

    @Override
    public void forgotPassword(UserForgotPassword user) {
        UserEntity userEntity = this.userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new AppException(ExceptionVariable.USERNAME_OR_EMAIL_NOT_FOUND));
        if (!userEntity.getEmail().equals(user.getEmail())) {
            throw new AppException(ExceptionVariable.USERNAME_OR_EMAIL_NOT_FOUND);
        }
        if (this.passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            throw new AppException(ExceptionVariable.OLD_PASSWORD_NEW_PASSWORD_MATCH);
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            throw new AppException(ExceptionVariable.PASSWORD_CONFIRM_PASSWORD_NOT_MATCH);
        }
        userEntity.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(userEntity);
    }
}
