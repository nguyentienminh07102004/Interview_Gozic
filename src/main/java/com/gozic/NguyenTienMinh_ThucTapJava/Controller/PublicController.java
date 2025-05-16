package com.gozic.NguyenTienMinh_ThucTapJava.Controller;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.Product.ProductSearch;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserForgotPassword;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Request.User.UserRegister;
import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Product.ProductResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Service.Product.IProductService;
import com.gozic.NguyenTienMinh_ThucTapJava.Service.User.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PublicController {
    private final IUserService userService;
    private final IProductService productService;

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping(value = "/")
    public ModelAndView home(@ModelAttribute ProductSearch search) {
        Map<String, List<ProductResponse>> pages = this.productService.findAll(search);
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", pages);
        modelAndView.addObject("title", StringUtils.hasText(search.getTitle()) ? search.getTitle() : "");
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView register(@ModelAttribute UserRegister user) {
        ModelAndView modelAndView = new ModelAndView("login");
        this.userService.registerUser(user);
        return modelAndView;
    }

    @GetMapping(value = "/forgot-password")
    public ModelAndView forgotPassword() {
        return new ModelAndView("forgotPassword");
    }

    @PostMapping(value = "/forgot-password")
    public ModelAndView forgotPassword(@ModelAttribute UserForgotPassword user) {
        this.userService.forgotPassword(user);
        return new ModelAndView("login");
    }

    @GetMapping(value = "/intro")
    public ModelAndView intro() {
        return new ModelAndView("intro");
    }
}
