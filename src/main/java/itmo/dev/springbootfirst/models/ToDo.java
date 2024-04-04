package itmo.dev.springbootfirst.models;

import itmo.dev.springbootfirst.entities.ToDoEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {

    private Long id;
    private String title;
    private Boolean complete;

    public static ToDo toModel(ToDoEntity toDoEntity) {

        ToDo toDo = ToDo.builder()
                .id(toDoEntity.getId())
                .title(toDoEntity.getTitle())
                .complete(toDoEntity.isComplete())
                .build();
        return toDo;
    }
}
