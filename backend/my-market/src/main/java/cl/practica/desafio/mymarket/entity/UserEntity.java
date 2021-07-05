package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    public UserEntity() {
    }

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "birth", nullable = false)
    private Date birth;

    @Column(name = "id_role", nullable = false)
    private int role;
}
