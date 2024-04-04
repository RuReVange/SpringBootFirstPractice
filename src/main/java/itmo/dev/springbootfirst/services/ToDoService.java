package itmo.dev.springbootfirst.services;

import itmo.dev.springbootfirst.entities.ToDoEntity;
import itmo.dev.springbootfirst.entities.UserEntity;
import itmo.dev.springbootfirst.models.ToDo;
import itmo.dev.springbootfirst.repositories.ToDoRepository;
import itmo.dev.springbootfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private UserRepository userRepository;

    // т.е. данные об аргументах получаются из http запроса, @RequestBody и @RequestParam в контроллере
    // считывают нужные части запроса и отправляют в аргументы метода сервиса
    public ToDo createToDo(ToDoEntity toDoEntity, Long userId) {

        UserEntity userEntity = userRepository.findById(userId).get();
        toDoEntity.setUserEntity(userEntity);

        return ToDo.toModel(toDoRepository.save(toDoEntity));
    }

    public ToDo complete(Long id) {

        ToDoEntity toDoEntity = toDoRepository.findById(id).get();
        toDoEntity.setComplete(!toDoEntity.isComplete());

        return ToDo.toModel(toDoRepository.save(toDoEntity));
    }
}
