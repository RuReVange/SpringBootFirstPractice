package itmo.dev.springbootfirst.controllers;

import itmo.dev.springbootfirst.entities.ToDoEntity;
import itmo.dev.springbootfirst.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    public ToDoService toDoService;

    @PostMapping
    public ResponseEntity<Object> createToDo(@RequestBody ToDoEntity toDoEntity,
                                             @RequestParam Long userId) {

        try {
            return ResponseEntity.ok().body(toDoService.createToDo(toDoEntity, userId));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping
    public ResponseEntity<Object> completeToDo(@RequestParam Long id) {

        try {
            return ResponseEntity.ok().body(toDoService.complete(id));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Error");
        }
    }
}
