package cl.practica.desafio.mymarket.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role_permission", schema = "public")
public class RolePermissionEntity {

    public RolePermissionEntity() {}

    @Id
    @Column(name = "role_permission_id")
    private Integer rolePermissionId;

    @Column(name = "permission_id")
    private Integer permissionId;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity roleEntity;
}
