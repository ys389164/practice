package com.haru.repository;

import com.haru.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("DELETE FROM User u WHERE u.userId = :idx")
    void deleteByUserId(@Param("idx") Long userId);

    @Query("SELECT u FROM User u WHERE u.userId = :idx")
    User findById(@Param("idx") Long userId);

    void deleteById(Long userId);
}
