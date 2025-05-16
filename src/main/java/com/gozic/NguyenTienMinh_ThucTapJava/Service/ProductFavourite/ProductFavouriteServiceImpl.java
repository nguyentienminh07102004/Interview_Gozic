package com.gozic.NguyenTienMinh_ThucTapJava.Service.ProductFavourite;

import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.AppException;
import com.gozic.NguyenTienMinh_ThucTapJava.ExceptionHandler.ExceptionVariable;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductFavouriteEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.UserEntity;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IProductFavouriteRepository;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IProductRepository;
import com.gozic.NguyenTienMinh_ThucTapJava.Repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductFavouriteServiceImpl implements IProductFavouriteService {
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;
    private final IProductFavouriteRepository productFavouriteRepository;

    @Override
    @Transactional
    public void favouriteProduct(String productId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (this.productFavouriteRepository.existsByProduct_IdAndUser_Username(productId, username)) {
            this.productFavouriteRepository.deleteByProduct_IdAndUser_Username(productId, username);
            return;
        }
        ProductEntity product = this.productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ExceptionVariable.PRODUCT_NOT_FOUND));
        UserEntity user = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException(ExceptionVariable.USER_NOT_FOUND));
        ProductFavouriteEntity productFavourite = new ProductFavouriteEntity();
        productFavourite.setProduct(product);
        productFavourite.setUser(user);
        this.productFavouriteRepository.save(productFavourite);
    }
}
