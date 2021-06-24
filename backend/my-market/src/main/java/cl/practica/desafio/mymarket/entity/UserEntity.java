package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    public UserEntity() {
    }

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "rol_id", nullable = false)
    private int rol;

    @Column(name = "address", nullable = false)
    private String address;
}
