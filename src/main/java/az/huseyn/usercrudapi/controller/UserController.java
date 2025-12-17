package az.huseyn.usercrudapi.controller;

import az.huseyn.usercrudapi.model.UserEntity;
import az.huseyn.usercrudapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    //C
    @PostMapping
    public UserEntity create(@Valid @RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    //R
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //U
    @PutMapping("/{id}")
    public UserEntity uptadeUser(@PathVariable long id,@Valid @RequestBody UserEntity userEntity){

        return userService.uptadeUser(id,userEntity);
    }

    //D
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
