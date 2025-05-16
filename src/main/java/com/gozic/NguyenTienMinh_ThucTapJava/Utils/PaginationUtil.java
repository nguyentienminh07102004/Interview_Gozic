package com.gozic.NguyenTienMinh_ThucTapJava.Utils;

import org.springframework.data.domain.PageRequest;

public class PaginationUtil {
    public static PageRequest pagination(Integer page, Integer limit) {
        if (page == null || page < 0) {
            page = 1;
        }
        if (limit == null || limit < 0) {
            limit = 4;
        }
        return PageRequest.of(page - 1, limit);
    }
}
