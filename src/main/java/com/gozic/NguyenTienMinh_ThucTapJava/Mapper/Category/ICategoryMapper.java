package com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Category;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICategoryMapper {
    CategoryResponse toResponse(CategoryEntity categoryEntity);
}
