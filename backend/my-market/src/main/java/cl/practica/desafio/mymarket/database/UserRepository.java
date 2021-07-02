package cl.practica.desafio.mymarket.database;


import cl.practica.desafio.mymarket.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {

}