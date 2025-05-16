package com.gozic.NguyenTienMinh_ThucTapJava.Controller;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Service.Category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ModelAttributeCustomer {
    private final ICategoryService categoryService;

    @ModelAttribute(value = "categoryList")
    public List<CategoryResponse> renderListCategory() {
        return this.categoryService.findAll();
    }

    @ModelAttribute(value = "title")
    public String titleRender() {
        return "";
    }
}
