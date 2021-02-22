package com.ndirangu.superdrive.service;

import com.ndirangu.superdrive.mapper.UserMapper;
import com.ndirangu.superdrive.model.User;
import com.ndirangu.superdrive.service.security.HashService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public int createUser(User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);

        user.setSalt(encodedSalt);
        user.setPassword(hashedPassword);
        return userMapper.insert(user);
    }

    public boolean isUsernameAvailable(String username) {
        return userMapper.getUser(username) == null;
    }

    public User getUser(String username) {
        return userMapper.getUser(username);
    }

}
