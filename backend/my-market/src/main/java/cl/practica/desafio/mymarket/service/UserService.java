package cl.practica.desafio.mymarket.service;
// LOS SERVICES PERTENECEN AL PATRON DE DISENO FACADE
import cl.practica.desafio.mymarket.database.UserRepository;
import cl.practica.desafio.mymarket.domain.RoleDTO;
import cl.practica.desafio.mymarket.domain.UserDTO;
import cl.practica.desafio.mymarket.entity.UserEntity;
import cl.practica.desafio.mymarket.entity.RoleEntity;
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

        userRepository.findAll().forEach(userEntity -> {
            RoleDTO role = RoleDTO.builder()
                    .roleId(userEntity.getRoleEntity().getRoleId())
                    .title(userEntity.getRoleEntity().getTitle())
                    .description(userEntity.getRoleEntity().getDescription())
                    .build();
            resultado.add(
                            UserDTO.builder()
                                    .dni(userEntity.getDni())
                                    .username(userEntity.getUsername())
                                    .password(userEntity.getPassword())
                                    .name(userEntity.getName())
                                    .lastname(userEntity.getLastname())
                                    .address(userEntity.getAddress())
                                    .phone(userEntity.getPhone())
                                    .mail(userEntity.getMail())
                                    .birth(userEntity.getBirth())
                                    // Encadenacion de objetos a traves de las fk
                                    .role(String.valueOf(role.getRoleId()))
                                    .title(userEntity.getRoleEntity().getTitle())
                                    .description(userEntity.getRoleEntity().getDescription())
                                    .build()
                    );
                }
        );
        return resultado;
    }

    public String createUser(UserDTO user) {
        if (userRepository.existsById(user.getDni())) {
            return "El usuario ya existe";
        } else {
            // Composicion de obj. (Crear un objeto dentro de otro)
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(Integer.valueOf(user.getRole()));
            roleEntity.setTitle(user.getTitle());
            roleEntity.setDescription(user.getDescription());
            System.out.println("Datos almacenados del rol " + roleEntity);

            log.info("Insertando el dato " + user);

            UserEntity userEntity = new UserEntity();
            userEntity.setDni(user.getDni());
            userEntity.setUsername(user.getUsername());
            userEntity.setPassword(user.getPassword());
            userEntity.setName(user.getName());
            userEntity.setLastname(user.getLastname());
            userEntity.setAddress(user.getAddress());
            userEntity.setPhone(user.getPhone());
            userEntity.setMail(user.getMail());
            userEntity.setBirth(user.getBirth());
            userEntity.setRoleEntity(roleEntity);

            userRepository.save(userEntity);
            return "Usuario insertado";
        }
    }

    public String updateUser(UserDTO user) {

       if (userRepository.findById(user.getDni()).isPresent()){

           RoleEntity roleEntity = new RoleEntity();
           roleEntity.setRoleId(Integer.valueOf(user.getRole()));
           roleEntity.setTitle(user.getTitle());
           roleEntity.setDescription(user.getDescription());

           UserEntity userEntity = new UserEntity();
           userEntity.setDni(user.getDni());
           userEntity.setUsername(user.getUsername());
           userEntity.setPassword(user.getPassword());
           userEntity.setName(user.getName());
           userEntity.setLastname(user.getLastname());
           userEntity.setAddress(user.getAddress());
           userEntity.setPhone(user.getPhone());
           userEntity.setMail(user.getMail());
           userEntity.setBirth(user.getBirth());
           userEntity.setRoleEntity(roleEntity);

           userRepository.save(userEntity);
           return "Usuario actualizado";
       }
       else{
           return "No se ha encontrado el usuario";
       }

    }

    public String deleteUser(String dni) {
        if (userRepository.findById(dni).isPresent()){
            userRepository.deleteById(dni);
            return "Usuario eliminado";
        }
        else{
            return "No se ha encontrado el usuario";
        }

    }
}

