package com.example.nutri.services;

import com.example.nutri.domain.user.UserRepository;
import com.example.nutri.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    @Transactional
    public Long saveUser(UserDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long updateUser(UserDto dto) {
        return userRepository.save(dto.toEntity()).getId();
    }
}
