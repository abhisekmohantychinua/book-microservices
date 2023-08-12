package dev.abhisek.userservice.service;

import dev.abhisek.userservice.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserByUserId(Integer id);

    User addUser(User user);

    void deleteUser(Integer id);

    User updateUser(Integer id, User user);
}
