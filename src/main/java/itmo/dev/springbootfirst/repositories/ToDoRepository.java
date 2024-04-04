package itmo.dev.springbootfirst.repositories;

import itmo.dev.springbootfirst.entities.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDoEntity, Long> {

}