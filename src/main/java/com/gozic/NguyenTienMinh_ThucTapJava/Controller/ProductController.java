package com.gozic.NguyenTienMinh_ThucTapJava.Controller;

import com.gozic.NguyenTienMinh_ThucTapJava.Service.ProductFavourite.IProductFavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {
    private final IProductFavouriteService productFavouriteService;

    @PostMapping(value = "/favorite-product/{productId}")
    public String likeProduct(@PathVariable String productId) {
        this.productFavouriteService.favouriteProduct(productId);
        return "redirect:/";
    }
}
