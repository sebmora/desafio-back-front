package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product", schema = "public")
public class ProductEntity {

    public ProductEntity() {
    }

    @Id
    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "productEntity")
    private List<ReviewEntity> reviewList;

}

