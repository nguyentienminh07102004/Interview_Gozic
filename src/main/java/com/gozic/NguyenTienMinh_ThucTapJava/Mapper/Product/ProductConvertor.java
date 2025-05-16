package com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Product;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product.ProductResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Category.ICategoryMapper;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IProductFavouriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
@RequiredArgsConstructor
public class ProductConvertor {
    private final IProductMapper productMapper;
    private final ICategoryMapper categoryMapper;
    private final IProductFavouriteRepository productFavouriteRepository;

    public ProductResponse toResponse(ProductEntity productEntity) {
        ProductResponse productResponse = this.productMapper.toResponse(productEntity);
        DecimalFormat df = new DecimalFormat("#.##");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isFavourite = this.productFavouriteRepository.existsByProduct_IdAndUser_Username(productEntity.getId(), username);
        productResponse.setCategory(this.categoryMapper.toResponse(productEntity.getCategory()));
        productResponse.setPrice(Double.parseDouble(df.format(productEntity.getPrice() * productEntity.getDiscount())));
        productResponse.setFavourites(isFavourite);
        return productResponse;
    }
}
