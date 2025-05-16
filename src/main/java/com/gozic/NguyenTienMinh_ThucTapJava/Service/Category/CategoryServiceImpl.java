package com.gozic.NguyenTienMinh_ThucTapJava.Service.Category;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.AppException;
import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.ExceptionVariable;
import com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Category.ICategoryMapper;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.CategoryEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    private final ICategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> findAll() {
        List<String> categoryEntities = this.categoryRepository.findByCountChildrenIsNull();
        return categoryEntities.stream()
                .map(this::findByCode)
                .map(this.categoryMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryEntity findByCode(String code) {
        return this.categoryRepository.findByCode(code)
                .orElseThrow(() -> new AppException(ExceptionVariable.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryResponse> findByCategory_ParentIsNull() {
        return this.categoryRepository.findByParentIsNull()
                .stream()
                .map(this.categoryMapper::toResponse)
                .toList();
    }
}
