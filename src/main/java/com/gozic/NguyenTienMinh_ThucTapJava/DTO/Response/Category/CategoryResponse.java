package com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private String id;
    private String name;
    private String code;
    private List<CategoryResponse> children;

    @Override
    public boolean equals(Object categoryResponse) {
        if (!(categoryResponse instanceof CategoryResponse)) {
            return false;
        }
        return this.code.equals(((CategoryResponse)categoryResponse).getCode());
    }
}
