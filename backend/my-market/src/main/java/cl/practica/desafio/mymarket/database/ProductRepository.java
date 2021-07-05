package cl.practica.desafio.mymarket.database;


import cl.practica.desafio.mymarket.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, String> {

}
