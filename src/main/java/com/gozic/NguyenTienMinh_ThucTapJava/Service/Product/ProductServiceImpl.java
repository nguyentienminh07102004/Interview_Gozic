package com.gozic.NguyenTienMinh_ThucTapJava.Service.Product;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.Product.ProductSearch;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product.ProductResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Product.ProductConvertor;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.CategoryEntity_;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity_;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IProductRepository;
import com.gozic.NguyenTienMinh_ThucTapJava.Service.Category.ICategoryService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final IProductRepository productRepository;
    private final ProductConvertor productConvertor;
    private final ICategoryService categoryService;

    @Override
    @Transactional(readOnly = true)
    public Map<String, List<ProductResponse>> findAll(ProductSearch search) {
        Specification<ProductEntity> specification = (root, query, builder) -> {
            Predicate predicate = builder.conjunction();
            if (StringUtils.hasText(search.getTitle())) {
                predicate = builder.like(builder.lower(root.get(ProductEntity_.TITLE)), "%" + search.getTitle().toLowerCase() + "%");
            }
            if (StringUtils.hasText(search.getCategoryCode())) {
                predicate = builder.or(
                        builder.equal(root.get(ProductEntity_.CATEGORY).get(CategoryEntity_.CODE), search.getCategoryCode()),
                        builder.equal(root.get(ProductEntity_.CATEGORY).get(CategoryEntity_.PARENT).get(CategoryEntity_.CODE), search.getCategoryCode())
                );
            }
            return predicate;
        };
        List<ProductResponse> products = this.productRepository.findAll(specification)
                .stream()
                .map(this.productConvertor::toResponse)
                .toList();
        Map<String, List<ProductResponse>> productResponses = new HashMap<>();
        for (CategoryResponse category : this.categoryService.findByCategory_ParentIsNull()) {
            productResponses.put(category.getName(), products.stream().filter(product -> {
                if (product.getCategory().getCode().equals(category.getCode())) {
                    return true;
                }
                return category.getChildren().contains(product.getCategory());
            }).toList());
        }
        return productResponses;
    }
}
