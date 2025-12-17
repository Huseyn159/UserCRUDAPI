package az.huseyn.usercrudapi.service;

import az.huseyn.usercrudapi.exception.EmailAlreadyExistsException;
import az.huseyn.usercrudapi.exception.UserNotFoundException;
import az.huseyn.usercrudapi.model.UserEntity;
import az.huseyn.usercrudapi.repository.UserRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Create
    public UserEntity createUser(UserEntity userEntity) {
      boolean emailExists = userRepository.existsByEmail(userEntity.getEmail());
      if (emailExists) {
          throw new EmailAlreadyExistsException("Email already exists!");

      }


        return userRepository.save(userEntity);
    }

    //Read
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User with id " + id + " not found!")
        );
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    //Uptade

    public UserEntity uptadeUser(Long id,UserEntity userEntity){
        UserEntity oldUser = userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User with id " + id + " not found!")
        );

        oldUser.setFirstName(userEntity.getFirstName());
        oldUser.setLastName(userEntity.getLastName());
        oldUser.setPhoneNumber(userEntity.getPhoneNumber());
        oldUser.setEmail(userEntity.getEmail());
        return userRepository.save(oldUser);

    }

    //Delete

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
