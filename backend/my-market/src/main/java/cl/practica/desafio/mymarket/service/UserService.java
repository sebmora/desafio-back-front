package cl.practica.desafio.mymarket.service;


import cl.practica.desafio.mymarket.database.UserRepository;
import cl.practica.desafio.mymarket.domain.UserDTO;
import cl.practica.desafio.mymarket.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUser() {
        List<UserDTO> resultado = new ArrayList<>();

        userRepository.findAll().forEach(userEntity -> resultado.add(
                UserDTO.builder()
                        .name(userEntity.getName())
                        .idRol(userEntity.getRol())
                        .dni(userEntity.getDni())
                        .address(userEntity.getAddress())
                        .build()
                )
        );
        return resultado;
    }

    public String createUser(UserDTO user) {

        log.info("Insertando el dato " + user);

        UserEntity userEntity = new UserEntity();
        userEntity.setDni(user.getDni());
        userEntity.setName(user.getName());
        userEntity.setRol(user.getIdRol());
        userEntity.setAddress(user.getAddress());

        userRepository.save(userEntity);
        return "usuario insertado";
    }

    public String updateUser(UserDTO user) {
        //TODO : implementar esta seccion
        return null;
    }

    public String deleteUser(String dni) {
        //TODO : implementar esta seccion
        return null;
    }
}

