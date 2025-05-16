package com.gozic.NguyenTienMinh_ThucTapJava.Service.Product;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.Product.ProductSearch;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product.ProductResponse;

import java.util.List;
import java.util.Map;

public interface IProductService {
    Map<String, List<ProductResponse>> findAll(ProductSearch search);
}
