package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RoleDTO {
    private Integer roleId;
    private String title;
    private String description; //Revisar el tema de los atr.
}
