package com.gozic.NguyenTienMinh_ThucTapJava.Repository;

import com.gozic.NguyenTienMinh_ThucTapJava.DTO.Response.Category.CategoryResponse;
import com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, String> {
    @Query(value = """
            select c.code 
                        from categories c 
            where not exists (select 1 from categories c1 where c.code = c1.parentcode)
            """, nativeQuery = true)
    List<String> findByCountChildrenIsNull();

    Optional<CategoryEntity> findByCode(String code);

    List<CategoryEntity> findByParentIsNull();
}
