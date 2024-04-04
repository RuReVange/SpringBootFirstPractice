package itmo.dev.springbootfirst.models;

// Класс, который имеет только те поля, которые будут использоваться на клиенте ()
// т.е. сущности, которыми мы обмениваемся с бд, и модели, которые получают клиент - это разные вещи
import itmo.dev.springbootfirst.entities.UserEntity;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String username;
    private List<ToDo> toDoList;

    public static User toModel(UserEntity userEntity) {

        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .toDoList(userEntity.getToDoEntityList().stream().map(ToDo::toModel).collect(Collectors.toList()))
                .build();
    }
}
