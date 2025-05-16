package com.gozic.NguyenTienMinh_ThucTapJava.Repository;

import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductFavouriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductFavouriteRepository extends JpaRepository<ProductFavouriteEntity, String> {
    boolean existsByProduct_IdAndUser_Username(String productId, String username);

    void deleteByProduct_IdAndUser_Username(String productId, String userUsername);
}
