package com.becker.finance_tracker_api.domain.dto;

import java.time.LocalDateTime;

public record UserResponseDTO(Long id, String name, String email, String phoneNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {}
