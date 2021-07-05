package cl.practica.desafio.mymarket.database;
// EN LA INTERFAZ REPOSITORY DEFINIMOS QUE HERRAMIENTA DE METODOS USAREMOS
import cl.practica.desafio.mymarket.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {
}
