package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "stock", schema = "public")
public class StockEntity {

    public StockEntity(){}

    @Id
    @Column(name = "stock_id", nullable = false)
    private int stockId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
