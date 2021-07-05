package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolePermissionDTO {
    private Integer rolePermissionId;
    private Integer permissionId;
    private Integer IdRole;
}
