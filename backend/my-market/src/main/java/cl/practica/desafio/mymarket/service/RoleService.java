package cl.practica.desafio.mymarket.service;
// LOS SERVICES PERTENECEN AL PATRON DE DISENO FACADE

import cl.practica.desafio.mymarket.database.RoleRepository;
import cl.practica.desafio.mymarket.domain.RoleDTO;
import cl.practica.desafio.mymarket.entity.RoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

//import cl.practica.desafio.mymarket.domain.PermissionDTO;
//import cl.practica.desafio.mymarket.entity.PermissionEntity;

@Component
@Slf4j
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDTO> getRole() {
        List<RoleDTO> resultado = new ArrayList<>();

        roleRepository.findAll().forEach(roleEntity -> resultado.add(
                RoleDTO.builder()
                    .roleId(roleEntity.getRoleId())
                    .title(roleEntity.getTitle())
                    .description(roleEntity.getDescription())
                    .build()
        ));
        return resultado;
    }

    public String createRole(RoleDTO role) {
        if (roleRepository.existsById(role.getRoleId())) {
            return "El rol ya existe";
        } else {
            log.info("Insertando el producto" + role);

            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(role.getRoleId());
            roleEntity.setTitle(role.getTitle());
            roleEntity.setDescription(role.getDescription());

            roleRepository.save(roleEntity);
            return "Rol ingresado";
        }
    }

    public String updateRole(RoleDTO role) {
        if (roleRepository.findById(role.getRoleId()).isPresent()){
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(role.getRoleId());
            roleEntity.setTitle(role.getTitle());
            roleEntity.setDescription(role.getDescription());

            roleRepository.save(roleEntity);
            return "Rol actualizado";
        }
        else {
            return "No se ha encontrado el rol";
        }

    }

    public String deleteRole(Integer role) {
        if (roleRepository.findById(role).isPresent()){
            roleRepository.deleteById(role);
            return "Producto eliminado";
        }
        else{
            return "No se ha encontrado el producto";
        }
    }

}
