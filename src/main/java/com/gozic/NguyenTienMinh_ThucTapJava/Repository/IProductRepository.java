package com.gozic.NguyenTienMinh_ThucTapJava.Repository;

import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, String>, JpaSpecificationExecutor<ProductEntity> {
    @Query(value = """
                select p.id, c.parentcode from products p
                inner join categories c on c.code = p.categoryCode
            """, nativeQuery = true)
    Map<String, String> findAllByCategory(String category);
}
