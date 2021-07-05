package cl.practica.desafio.mymarket.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDTO {
    private String dni;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String address;
    private Integer phone;
    private String mail;
    private Date birth;
    private String role;
    private String title;
    private String description;
}
