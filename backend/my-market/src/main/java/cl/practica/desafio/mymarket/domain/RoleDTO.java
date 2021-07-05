package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RoleDTO {
    private Integer roleId;
    private String title;
    private String description;
}
