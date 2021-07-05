package cl.practica.desafio.mymarket.database;

import cl.practica.desafio.mymarket.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<StockEntity, Integer> {
}
