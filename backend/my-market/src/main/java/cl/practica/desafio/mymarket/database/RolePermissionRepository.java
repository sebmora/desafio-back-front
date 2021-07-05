package cl.practica.desafio.mymarket.database;

import cl.practica.desafio.mymarket.entity.RolePermissionEntity;
import org.springframework.data.repository.CrudRepository;

public interface RolePermissionRepository extends CrudRepository<RolePermissionEntity, String> {
}
