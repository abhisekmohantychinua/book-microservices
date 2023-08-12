package dev.abhisek.userservice.controller;

import dev.abhisek.userservice.entity.User;
import dev.abhisek.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity
                .ok(userService.getAllUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable Integer id) {
        return ResponseEntity
                .ok(userService.getUserByUserId(id));
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity
                .ok(userService.addUser(user));
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        return ResponseEntity
                .accepted()
                .body(userService.updateUser(id, user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}
