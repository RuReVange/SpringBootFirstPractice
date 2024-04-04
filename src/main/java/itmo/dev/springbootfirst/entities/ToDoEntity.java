package itmo.dev.springbootfirst.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean complete;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
