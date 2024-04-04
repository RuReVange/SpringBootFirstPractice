package itmo.dev.springbootfirst.repositories;

import itmo.dev.springbootfirst.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

// в crudRepository<Класс, тип идентификатора класса>
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    public UserEntity findByUsername(String username);
}
