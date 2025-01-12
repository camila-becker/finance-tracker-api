package com.becker.finance_tracker_api.repository;

import com.becker.finance_tracker_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
