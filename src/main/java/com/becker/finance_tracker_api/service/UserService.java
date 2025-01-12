package com.becker.finance_tracker_api.service;

import com.becker.finance_tracker_api.domain.User;
import com.becker.finance_tracker_api.domain.dto.UserRequestDTO;
import com.becker.finance_tracker_api.domain.dto.UserResponseDTO;
import com.becker.finance_tracker_api.mappers.user.UserMapper;
import com.becker.finance_tracker_api.repository.UserRepository;
import com.becker.finance_tracker_api.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserResponseDTO create(UserRequestDTO request) {
        String hashedPassword = PasswordUtil.hashPassword(request.password());
        LocalDateTime createdAt = LocalDateTime.now();

        User user = mapper.toUser(request);
        user.setPassword(hashedPassword);
        user.setCreatedAt(createdAt);

        return mapper.toResponseDTO(repository.save(user));
    }

}
