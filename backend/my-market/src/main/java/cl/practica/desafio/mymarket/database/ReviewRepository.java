package cl.practica.desafio.mymarket.database;


import cl.practica.desafio.mymarket.entity.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, Integer> {
}
