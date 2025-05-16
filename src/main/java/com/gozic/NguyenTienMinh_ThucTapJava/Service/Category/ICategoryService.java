package com.gozic.NguyenTienMinh_ThucTapJava.Service.Category;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> findAll();

    CategoryEntity findByCode(String code);

    List<CategoryResponse> findByCategory_ParentIsNull();
}
