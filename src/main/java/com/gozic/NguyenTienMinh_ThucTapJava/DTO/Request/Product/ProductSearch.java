package com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.Product;

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
public class ProductSearch {
    private String categoryCode;
    private String title;
}
