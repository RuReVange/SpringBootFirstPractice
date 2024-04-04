package itmo.dev.springbootfirst.controllers;

import itmo.dev.springbootfirst.entities.UserEntity;
import itmo.dev.springbootfirst.exceptions.UserAlreadyExistException;
import itmo.dev.springbootfirst.exceptions.UserNotFoundException;
import itmo.dev.springbootfirst.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registrationUsers(@RequestBody UserEntity userEntity) {

        try {
            userService.registrationUsers(userEntity);
            return ResponseEntity.ok("New user was saved");

        } catch (UserAlreadyExistException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Error");
        }
    }

    // RequestParam дает возможность при поступлении http запроса к серверу, считать query часть url запроса,
    // которая идет после знака ? в url
    @GetMapping
    public ResponseEntity<Object> getOneUser(@RequestParam Long id) {

        try {
            return ResponseEntity.ok(userService.getOneUser(id));

        } catch (UserNotFoundException e) {

            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Error");
        }
    }

    // PathVariable указывается для того, чтобы считать данные id из http запроса, который будет отправлен
    // Пример: http://localhost:8080/users/6 -> на сервер поступил этот запрос и наша программа сначала перезватит путь /users
    // и выберет UserController, а затем перейдет в метод deleteUser и в аргумент метода Long id, педедаст значение /{id} = 6
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(userService.deleteUser(id));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body("Error");
        }
    }
}
