package dev.abhisek.userservice.service.impl;

import dev.abhisek.userservice.entity.User;
import dev.abhisek.userservice.repository.UserRepository;
import dev.abhisek.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserId(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Integer id, User user) {
        User user1 = userRepository
                .findById(id)
                .orElseThrow();
        user.setId(user1.getId());
        return userRepository.save(user);
    }
}
