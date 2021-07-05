package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    public UserEntity() {
    }

    @Id
    @Column(name = "dni")
    private String dni;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private int phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "birth")
    private Date birth;

    @OneToOne
    @JoinColumn(name = "id_role")
    private RoleEntity roleEntity;

}
