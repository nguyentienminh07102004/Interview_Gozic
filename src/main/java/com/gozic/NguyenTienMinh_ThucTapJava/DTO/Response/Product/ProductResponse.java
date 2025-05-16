package com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String title;
    private Double price;
    private Double discount;
    private String image;
    private CategoryResponse category;
    private boolean isFavourites;
}
