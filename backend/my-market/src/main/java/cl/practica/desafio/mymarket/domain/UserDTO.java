package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String name;
    private String lastname;
    private String dni;
    private int idRol;
    private String address;
    private String phone;
}
