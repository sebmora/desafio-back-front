package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "review", schema = "public")
@SequenceGenerator(name = "review_id_seq")
public class ReviewEntity {

    public ReviewEntity(){
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private int reviewId;

    @Column(name = "subject")
    private String subject;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;
    //Preguntar por variable Date

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    //ASIGNAR LLAVE FORANEA COMO NO NULO

}

