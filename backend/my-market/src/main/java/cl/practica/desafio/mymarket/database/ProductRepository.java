package cl.practica.desafio.mymarket.database;

// EN LA INTERFAZ REPOSITORY DEFINIMOS QUE HERRAMIENTA DE METODOS USAREMOS
import cl.practica.desafio.mymarket.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
