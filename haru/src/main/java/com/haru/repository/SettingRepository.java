package com.haru.repository;

import com.haru.entity.Memo;
import com.haru.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<User, Long> {
}
