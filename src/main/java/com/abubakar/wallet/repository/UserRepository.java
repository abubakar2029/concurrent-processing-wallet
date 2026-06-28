package com.abubakar.wallet.repository;

import com.abubakar.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
