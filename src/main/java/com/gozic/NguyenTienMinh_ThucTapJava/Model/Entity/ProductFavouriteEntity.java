package com.gozic.NguyenTienMinh_ThucTapJava.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productFavourites")
@Getter
@Setter
public class ProductFavouriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "userUsername", referencedColumnName = "username")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;
}
