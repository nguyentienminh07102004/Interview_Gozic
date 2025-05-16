package com.gozic.NguyenTienMinh_ThucTapJava.Mapper;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserRegister;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.User.UserResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity toEntity(UserRegister userRegister);
    UserResponse toResponse(UserEntity userEntity);
}
