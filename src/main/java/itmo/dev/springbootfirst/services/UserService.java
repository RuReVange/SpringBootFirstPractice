package itmo.dev.springbootfirst.services;

import itmo.dev.springbootfirst.entities.UserEntity;
import itmo.dev.springbootfirst.exceptions.UserAlreadyExistException;
import itmo.dev.springbootfirst.exceptions.UserNotFoundException;
import itmo.dev.springbootfirst.models.User;
import itmo.dev.springbootfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registrationUsers(UserEntity userEntity) throws UserAlreadyExistException {

            if (userRepository.findByUsername(userEntity.getUsername()) != null) {

                throw new UserAlreadyExistException("User with the same username already exist");
            }

            return userRepository.save(userEntity);
    }

    public User getOneUser(Long id) throws UserNotFoundException {

        UserEntity tmpUserEntity = userRepository.findById(id).get();
        if (tmpUserEntity == null) {
            throw new UserNotFoundException("User wasn't found");
        }

        return User.toModel(tmpUserEntity);
    }

    public Long deleteUser(Long id) {

        userRepository.deleteById(id);
        return id;
    }
}