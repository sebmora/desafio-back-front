package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role", schema = "public")
public class RoleEntity {

    public RoleEntity() {}

    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}