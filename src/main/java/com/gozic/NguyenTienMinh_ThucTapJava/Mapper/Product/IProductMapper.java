package com.gozic.NguyenTienMinh_ThucTapJava.Mapper.Product;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product.ProductResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {
    ProductResponse toResponse(ProductEntity productEntity);
}
